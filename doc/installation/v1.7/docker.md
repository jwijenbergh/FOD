# Installing Flowspy v1.7 with Docker

This guide provides general information about the installation of Flowspy. In case you use Debian Wheezy or Red Hat Linux, we provide detailed instructions for the installation.

Also it assumes that installation is carried out in `/srv/flowspy`
directory. If other directory is to be used, please change the
corresponding configuration files. It is also assumed that the `root` user
will perform every action.

TO UPDATE

## Requirements

docker

### System Requirements

disk space

### FoD test installation docker containers

Currently, either a CENTOS-based on DEBIAN-based FoD container is available.

Both are meant for test and reference installation.
Not necessarily to be production-ready.
They are provided as running reference installation.
Currently default is the CENTOS-based container.

In the FoD container gunicorn, celeryd and Redis will be running comprising the main part of FoD.
Inside container file system FoD is residing in directory /srv/flowspy.
As database a sqlite DB will be used per default.
gunicorn will be accessible from outside the container by port 8000.


#### Installation and starting of CENTOS docker container

building docker container:
```
docker build -f Dockerfile -t fod-centos .
or 
docker build -f ./Dockerfiles.d/Dockerfile.centos.supervisord -t fod-centos . # for using supervisord inside container
or 
docker build -f ./Dockerfiles.d/Dockerfile.centos.base -t fodpy3_centos_base . && docker build -f ./Dockerfiles.d/Dockerfile.centos.step2 -t fod-centos . # for using a 2-step docker build (for faster rebuild on changes in the code, mainly useful for developers)
or
docker build -f ./Dockerfiles.d/Dockerfile.centos.supervisord.base -t fodpy3_centos_svzd_base . && docker build -f ./Dockerfiles.d/Dockerfile.centos.supervisord.step2 -t fod-centos . # for using supervisord inside container + using a 2-step docker build (for faster rebuild on changes in the code, mainly useful for developers)
```

starting built docker container:
```
docker run -p 8000:8000 fod-centos # run in foregrund

docker run -d -p 8000:8000 fod-centos # run in background
```

#### Installation and starting of UBUNTU docker container

building docker container:
```
docker build -f ./Dockerfiles.d/Dockerfile.debian -t fod-debian .
or
docker build -f ./Dockerfiles.d/Dockerfile.debian.supervisord -t fod-debian . # for using supervisord inside container
or 
docker build -f ./Dockerfiles.d/Dockerfile.debian.base -t fodpy3_debian_base . && docker build -f ./Dockerfiles.d/Dockerfile.debian.step2 -t fod-debian . # for using a 2-step docker build (for faster rebuild on changes in the code, mainly useful for developers)
or 
docker build -f ./Dockerfiles.d/Dockerfile.debian.supervisord.base -t fodpy3_debian_svzd_base . && docker build -f ./Dockerfiles.d/Dockerfile.debian.supervisord.step2 -t fod-debian . # for using supervisord inside container + using a 2-step docker build (for faster rebuild on changes in the code, mainly useful for developers)
```

starting built docker container:
```
docker run -p 8000:8000 fod-debian # run in foreground

docker run -d -p 8000:8000 fod-debian # run in background
```

#### Configuring NETCONF in a running container 

admin user password and NETCONF connection has to be setup, 
either by

A) via the setup page of FoD in container: 

http://127.0.0.1:8001/setup/

or alternatively

B) manually

in by entering the running container and editing
docker exec -ti "$DOCKERID" bash # find out DOCKERID of running container with "docker ps"

in docker: vi /srv/flowspy/flowspy/settings.py : settings NETCONF_DEVICE, NETCONF_PORT, NETCONF_USER, NETCONF_PASS

make sure docker container has IP connectivity to NETCONF_DEVICE

in docker: cd /srv/flowspy; ./pythonenv ./manage.py createsuperuser ...

in docker: cd /srv/flowspy; ./pythonenv ./manage.py changepassword ...

#### Accessing the FoD UI running in container after setup of admin user (password)

http://127.0.0.1:8000/altlogin

(do not try to use the Shibboleth login via /login, as it is not working without a set-up Shibboleth SP)


