# -*- coding: utf-8 -*- vim:fileencoding=utf-8:
# vim: tabstop=4:shiftwidth=4:softtabstop=4:expandtab

from flowspec.models import *
from peers.models import *

from ipaddress import *
from intervaltree.intervaltree import IntervalTree, Interval

##

import os
import logging

LOG_FILENAME = os.path.join(settings.LOG_FILE_LOCATION, 'iprange_match.log')
# FORMAT = '%(asctime)s %(levelname)s: %(message)s'
# logging.basicConfig(format=FORMAT)
#formatter = logging.Formatter('%(asctime)s %(levelname)s %(user)s: %(message)s')
formatter = logging.Formatter('%(asctime)s %(levelname)s: %(message)s')

logger = logging.getLogger(__name__)
logger.setLevel(logging.DEBUG)
handler = logging.FileHandler(LOG_FILENAME)
handler.setFormatter(formatter)
logger.addHandler(handler)

##

def build_ival_trees_per_ipversion(user):
    
    # build ival trees for users peer ip ranges
    try:
      # venv/lib/python3.8/site-packages/intervaltree/intervaltree.py
      ivaltrees_per_version = {}

      if user.is_superuser:
        peers = Peer.objects.all()
      else:
        peers = user.userprofile.peers.all()
      for peer in peers:
        for network in peer.networks.all():
          net = ip_network(network, strict=False)
          # Intervals are half open ivals [a, b), so use b+1 instead of b => [a, b+1) intersect Int = [a,b] intersect Int
          # int(...) necessary to allow for .+1 not to get an ip address overflow for 255.255.255.255
          ival1 = Interval(int(net.network_address), int(net.broadcast_address)+1, peer)
          #logger.info("views::build_routes_json(): ival1="+str(ival1))
          if not net.version in ivaltrees_per_version:
            ivaltrees_per_version[net.version] = IntervalTree()
          ivaltrees_per_version[net.version].add(ival1)
    except Exception as e:
      logger.error("iprange_match::build_ival_trees_per_ipversion(): got exception: "+str(e), exc_info=True)

    return ivaltrees_per_version


def get_matching_related_peer_for_rule_destination(ivaltrees_per_version, route):

   peer_name_tmp = None
   try:
     if route.applier!=None:    
       route_applier__peers_related = set(route.applier.userprofile.peers.select_related())
     else:
       route_applier__peers_related = None

     route_destination = route.destination

     qnet = ip_network(route_destination, strict=False)
     qival = Interval(int(qnet.network_address), int(qnet.broadcast_address)+1)
     if qnet.version in ivaltrees_per_version:
       result = ivaltrees_per_version[qnet.version].overlap(qival)
     else:
       result = []
     #logger.info("views::build_routes_json(): n="+str(count1)+" r.destination="+str(r.destination)+" qival="+str(qival)+" => result="+str(result))
     for rval in result:
       if route_applier__peers_related==None or rval.data in route_applier__peers_related:
         peer_name_tmp = rval.data.peer_name
         break

   except Exception as e:
       logger.error("iprange_match::get_matching_related_peer_for_rule_destination(): got exception: "+str(e), exc_info=True)

   return peer_name_tmp


