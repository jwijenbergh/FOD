#!/bin/bash

arg1="$1" 
shift 1

source ./venv/bin/activate 

case "$arg1" in

  *|status)

    set -e

    ./manage.py fodinfo -s

    echo "SELECT 1" | ./manage.py dbshell

    ./manage.py diffsettings | grep -E "(NETCONF)|(SNMP_IP)"

    env DJANGO_SETTINGS_MODULE=flowspy.settings python -c '
from utils.proxy import *; 
proxy = Applier(); 
xml = proxy.get_existing_config_xml();
print(xml);
' "$@" < /dev/null

  ;;

esac

