#!/bin/sh
#
# This script installs all dependencies for Firewall-on-Demand running in Python3
# with Celery, Redis, and sqlite.
#

echo "Installing epel repo"
rpm -Uh https://dl.fedoraproject.org/pub/epel/epel-release-latest-7.noarch.rpm

echo "Installing remi repo"
yum -q -y install http://rpms.remirepo.net/enterprise/remi-release-7.rpm

echo "Installing base dependencies"
yum -q -y install python36 python36-setuptools python36-virtualenv vim git gcc libevent-devel libxml2-devel libxslt-devel mariadb-server mysql-devel patch yum-utils


echo "Installing redis"
# Installation of redis from remi RPM repository
yum-config-manager --enable remi
yum -q -y install redis

echo "Setup python environment for FoD"
mkdir -p /var/log/fod /srv
virtualenv-3 /srv/venv
(
	source /srv/venv/bin/activate
	mkdir -p /srv/flowspy/
	cp -r "`dirname $0`"/* /srv/flowspy/
	cd /srv/flowspy/
	(
		cd flowspy
		cp -f settings.py.dist settings.py
		patch settings.py < settings.py.patch
	)
	pip install -r requirements.txt

	touch flowspy/settings_local.py

	./manage.py syncdb --noinput
	./manage.py migrate
	./manage.py loaddata initial_data
)

