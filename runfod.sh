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

# fix needed to make sure gevent works # may be put into Dockerfile instead
if grep ssl_version=PROTOCOL_SSLv3 /srv/venv/lib/python2.7/site-packages/gevent/ssl.py; then
   cat /srv/venv/lib/python2.7/site-packages/gevent/ssl.py | \
	sed -e 's/ssl_version=PROTOCOL_SSLv3/ssl_version=PROTOCOL_SSLv23/' > /srv/venv/lib/python2.7/site-packages/gevent/ssl.py.$$ && \
	mv -vf /srv/venv/lib/python2.7/site-packages/gevent/ssl.py.$$ /srv/venv/lib/python2.7/site-packages/gevent/ssl.py || \
	rm -vf /srv/venv/lib/python2.7/site-packages/gevent/ssl.py.$$
fi

##

cd "$(dirname "$0")"

echo "Starting services FoD is depending on generically: beanstalkd" 1>&2
if which service; then
  service beanstalkd start
else
  beanstalkd &
fi

if [ ! -x ./fodcli_db_is_mysql ] || ./fodcli_db_is_mysql; then
  echo "Starting DB services FoD might be depending on (depending on its config): mysql" 1>&2
  service mysql start
fi

# hook to initiallize (without any user interaction admin user and its peer data)
[ -x ./fodcli_insert_basic_data.sh ] && ./fodcli_insert_basic_data.sh

mkdir -p /var/run/fod

echo "Starting FoD celeryd in background" 1>&2
#pgrep -f "python.*celeryd"  || ./manage.py celeryd &
pgrep -f "python.*celeryd" >/dev/null  || { ./manage.py celeryd -E --soft-time-limit=180 --concurrency=1 -B --time-limit=1800 & }

echo "Starting FoD gunicorn in foreground" 1>&2
#exec ./manage.py runserver 0.0.0.0:8000 
#exec ./manage.py runserver 0.0.0.0:8000 --nothreading
#exec gunicorn -w 1 --limit-request-fields 10000 --worker-class gevent --timeout 30
#exec gunicorn -b 0.0.0.0:8000 flowspy.wsgi -w 1 --limit-request-fields 10000 --timeout 30
#exec gunicorn -b 0.0.0.0:8000 flowspy.wsgi -w 1
#exec gunicorn -b 0.0.0.0:8000 flowspy.wsgi -w 1 -k gevent --limit-request-fields 10000 --timeout 30 #--preload
exec gunicorn -b 0.0.0.0:8000 flowspy.wsgi -w 1 -k gevent --limit-request-fields 10000 --timeout 30 


