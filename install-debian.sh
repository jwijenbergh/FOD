#!/bin/bash
#
# This script installs all dependencies for Firewall-on-Demand running in Python3
# with Celery, Redis, and sqlite.
#

fod_dir="/srv/flowspy"
venv_dir="/srv/venv"

install_basesw=1
install_fodproper=1

#

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

##

if [ "$install_basesw" = 1 ]; then

  set -e

  echo "Install dependencies"
  apt-get -qqy update
  apt-get -qqy install virtualenv python3-venv python3-setuptools \
    python3-dev vim git build-essential libevent-dev libxml2-dev libxslt1-dev \
    mariadb-server libmariadb-dev patch redis-server \
    rustc libssl-dev \
    procps

  set +e

fi

if [ "$install_fodproper" = 0 ]; then

  echo "Setup partial python environment for FoD"

  #mkdir -p /srv
  mkdir -p "$venv_dir_base"
  if [ -x pyvenv ]; then
    #pyvenv /srv/venv
    pyvenv "$venv_dir"
  else
    #virtualenv /srv/venv
    virtualenv --python=python3 "$venv_dir"
  fi
  ln -sf "$venv_dir" "$fod_dir/venv"

  #source /srv/venv/bin/activate
  source "$venv_dir/bin/activate"

  # fix
  pip install setuptools==57.5.0

  pip install wheel
  pip install -r requirements.txt

else 

  echo "Setup python environment for FoD"
  #mkdir -p /var/log/fod /srv
  mkdir -p /var/log/fod "$venv_dir_base"
  if [ -x pyvenv ]; then
    #pyvenv /srv/venv
    pyvenv "$venv_dir"
  else
    #virtualenv /srv/venv
    virtualenv --python=python3 "$venv_dir"
  fi
  ln -sf "$venv_dir" "$fod_dir/venv"
  (
        set +e
	#source /srv/venv/bin/activate
	source "$venv_dir/bin/activate"
	#mkdir -p /srv/flowspy/
	mkdir -p "$fod_dir"

	if [ "$inst_dir_is_fod_dir" = 0 ]; then

    	  # Select source dir and copy FoD into /srv/flowspy/
    	  if [ "`basename "$0"`" = install-debian.sh ]; then
    		# this script is in the source directory
    		#cp -f -r "`dirname $0`"/* /srv/flowspy/
     		cp -f -r "$inst_dir"/* "$fod_dir"
      	  elif [ -e /vagrant ]; then
    		# vagrant's copy in /vagrant/
    		#cp -f -r /vagrant/* /srv/flowspy/
    		cp -f -r /vagrant/* "$fod_dir"
    	  elif [ -e ./install-centos.sh ]; then
    		# current directory is with the sourcecode
    		#cp -f -r ./* /srv/flowspy/
    		cp -f -r ./* "$fod_dir"
    	  else
    		echo "Could not find FoD src directory tried `dirname $0`, /vagrant/, ./"
    		exit 1
    	  fi

    	fi

	#find "$fod_dir/" -not -user fod -exec chown -v fod: {} \;
	find "$fod_dir/" -not -user fod -exec chown fod: {} \;

	set -e
	
	#cd /srv/flowspy/
	cd "$fod_dir"
	(
		cd flowspy

		if [ ! -e settings.py ]; then
  		  cp -f settings.py.dist settings.py
		  patch settings.py < settings.py.patch
	        
		  sed -i "s#/srv/flowspy#$fod_dir#" "settings.py"
		fi
	)
	pip install -r requirements.txt

        if [ ! -e "flowspy/settings_local.py" ]; then
  	  touch flowspy/settings_local.py
	fi

	#./manage.py syncdb --noinput
	#mkdir -p /srv/flowspy/static/
	mkdir -p "$static_dir"
	./manage.py collectstatic --noinput
	./manage.py migrate
	./manage.py loaddata initial_data

	mkdir -p "$fod_dir/log" "$fod_dir/logs"
	chown -R fod: "$fod_dir/log" "$fod_dir/logs"

	sed -i "s#/srv/flowspy#$fod_dir#" "$fod_dir/supervisord.conf"
  )

  set +e

fi


