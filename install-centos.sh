#!/bin/sh
#
# This script installs all dependencies for Firewall-on-Demand running in Python3
# with Celery, Redis, and sqlite.
#

install_basesw=1
install_fodproper=1
if [ $# -ge 1 -a "$1" = "--both" ]; then
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
fi

##

if [ "$install_basesw" = 1 ]; then

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

  set +e

fi

##

if [ "$install_fodproper" = 0 ]; then

  echo "Setup partial python environment for FoD"
  virtualenv-3 /srv/venv
  source /srv/venv/bin/activate
  pip install -r requirements.txt

else

  set -e

  echo "Setup python environment for FoD"
  mkdir -p /var/log/fod /srv
  virtualenv-3 /srv/venv

  (
        set +e
	source /srv/venv/bin/activate
	mkdir -p /srv/flowspy/

	# Select source dir and copy FoD into /srv/flowspy/
	if [ "`basename "$0"`" = install-centos.sh ]; then
		# this script is in the source directory
		cp -f -r "`dirname $0`"/* /srv/flowspy/
	elif [ -e /vagrant ]; then
		# vagrant's copy in /vagrant/
		cp -f -r /vagrant/* /srv/flowspy/
	elif [ -e ./install-centos.sh ]; then
		# current directory is with the sourcecode
		cp -f -r ./* /srv/flowspy/
	else
		echo "Could not find FoD src directory tried `dirname $0`, /vagrant/, ./"
		exit 1
	fi

	set -e
	
	cd /srv/flowspy/
	(
		cd flowspy
		cp -f settings.py.dist settings.py
		patch settings.py < settings.py.patch
	)
	pip install -r requirements.txt

	touch flowspy/settings_local.py

	#./manage.py syncdb --noinput
	mkdir -p static
	echo yes | ./manage.py collectstatic
	./manage.py migrate
	./manage.py loaddata initial_data
  )

  set +e

fi

