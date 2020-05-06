#!/usr/bin/env python
#!/usr/bin/python3
# -*- coding: utf-8 -*-
#

from sys import argv
from os import environ
import os.path
import os

import requests
import json
import traceback
import sys

import time

##############################################################################
##############################################################################

def printme( str ):
   "This prints a passed string into this function"
   print (str)
   return

##############################################################################
##############################################################################

url__api_rules__rel = '/api/rules/'
url__api_routes__rel = '/api/routes/'

def create_fodcon_handle(proto, server_addr, use_ssl_verify, token, username):
  print ("proto="+str(proto), file=sys.stderr)
  print ("server_addr="+str(server_addr), file=sys.stderr)
  print ("use_ssl_verify="+str(use_ssl_verify), file=sys.stderr)
  print ("token="+str(token), file=sys.stderr)
  print ("username="+str(username), file=sys.stderr)
  print ("", file=sys.stderr)
  return {
    "url__api_base" : proto + '://' + server_addr,
    "fod_api_headers" : {
        "Authorization" : "Token " + token,
      },
    "ssl_verify" : use_ssl_verify,
    "username" : username,
  }

##############################################################################
##############################################################################
##############################################################################
##############################################################################

if environ.get('FOD_SERVER_ADDR') != None:
  FOD_RULE_API__SERVER_ADDR = environ.get('FOD_SERVER_ADDR')
elif environ.get('SERVER_ADDR') != None:
  FOD_RULE_API__SERVER_ADDR = environ.get('SERVER_ADDR')
else:
  #FOD_RULE_API__SERVER_ADDR = '127.0.0.1:8082'
  #FOD_RULE_API__SERVER_ADDR = '127.0.0.1:8000'
  FOD_RULE_API__SERVER_ADDR = '127.0.0.1:80'

if environ.get('FOD_TOKEN') != None:
  TOKEN = environ.get('FOD_TOKEN')
elif environ.get('TOKEN') != None:
  TOKEN = environ.get('TOKEN')
#else:

proto = "http"
if environ.get('FOD_SERVER_ADDR__USE_HTTPS') == '1':
  proto='https'
elif environ.get('SERVER_ADDR__USE_HTTPS') == '1':
  proto='https'

#ssl_verify = True
ssl_verify = False
if environ.get('FOD_SERVER_ADDR__USE_SSL_VERIFY') == '1':
  ssl_verify = True

username = "admin"
if environ.get('FOD_USERNAME') != None:
  username = environ.get('FOD_USERNAME')

print ("fod_con1:", file=sys.stderr)
fod_con1 = create_fodcon_handle(proto, FOD_RULE_API__SERVER_ADDR, ssl_verify, TOKEN, username)
print ("", file=sys.stderr)

##############################################################################
##############################################################################
##############################################################################
##############################################################################

def fod_rule_api__get_rules1(fod_con, id=None):

  fod_api_headers=fod_con["fod_api_headers"]
  url__api_rules=fod_con["url__api_base"]+url__api_rules__rel
  ssl_verify=fod_con["ssl_verify"]

  if id==None:
    response = requests.get(url__api_rules, headers=fod_api_headers, verify=ssl_verify)
  else:
    response = requests.get(url__api_rules+str(id)+'/', headers=fod_api_headers, verify=ssl_verify)

  #print response.headers
  #print response.text

  json_data = response.text
  json_parsed = json.loads(json_data)
  return json_parsed

def fod_rule_api__get_routes1(fod_con, id=None):

  fod_api_headers=fod_con["fod_api_headers"]
  url__api_routes=fod_con["url__api_base"]+url__api_routes__rel
  ssl_verify=fod_con["ssl_verify"]

  if id==None:
    response = requests.get(url__api_routes, headers=fod_api_headers, verify=ssl_verify)
  else:
    response = requests.get(url__api_routes+str(id)+'/', headers=fod_api_headers, verify=ssl_verify)

  #print response.headers
  #print response.text

  json_data = response.text

  json_parsed = json.loads(json_data)

  print (json.dumps(json_parsed, indent=4, sort_keys=True))

  #print type(json_parsed)
  #print dir(json_parsed)
  #print json_parsed[0].get("name")
  #for el in json_parsed:
  #  print el
  #print

  if id==None:
    json_hashed = dict((el.get("name"), el) for el in json_parsed) 
    print (json_hashed.get("test_port0_T03QQL"), file=sys.stderr)
    print (json.dumps(json_hashed.get("test_port0_T03QQL"), indent=4, sort_keys=True), file=sys.stderr)
    for key in json_hashed:
      print (key, file=sys.stderr)

  return json_parsed

