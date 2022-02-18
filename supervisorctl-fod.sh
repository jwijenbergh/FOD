#!/bin/sh

mode="$1" 
shift 1

case "$mode" in

  status|status-fod)
    supervisorctl status 
    pgrep gunicorn
    pgrep celery

    ;;	  

  start|start-fod)
    "$0" start-gunicorn
    "$0" start-celeryd
    ;;

  start-gunicorn)
    supervisorctl start gunicorn
    supervisorctl status gunicorn
    sleep 1
    pgrep gunicorn
    ;;

  start-celeryd)
    supervisorctl start celeryd
    supervisorctl status celeryd
    sleep 1
    pgrep celery
    ;;

##

  stop|stop-fod)
    "$0" stop-gunicorn
    "$0" stop-celeryd
    ;;

  stop-gunicorn)
    supervisorctl stop gunicorn
    supervisorctl status gunicorn
    pgrep gunicorn
    sleep 1
    pkill gunicorn
    pgrep gunicorn
    ;;

  stop-celeryd)
    supervisorctl stop celeryd
    supervisorctl status celeryd
    pgrep celery
    sleep 1
    pkill celery
    pgrep celery
    ;;

##

  restart|restart-fod)
    "$0" stop-fod
    "$0" start-fod
    ;;

  restart-gunicorn)
    "$0" stop-gunicorn
    "$0" start-gunicorn
    ;;

  restart-celeryd)
    "$0" stop-celeryd
    "$0" start-celeryd
    ;;

esac

