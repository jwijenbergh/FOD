# Installation on CENTOS

For the installation on CENTOS, 
there is ./install-centos.sh, currently mainly used for installation inside a Docker container.
Currently, it understands several command line switches:

- --fod_dir DIRNAME : specify FoD run-time directory, where FoD files are to be copied and to be run from 
- --venv_dir DIRNAME : specify where Python virtualenv used by FoD will be located
- --base-dir DIRNAME : specify base directory where FoD run-time directory and virtualenv directory will be sub directories
- --here : do not copy FoD files into a separate FoD run-time directory, but instead install and make to run from current directory (probably not so useful for production)

- --basesw : only install FoD dependencies (OS packages + Python Pip packages in virtualenv directory), do not install and setup FoD run-time directory 
- --fodproper : skip installing FoD dependencies, only install and setup FoD run-time directory 





