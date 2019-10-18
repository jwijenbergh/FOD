#!/bin/bash

export LC_ALL="C" # this will unfortunatelly break ./manage.py createsuperuser as locale string is literally used to derive encoding
. /srv/venv/bin/activate

if [ ! -e /srv/flowspy/pythonenv ]; then
	cat > /srv/flowspy/pythonenv <<EOF
#!/bin/bash
. /srv/venv/bin/activate
exec "\$@"
EOF
	chmod +x /srv/flowspy/pythonenv
fi

##

cd "$(dirname "$0")"

if [ ! -x ./fodcli_db_is_mysql ] || ./fodcli_db_is_mysql; then
  echo "Starting DB services FoD might be depending on (depending on its config): mysql" 1>&2
  systemctl start mysql.service
fi

# hook to initiallize (without any user interaction admin user and its peer data)
[ -x ./fodcli_insert_basic_data.sh ] && ./fodcli_insert_basic_data.sh

mkdir -p /var/run/fod

echo "Starting FoD celeryd in background" 1>&2
celery worker -A flowspy --concurrency=2 --detach -l debug -f celery.log

echo "Starting FoD gunicorn in foreground" 1>&2
#exec ./manage.py runserver 0.0.0.0:8000 
#exec ./manage.py runserver 0.0.0.0:8000 --nothreading
#exec gunicorn -w 1 --limit-request-fields 10000 --worker-class gevent --timeout 30
#exec gunicorn -b 0.0.0.0:8000 flowspy.wsgi -w 1 --limit-request-fields 10000 --timeout 30
#exec gunicorn -b 0.0.0.0:8000 flowspy.wsgi -w 1
#exec gunicorn -b 0.0.0.0:8000 flowspy.wsgi -w 1 -k gevent --limit-request-fields 10000 --timeout 30 #--preload
exec gunicorn -b 0.0.0.0:8000 flowspy.wsgi -w 1 -k gevent --limit-request-fields 10000 --timeout 30 


