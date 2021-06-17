#!/bin/bash
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

  echo "Install dependencies"
  apt-get -qqy update
  apt-get -qqy install python3-virtualenv python3-venv python3-setuptools \
    python3-dev vim git build-essential libevent-dev libxml2-dev libxslt1-dev \
    mariadb-server libmariadb-dev patch redis-server \
    rustc libssl-dev \
    procps

  set +e

fi

if [ "$install_fodproper" = 0 ]; then

  echo "Setup partial python environment for FoD"

  mkdir -p /srv
  pyvenv /srv/venv
  source /srv/venv/bin/activate
  pip install wheel
  pip install -r requirements.txt

else 

  echo "Setup python environment for FoD"
  mkdir -p /var/log/fod /srv
  pyvenv /srv/venv
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
	mkdir -p /srv/flowspy/static/
	./manage.py collectstatic --noinput
	./manage.py migrate
	./manage.py loaddata initial_data
  )

  set +e

fi


