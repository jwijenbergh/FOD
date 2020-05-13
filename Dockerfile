FROM debian:buster

ENV LC_ALL en_US.utf8

RUN apt-get update
RUN echo "Set up container's locales"
RUN echo -e 'LANG="en_US.UTF-8"\nLANGUAGE="en_US"\n' > /etc/default/locale
RUN echo "en_US.utf8 UTF-8" >> /etc/locale.gen
RUN apt-get -qqy install locales

RUN mkdir -p /var/log/fod /srv
COPY . /srv/flowspy
RUN (cd /srv/flowspy/flowspy && cp -f settings.py.dist settings.py && patch settings.py < settings.py.patch && touch settings_local.py;)
RUN (cd /srv/flowspy; bash ./install-debian.sh;)

EXPOSE 8000

WORKDIR /srv/flowspy

CMD [ "/srv/flowspy/runfod.sh" ]