##############################################################################
##############################################################################

#  curl  -X POST -F "name=Example5" -F "comments=Description" -F "status=INACTIVE" -F "source=0.0.0.0/0" -F "sourceport=30" -F "destination=10.0.0.56" F destinationport="1020,80-90,101" -F "then=https://fod.example.com/api/thenactions/3/" -H "Authorization: Token $TOKEN" "http://$SERVER_ADDR/api/routes/"
#The normal attribute specification for "name", "source", "destination", and "then" are required; Currently the combination of source and destinantion of a new rule to be created has to different to any combination of source and destination of any existsing rule; after it has been created, each rule can be changed without this restriction; status can be "INACTIVE" or "ACTIVE"

def handle_json_answer(response):
  #print response.headers
  #print response.text

  status_code = response.status_code
  json_data = response.text
  #print ("json_data=", json_data, file=sys.stderr)
  print ("response=", str(response), file=sys.stderr)
  print ("response.dir=", str(dir(response)), file=sys.stderr)
  if (not json_data is None and json_data != ""):
    try:
      json_parsed = json.loads(json_data) 
    except:
      json_parsed = json_data
  else:
    json_parsed = ""
  return json_parsed, status_code

def fod_rule_api__create_rule(fod_con, name="Example1", then=[], routes=[], comments="test comment", editing=True):

  fod_api_headers=fod_con["fod_api_headers"]
  url__api_rules=fod_con["url__api_base"]+url__api_rules__rel
  ssl_verify=fod_con["ssl_verify"]
  username = fod_con["username"]

  data = dict( 
      #applier_overriden = "tomas.jra2t6",
      #applier = "tomas.jra2t6",
      applier_username = username,
      name = name, 
      #comments = "auto generated as proposal from NSHaRP DDoS event", 
      comments = comments, 
      #status = "INACTIVE", 
      status = "CREATED", 
      #source = source, 
      #sourceport = sourceport, 
      #destination = destination, 
      #destinationport = destinationport, 
      #protocol = protocol_list,
      #then = ["https://fod.example.com/api/thenactions/3/"], 
      then = then, 
      routes = routes,
      expires = "2020-05-09",
      editing=True
    )

  response = requests.post(url__api_rules, headers=fod_api_headers, data=data, verify=ssl_verify)
  return handle_json_answer(response)

def fod_rule_api__create_route_old15(fod_con, name="Example1", source="9.9.9.2", sourceport="30", destination="10.0.0.57", destinationport="1020,80-90,101", protocol_list=[], then=[], comments="test comment"):

  fod_api_headers=fod_con["fod_api_headers"]
  url__api_routes=fod_con["url__api_base"]+url__api_routes__rel
  ssl_verify=fod_con["ssl_verify"]
  username = fod_con["username"]
  print (username, file=sys.stderr);

  data = dict( 
      #applier_overriden = "tomas.jra2t6",
      applier_overriden = "admin",
      #applier = "tomas.jra2t6",
      applier = "admin",
      applier_username = "admin",
      #applier = username,
      #rule = rule,
      name = name, 
      #comments = "auto generated as proposal from NSHaRP DDoS event", 
      comments = comments, 
      status = "INACTIVE", 
      source = source, 
      sourceport = sourceport, 
      destination = destination, 
      destinationport = destinationport, 
      protocol = protocol_list,
      then = ["https://fod.example.com/api/thenactions/3/"], 
      expires = "2020-05-28",
      dscp = None
    )

  response = requests.post(url__api_routes, headers=fod_api_headers, data=data, verify=ssl_verify)
  return handle_json_answer(response)


