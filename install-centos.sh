#!/bin/bash
#!/bin/sh
#
# This script installs all dependencies for Firewall-on-Demand running in Python3
# with Celery, Redis, and sqlite.
#

SCRIPT_NAME="install-centos.sh"

fod_dir="/srv/flowspy"
venv_dir="/srv/venv"

inside_docker=0

install_basesw=1
install_fodproper=1

ensure_installed_pythonenv_wrapper=1

# workaround for old Django with old OS sqlite3 (CENTOS7 only):
try_fixup_for_old_os_sqlite=1
use_old_django_version__autodetect=1

##
##############################################################################
##############################################################################

if [ -e "/.dockerenv" ]; then 
  echo "running inside docker assummed" 1>&2
  inside_docker=1
fi
##############################################################################
##############################################################################
while [ $# -gt 0 ]; do

  if [ $# -ge 1 -a "$1" = "--here" ]; then
    shift 1
    fod_dir="$PWD"
    venv_dir="$PWD/venv"
  elif [ $# -ge 1 -a "$1" = "--base_dir" ]; then
    shift 1
    base_dir="$1"
    shift 1
    fod_dir="$base_dir/flowspy"
    venv_dir="$base_dir/venv"
  elif [ $# -ge 1 -a "$1" = "--fod_dir" ]; then
    shift 1
    fod_dir="$1"
    shift 1
  elif [ $# -ge 1 -a "$1" = "--venv_dir" ]; then
    shift 1
    venv_dir="$1"
    shift 1
  elif [ $# -ge 1 -a "$1" = "--both" ]; then
    shift 1
    install_basesw=1
    install_fodproper=1
  elif [ $# -ge 1 -a "$1" = "--basesw" ]; then 
    shift 1
    install_basesw=1
    install_fodproper=0
  elif [ $# -ge 1 -a "$1" = "--fodproper" ]; then
    shift 1
    install_basesw=0
    install_fodproper=1
  else
    break
  fi

done

if [ $# -gt 0 ]; then
  echo "remaining unprocessed arguments: $*, aborting" 1>&2
  exit 2
fi

##

#set -x

##
  
venv_dir_base="$(dirname "$venv_dir")"

static_dir="$fod_dir/static"

inst_dir="$(dirname "$0")"

mkdir -p "$fod_dir" || exit

if [ "$(stat -Lc "%i" "$inst_dir/" "$fod_dir/" | sort -n -k 1 -u | wc -l)" = "1" ]; then
  inst_dir_is_fod_dir=1
else
  inst_dir_is_fod_dir=0
fi

echo "$0: inst_dir=$inst_dir fod_dir=$fod_dir => inst_dir_is_fod_dir=$inst_dir_is_fod_dir venv_dir=$venv_dir static_dir=$static_dir" 1>&2
#exit

#############################################################################
#############################################################################

if [ "$install_basesw" = 1 ]; then

  # requires ./install-centos-fixcentos-sqlite.sh in case of CENTOS7

  echo "$0: step 1: installing base software dependencies (OS packages)" 1>&2

  set -e

  echo "Installing epel repo"
  rpm -Uh https://dl.fedoraproject.org/pub/epel/epel-release-latest-7.noarch.rpm

  echo "Installing remi repo"
  yum -y install http://rpms.remirepo.net/enterprise/remi-release-7.rpm

  echo "Installing base dependencies"
  yum -y install python36 python3-setuptools python36-virtualenv vim git gcc libevent-devel libxml2-devel libxslt-devel mariadb-server mysql-devel patch yum-utils


  echo "Installing redis"
  # Installation of redis from remi RPM repository
  yum-config-manager --enable remi
  yum -q -y install redis

  ##

  if [ "$try_fixup_for_old_os_sqlite" = 1 -a "$inside_docker" = 1 ]; then # only do try this fix inside docker env

    if ! type -p sqlite3; then
      echo "$0: sqlite3 not found, installing it" 1>&2
      yum install -y sqlite3
    fi

    if [ "$try_fixup_for_old_os_sqlite" = 1 -a "$inside_docker" = 1 ]; then # only do try this fix inside docker env
      . "./install-centos-fixcentos-sqlite.sh" "$fod_dir"
    fi

  fi 

  set +e

  echo "$0: step 1 done" 1>&2

fi

##

echo "$0: step 1a: handling sqlite3 too old fixup post actions" 1>&2 # only needed for CENTOS

assume__sqlite_version__to_old=1
if [ "$use_old_django_version__autodetect" = 1 ]; then

  sqlite_version="$(sqlite3 -version)"
  if [ "$sqlite_version" != "${sqlite_version#3.7.}" ]; then
    echo "$0: sqlite_version=$sqlite_version is too old, will use old Django version" 1>&2
    assume__sqlite_version__to_old=1
  else
    echo "$0: sqlite_version=$sqlite_version is recent enough to use newer Django and dependencies" 1>&2
    assume__sqlite_version__to_old=0
  fi

fi

##

python_version="$(python3 --version | cut -d ' ' -f 2,2)"
if [ "$assume__sqlite_version__to_old" = 1 ]; then
  echo "$0: assume__sqlite_version__to_old=$assume__sqlite_version__to_old => using requirements-centos.txt" 1>&2
  cp "$fod_dir/requirements-centos.txt" "$fod_dir/requirements.txt"
elif [ -e "$fod_dir/requirements.txt.python$python_version" ]; then
  echo "$0: using python version specific $fod_dir/requirements.txt.python$python_version" 1>&2
  cp "$fod_dir/requirements.txt.python$python_version" "$fod_dir/requirements.txt"
else
  echo "$0: using $fod_dir/requirements.txt" 1>&2
fi

echo "$0: step 1b: preparing database system" 1>&2

#############################################################################
#############################################################################

if [ "$install_fodproper" = 0 ]; then
  
  echo "$0: step 2a: installing Python dependencies only" 1>&2

  set -e

  echo "Setup partial python environment for FoD"
  if [ -x pyvenv ]; then
    #pyvenv /srv/venv
    pyvenv "$venv_dir"
  else
    #virtualenv-3 /srv/venv
    virtualenv-3 "$venv_dir"
  fi
  ln -sf "$venv_dir" "$fod_dir/venv"

  #source /srv/venv/bin/activate
  source "$venv_dir/bin/activate"

  ##

  # fix for broken anyjson and cl
  # TODO: fix this more cleanly
  pip install 'setuptools<58'

# if [ "$assume__sqlite_version__to_old" = 1 ]; then
#
#    # fix for broken anyjson and cl
#    # TODO: fix this more cleanly
#    #pip install 'setuptools<58'
#
#    echo "$0: assume__sqlite_version__to_old=$assume__sqlite_version__to_old => using requirements-centos.txt" 1>&2
#
#    cp "$fod_dir/requirements-centos.txt" "$fod_dir/requirements.txt"
#  else
#
#    python_version="$(python3 --version | cut -d ' ' -f 1,1)"
#    if [ -e "$fod_dir/requirements.txt.$python_version" ]; then
#      echo "$0: using python version specific $fod_dir/requirements.txt.$python_version" 1>&2
#      cp "$fod_dir/requirements.txt.$python_version" "$fod_dir/requirements.txt"
#    fi
#
#  fi
    
  (cd "$fod_dir" && pip install -r requirements.txt)
  
  echo "$0: step 2a done" 1>&2

else

  echo "$0: step 2: installing FoD in installation dir + ensuring Python dependencies are installed + setting-up FoD settings, database preparations, and FoD run-time environment" 1>&2

  set -e
  
  echo "$0: step 2.0" 1>&2


  mkdir -p /var/log/fod "$venv_dir_base"

  ##

  echo "Setup python environment for FoD"

  if [ -x pyvenv ]; then
    #pyvenv /srv/venv
    pyvenv "$venv_dir"
  else
    #virtualenv-3 /srv/venv
    virtualenv-3 "$venv_dir"
  fi
  ln -sf "$venv_dir" "$fod_dir/venv"

  (
  set +e
  #source /srv/venv/bin/activate
  source "$venv_dir/bin/activate"

  ##

  #mkdir -p /srv/flowspy/log/
  mkdir -p "$fod_dir/log/"
  
  if true; then

    echo "$0: step 2.1: coyping from source dir to installation dir $fod_dir" 1>&2

    MYSELF="$(basename "$0")"
    DIRNAME="$(dirname "$0")"

    # Select source dir and copy FoD into /srv/flowspy/
    if [ "$MYSELF" = "$SCRIPT_NAME" ]; then # if started as main script, e.g., in Docker or on OS-installation
      # this script is in the source directory
      #cp -f -r "`dirname $0`"/* /srv/flowspy/
      #cp -f -r "$DIRNAME"/* "$fod_dir"
      cp -f -r "$inst_dir"/* "$fod_dir"
    elif [ -e /vagrant ]; then # running in vagrant with /vagrant available
      # vagrant's copy in /vagrant/
      #cp -f -r /vagrant/* /srv/flowspy/
      cp -f -r /vagrant/* "$fod_dir"
    elif [ -e "$SCRIPT_NAME" ]; then # running in vagrant with script current dir == install dir
      # current directory is with the sourcecode
      #cp -f -r ./* /srv/flowspy/
      cp -f -r ./* "$fod_dir"
    else
      echo "Could not find FoD src directory tried `dirname $0`, /vagrant/, ./"
      exit 1
    fi

  fi

  set -e
  
  echo "$0: step 2.2: setting-up FoD settings" 1>&2
  
  #cd /srv/flowspy/
  cd "$fod_dir"
  (
    cd flowspy # jump into settings subdir flowspy

    if [ "$inside_docker" = 1 -a -e settings.py.centos.docker ]; then # user has own centos-specific settings prepared yet ?
      
      cp -f settings.py.centos.docker settings.py

    elif [ -e settings.py.centos ]; then # user has own centos-specific settings prepared yet ?

      cp -f settings.py.centos settings.py
    
    elif [ "$inside_docker" = 1 -a -e settings.py.docker ]; then # user has own settings prepared yet ?
      
      cp -f settings.py.docker settings.py

    elif [ -e settings.py ]; then # user has prepared a generic settings yet ?

      : # nothing todo

    else # prepare a settings.py from git repo's settings.py.dist/settings.py.centos.dist + settings.py.patch

      if [ "$assume__sqlite_version__to_old" = 1 ]; then
        echo "$0: assume__sqlite_version__to_old=$assume__sqlite_version__to_old using settings.py.centos.dist" 1>&2
        cp -f settings.py.centos.dist settings.py
      else
        cp -f settings.py.dist settings.py
      fi

      patch settings.py < settings.py.patch
          
      sed -i "s#/srv/flowspy#$fod_dir#" "settings.py"

    fi
  )

  if [ ! -e "flowspy/settings_local.py" ]; then
    touch flowspy/settings_local.py
  fi
  
  echo "$0: step 2.3: ensuring Python dependencies are installed" 1>&2

  if [ "$install_basesw" = 1 ]; then #are we running in --both mode, i.e. for the venv init is run for the first time, i.e. the problematic package having issues with to new setuptools is not yet installed?
    # fix for broken anyjson and cl
    # TODO: fix this more cleanly
    pip install 'setuptools<58'
  fi

  # actual proper installation of python requirements
  pip install -r requirements.txt

  ##

  echo "$0: step 2.4: preparing FoD static files and database" 1>&2

  echo "$0: step 2.4.1: preparing FoD static files" 1>&2

  #mkdir -p /srv/flowspy/static/
  mkdir -p "$static_dir"

  ([ ! -f "fodenv.sh" ] || source "./fodenv.sh"; ./manage.py collectstatic --noinput)

  ##

  echo "$0: step 2.4.2.0: preparing DB and DB access" 1>&2

  echo "$0: step 2.4.2.0: preparing FoD DB schema and basic data" 1>&2

  echo "deploying/updating database schema" 1>&2
  (
    [ ! -f "fodenv.sh" ] || source "./fodenv.sh"
  
    #./manage.py syncdb --noinput

    #which sqlite3
    #sqlite3 -version
    #source "$venv_dir/bin/activate"

    ./manage.py migrate
    ./manage.py loaddata initial_data
  )
  echo 1>&2

  ##

  echo "$0: step 2.5: preparing FoD run-time environment" 1>&2
  
  echo "$0: step 2.5.1: preparing necessary dirs" 1>&2

  mkdir -p /var/run/fod
  #chown fod /var/run/fod

  ##

  echo "$0: step 2.5.2: preparing FoD python wrapper" 1>&2

  if [ "$ensure_installed_pythonenv_wrapper" = 1 -a \( "$inside_docker" = 1 -o ! -e "$fod_dir/pythonenv" \) ]; then
    echo "adding pythonev wrapper" 1>&2
    cat > "$fod_dir/pythonenv" <<EOF
#!/bin/bash
. "$venv_dir/bin/activate"
[ ! -e "$fod_dir/fodenv.sh" ] || . "$fod_dir/fodenv.sh"
exec "\$@"
EOF
    chmod +x "$fod_dir/pythonenv"
    echo 1>&2
  fi

  ##

  echo "$0: step 2.5.3: preparing supervisord.conf" 1>&2

  if [ "$assume__sqlite_version__to_old" = 1 -a -e "$fod_dir/supervisord-centos.conf" ]; then
    echo "$0: assume__sqlite_version__to_old=$assume__sqlite_version__to_old => using supervisord-centos.conf for old celery start syntax" 1>&2
    cp -f "$fod_dir/supervisord-centos.conf" "$fod_dir/supervisord.conf"
  elif [ -e "$fod_dir/supervisord.conf.dist" ]; then
    echo "providing supervisord config" 1>&2
    cp -f "$fod_dir/supervisord.conf.dist" "$fod_dir/supervisord.conf"
  fi
  
  sed -i "s#/srv/flowspy#$fod_dir#" "$fod_dir/supervisord.conf"
  echo 1>&2

  ##
  
  echo "$0: step 2.5.4: preparing runfod script" 1>&2

  if [ "$assume__sqlite_version__to_old" = 1 ]; then
    echo "$0: assume__sqlite_version__to_old=$assume__sqlite_version__to_old => using runfod.centos.sh for old celery start syntax" 1>&2
    cp -f runfod.centos.sh runfod.sh
  fi

  )
  
  echo "$0: step 2 done" 1>&2

  set +e

fi

#############################################################################
#############################################################################

