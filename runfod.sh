#!/bin/bash

export LC_ALL=C
. /srv/venv/bin/activate

cd "$(dirname "$0")"

service beanstalkd start
service mysql start

./manage.py celeryd &

exec ./manage.py runserver 0.0.0.0:8000

