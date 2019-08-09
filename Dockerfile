#FROM debian:stable
FROM debian:stretch

RUN [ -z "$NOAPT" ] && apt-get -yqq update
RUN [ -z "$NOAPT" ] && apt-get -yqq upgrade

RUN [ -z "$NOAPT" ] && apt-get -yqq install virtualenv python python-dev vim git gcc libevent-dev libxml2-dev libxslt-dev patch beanstalkd mariadb-server libmariadb-dev libmariadbclient-dev-compat sqlite3
RUN [ -z "$NOAPT" ] && apt-get -yqq install procps

# RUN echo "create database fod;" | mysql -u root

RUN mkdir -p /var/log/fod /srv
COPY . /srv/flowspy

RUN (cd /srv/flowspy/flowspy && cp -f settings.py.dist settings.py && patch settings.py < settings.py.patch && touch settings_local.py;)

RUN (virtualenv /srv/venv && . /srv/venv/bin/activate; cd /srv/flowspy/; pip install -r requirements.txt;)
     
RUN (cd /srv/flowspy/; ./patch-dependencies.sh;)

RUN (cd /srv/flowspy/; . /srv/venv/bin/activate && \
      ./manage.py syncdb --noinput && \
      ./manage.py migrate;)

RUN [ "$INSTALL_TEST_APACHE_SHIB" = 1 ] && ./inst/apache_shib/apache_shib_init.sh

#  echo "To set environment to English, run: export LC_ALL=en_US"
#  echo "To activate virualenv: source /srv/venv/bin/activate"
#  echo "To create a user run: cd /srv/flowspy; ./manage.py createsuperuser"
#  echo "To start flowspy server: cd /srv/flowspy; ./manage.py runserver 0.0.0.0:8000"
#  echo "To start celeryd: cd /srv/flowspy; ./manage.py celeryd"

EXPOSE 8000

WORKDIR /srv/flowspy

CMD [ "/srv/flowspy/runfod.sh" ]

