# -*- coding: utf-8 -*- vim:fileencoding=utf-8:
# vim: tabstop=4:shiftwidth=4:softtabstop=4:expandtab

# Copyright (C) 2017 CESNET, a.l.e.
#
# This program is free software: you can redistribute it and/or modify
# it under the terms of the GNU General Public License as published by
# the Free Software Foundation, either version 3 of the License, or
# (at your option) any later version.
#
# This program is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
# GNU General Public License for more details.
#
# You should have received a copy of the GNU General Public License
# along with this program.  If not, see <http://www.gnu.org/licenses/>.
#

from pysnmp.hlapi import *
import json
from pysnmp.entity.rfc3413.oneliner import cmdgen
from django.conf import settings


def getSNMPData(ip, comm, obj, walk = True):
    cmdGen = cmdgen.CommandGenerator()
    if walk:
        cmd = cmdGen.bulkCmd
        errorIndication, errorStatus, errorIndex, varBindTable = cmd(
            cmdgen.CommunityData(comm),
            cmdgen.UdpTransportTarget((ip, 161)), 0, 25,
            *obj,
            lookupValues=False
        )
    else:
        cmd = cmdGen.getCmd
        errorIndication, errorStatus, errorIndex, varBindTable = cmd(
            cmdgen.CommunityData(comm),
            cmdgen.UdpTransportTarget((ip, 161)),
            *obj,
            lookupValues=False
        )
    if errorIndication:
        print("error", str(errorIndication))
    else:
        if errorStatus:
            print('%s at %s' % (
                errorStatus.prettyPrint(),
                errorIndex and varBindTable[-1][int(errorIndex)-1] or '?'
                )
            )
        else:
            vars = []
            for varBindTableRow in varBindTable:
                if walk:
                    for name, val in varBindTableRow:
                        vars.append((name, val))
                else:
                    for val in varBindTableRow:
                        vars.append(str(val))
            return vars
    return []

def get_snmp_stats():
    results = {}
    if not isinstance(settings.SNMP_IP, list):
        settings.SNMP_IP = [settings.SNMP_IP]

    for ip in settings.SNMP_IP:
        filteredVars = []
        oids = []
        data = getSNMPData(ip, settings.SNMP_COMMUNITY, [settings.SNMP_FILTERNAME])
        for name, val in data:
            if val in settings.SNMP_RULESFILTER:
                rule = str(name)
                oids.append(settings.SNMP_OBJ1 + rule[len(settings.SNMP_FILTERNAME):])
                oids.append(settings.SNMP_OBJ3 + rule[len(settings.SNMP_FILTERNAME):])

        data = getSNMPData(ip, settings.SNMP_COMMUNITY, oids, False)
        for i in range(0, len(data), 2):
            if data[i].startswith(settings.SNMP_OBJ1):
                name = data[i + 1]
            elif data[i].startswith(settings.SNMP_OBJ3):
                val = data[i + 1]
                if name in results:
                    results[name] = results[name] + int(val)
                else:
                    results[name] = int(val)
    return results
    