#def fod_rule_api__create_route(name):
#def fod_rule_api__create_route(name="Example1", source="9.9.9.2", sourceport="30", destination="10.0.0.57", destinationport="1020,80-90,101", protocol_list=[], then=[], comments="test comment"):
def fod_rule_api__create_route(fod_con, rule=None, name="Example1", source="9.9.9.2", sourceport="30", destination="10.0.0.57", destinationport="1020,80-90,101", protocol_list=[], comments="test comment"):

  fod_api_headers=fod_con["fod_api_headers"]
  url__api_routes=fod_con["url__api_base"]+url__api_routes__rel
  ssl_verify=fod_con["ssl_verify"]
  username = fod_con["username"]

  data = dict( 
      #applier_overriden = "tomas.jra2t6",
      #applier = "tomas.jra2t6",
      applier = username,
      rule = rule,
      name = name, 
      #comments = "auto generated as proposal from NSHaRP DDoS event", 
      comments = comments, 
      status = "INACTIVE", 
      source = source, 
      sourceport = sourceport, 
      destination = destination, 
      destinationport = destinationport, 
      protocol = protocol_list,
      then = ["https://fod.example.com/api/thenactions/3/"], 
      #expires = "2018-03-18"    
    )

  response = requests.post(url__api_routes, headers=fod_api_headers, data=data, verify=ssl_verify)
  return handle_json_answer(response)

#def fod_rule_api__change_rule(id, name="Example1", source="9.9.9.2"):
def fod_rule_api__change_rule(fod_con, id, name="Example1"):

  fod_api_headers=fod_con["fod_api_headers"]
  url__api_rules=fod_con["url__api_base"]+url__api_rules__rel
  ssl_verify=fod_con["ssl_verify"]

  data = dict( 
      id = id,
      name = name, 
      comments = "Description", 
      status = "INACTIVE", 
      #source = source, 
      #sourceport = "30", 
      #destination = "10.0.0.57", 
      #destinationport = "1020,80-90,101", 
      then = ["https://fod.example.com/api/thenactions/3/"], 
      expires = "2018-03-20"    
    )

  response = requests.put(url__api_rules+str(id)+'/', headers=fod_api_headers, data=data, verify=ssl_verify)
  return handle_json_answer(response)

def fod_rule_api__change_rule__partial(fod_con, id, status="INACTIVE",  editing=True):

  fod_api_headers=fod_con["fod_api_headers"]
  url__api_rules=fod_con["url__api_base"]+url__api_rules__rel
  ssl_verify=fod_con["ssl_verify"]

  data = dict( 
      id = id,
      editing = editing,
      status = status
      #routes = routes
    )

  response = requests.patch(url__api_rules+str(id)+'/', headers=fod_api_headers, data=data, verify=ssl_verify)
  return handle_json_answer(response)

def fod_rule_api__change_route(fod_con, id, name="Example1", source="9.9.9.2"):

  fod_api_headers=fod_con["fod_api_headers"]
  url__api_routes=fod_con["url__api_base"]+url__api_routes__rel
  ssl_verify=fod_con["ssl_verify"]

  data = dict( 
      id = id,
      name = name, 
      comments = "Description", 
      status = "INACTIVE", 
      source = source, 
      sourceport = "30", 
      destination = "10.0.0.57", 
      destinationport = "1020,80-90,101", 
      #then = ["https://fod.example.com/api/thenactions/3/"], 
      #expires = "2018-03-20"    
    )

  response = requests.put(url__api_routes+str(id)+'/', headers=fod_api_headers, data=data, verify=ssl_verify)
  return handle_json_answer(response)

def fod_rule_api__delete_rule(fod_con, id):

  fod_api_headers=fod_con["fod_api_headers"]
  url__api_rules=fod_con["url__api_base"]+url__api_rules__rel
  ssl_verify=fod_con["ssl_verify"]

  response = requests.delete(url__api_rules+str(id)+'/', headers=fod_api_headers, verify=ssl_verify)

  status_code = response.status_code

  print (response.headers, file=sys.stderr)
  print (response.text, file=sys.stderr)

  return response.text, status_code

