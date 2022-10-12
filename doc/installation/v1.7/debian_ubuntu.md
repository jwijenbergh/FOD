# Installation on DEBIAN/UBUNTU

For the installation on recent DEBIAN or UBUNTU, e.g., UBUNTU focal (20.04),
there is ./install-debian.sh .

It understands several command line switches:

- --fod_dir DIRNAME : specify FoD run-time directory, where FoD files are to be copied and to be run from 
- --venv_dir DIRNAME : specify where Python virtualenv used by FoD will be located
- --base-dir DIRNAME : specify base directory where FoD run-time directory and virtualenv directory will be sub directories
- --here : do not copy FoD files into a separate FoD run-time directory, but instead install and make to run from current directory (probably not so useful for production)

- --systemd : enable Systemd support explicitly, by default will be enabled if Systemd is detected 
- --no-systemd : disable Systemd support explicitly, even if Systemd is detected

- --basesw : only install FoD dependencies (OS packages + Python Pip packages in virtualenv directory), do not install and setup FoD run-time directory 
- --fodproper : skip installing FoD dependencies, only install and setup FoD run-time directory 

- --with-mta-postfix : if no MTA is installed, will try to install postfix (FoD operation is dependant on e-mail sending being available)

- --with-db-sqlite : use a SQLite DB for FoD DB (not recommended for production, but easy for testing)
- --with-db-mysql : will try to install MySQL and to setup FoD database in MySQL
- --with-db-mariadb : will try to install MariaDB and to setup FoD database in MariaDB
- --with-db-mysqllike : assumes that MySQL or MariaDB is installed and will try to setup FoD database based on this

## System support 

FoD installation currently supports Systemd, i.e., it installs Systemd startup files (./systemd/fod-*.service)

Currently,
alternatives are ./runfod.sh for directly starting FoD processes together with Redis task broker or
./runfod-supervisord.sh for starting FoD processes and Redis task broker via Supervisord.

The systemd support also includes an experimental e-mail notification for startup-failures of the FoD processes

## FoD run-time status 

There is ./systemd/fod-status.sh, a generic script (not limited to Systemd) for determining the process status of FoD along with some further aspects, e.g., Database connection, NETCONF configuration and reachability


