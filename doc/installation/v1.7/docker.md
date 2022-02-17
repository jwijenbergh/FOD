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

docker build -f Dockerfile -t fod-centos .

docker run -p 8000:8000 fod-centos # run in foregrund

docker run -d -p 8000:8000 fod-centos # run in background

#### Installation and starting of UBUNTU docker container

docker build -f Dockerfile.debian -t fod-debian .

docker run -p 8000:8000 fod-debian # run in foreground

docker run -d -p 8000:8000 fod-debian # run in background

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

### NETCONF test server docker container

When no real NETCONF-enabled router supporting BGP FlowSpec is available, just for 
testing the NETCONF test server docker container can be used:

In FoD-cloned installation dir, e.g., residing in /srv/flowspy,
got to sub directory ./router-container/
there:

docker build -t juniper .

docker run -it --name juniper -p 830:830 --rm juniper:latest

for more information, e.g., how to manually test NETCONF access to the test server, check ./router-container/run.txt

Now, find out IP address of the running test server container, e.g., by
docker inspect "$DOCKERID_NETCONF" | grep IPAddress # find out DOCKERID_NETCONF, e.g. by "docker ps"

In FoD test container (see above) configure this IP address of the NETCONF test server,
with NETCONF port 830, NETCONF_USER "netconf" and NETCONF_PASS "netconf"

Now, FoD can submit FlowSpec rules which are actually only stored inside the NETCONF test server
without an actual effect on any network, but FoD functionality of controlling rules can be tested. 

### NETCONF test server docker container based on netconfd instead of netopeer

similar to router-container/Dockerfile but will use netconfd (DEBIAN package) instead of CESNET's netopeer NETCONF server

### NETCONF test server docker container extended to virtual DDoS test network

Based on an instance of the NETCONF test server docker container

Extending with Mininet/OpenVSwitch, 
a basic a script for syncing NETCONF rules stored in the test NETCONF server
to OpenFlow rules in Mininet simulating BGP FlowSpec rules (not all cases supported),
SNMPd and a Perl SNMPd statistic collector script

Yields a more complete simulation of a router for FoD.

Dockerfile.vnet_router1 : 
Dockerfile.vnet_router2 : similar to Dockerfile.vnet_router1, but will use netconfd (DEBIAN package) instead of CESNET's netopeer NETCONF server
(instructions how to build and run inside the Dockerfiles)