def fod_rule_api__delete_route(fod_con, id):

  fod_api_headers=fod_con["fod_api_headers"]
  url__api_routes=fod_con["url__api_base"]+url__api_routes__rel
  ssl_verify=fod_con["ssl_verify"]

  response = requests.delete(url__api_routes+str(id)+'/', headers=fod_api_headers, verify=ssl_verify)
  
  status_code = response.status_code

  print (response.headers, file=sys.stderr)
  print (response.text, file=sys.stderr)

  return response.text, status_code

def fod_set_up_rule(fod_con, rule, routes):
  """Push prepared rule & routes to FOD"""
  try:
    rule_obj, status_code = fod_rule_api__create_rule(fod_con, **rule)
    json.dump(rule_obj, open("fod_create_rule_reply", "w"))
    #exit(1)
    print ("rule_obj items:", type(rule_obj), file=sys.stderr)
    #print "rule_obj items:", len(rule_obj)
    #assert(len(rule_obj) == 1)
    #rule_obj = rule_obj[0]
  except Exception as e:
    print ("exception in fod_rule_api__create_rule: "+str(e), file=sys.stderr)
    raise

  rule_name = str(rule_obj['name'])
  rule_url =  str(rule_obj['url'])

  print (rule_obj, file=sys.stderr)
  print ("url="+rule_url, file=sys.stderr)
  print ("rule_name="+rule_name, file=sys.stderr)

  count_created_routes=0
  for route in routes:
    try:
      route['rule'] = rule_url
      route['name'] = rule_name
      route_obj, status_code = fod_rule_api__create_route(fod_con, **route)
      if status_code==0 or status_code==201:
        count_created_routes=count_created_routes+1
      else:
        print ("for source="+str(route['source'])+", destination="+str(route['destination'])+" :", file=sys.stderr)
        print ("route creation failed: status_code="+str(status_code)+" : "+str(route_obj), file=sys.stderr)
    except Exception as e:
      print ("exception in fod_rule_api__create_route: attacker_ipv4="+str(route['source'])+" :"+str(e), file=sys.stderr)
      raise  

  if count_created_routes==0:
    print ("no routes created for rule, aborting rule creation", file=sys.stderr)

    try:
      rule_obj2, status_code = fod_rule_api__change_rule__partial(fod_con,
        rule_obj['id'],
        status="INACTIVE_TODELETE", # only allowed to FoD admins, which FRU user should be
        #status="ACTIVE",
        #routes=[route_obj['url']],
        #routes=route_url_list,        
        editing=False,
       )
  
      response1, status_code = fod_rule_api__delete_rule(fod_con, rule_obj['id'])
      if status_code!=0 and status_code!=204:
        print ("rule deletion failed: status_code="+str(status_code)+" : "+str(response1), file=sys.stderr)

    except Exception as e:
      print ("exception in fod_rule_api__change_rule__partial: "+str(e), file=sys.stderr)
      raise

  else:

    try:
      rule_obj2, status_code = fod_rule_api__change_rule__partial(fod_con,
        rule_obj['id'],
        status="INACTIVE",
        #status="ACTIVE",
        #routes=[route_obj['url']],
        #routes=route_url_list,
        editing=False,
       )
    except Exception as e:
      print ("exception in fod_rule_api__change_rule__partial: "+str(e), file=sys.stderr)
      raise

##############################################################################
##############################################################################

if __name__ == "__main__":
    #main_fru()
        

    if argv.__len__() >= 2 and argv[1] == "--get1":
      fod_rule_api__get_routes1(fod_con1, argv[2])
    elif argv.__len__() >= 2 and argv[1] == "--crea":
      print("crea", file=sys.stderr)
      json_parsed, status_code = fod_rule_api__create_route_old15(fod_con1, name=argv[2], source=argv[3])
      print ("status_code=", status_code, file=sys.stderr)
      print ("json_parsed=", json_parsed, file=sys.stderr)
    elif argv.__len__() >= 2 and argv[1] == "--chg":
      fod_rule_api__change_route(fod_con1, argv[2], argv[3], argv[4])

    elif argv.__len__() >= 2 and argv[1] == "--del":
      fod_rule_api__delete_route(fod_con1, argv[2])
    else:
      fod_rule_api__get_routes1(fod_con1)


##############################################################################
##############################################################################
##############################################################################
##############################################################################

