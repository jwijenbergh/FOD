# -*- coding: utf-8 -*- vim:fileencoding=utf-8:
# vim: tabstop=4:shiftwidth=4:softtabstop=4:expandtab
# Django settings for flowspy project.
# Copyright © 2011-2015 Greek Research and Technology Network (GRNET S.A.)
# Copyright © 2011-2014 Leonidas Poulopoulos (@leopoul)
# Copyright © 2014-2015 Stavros Kroustouris (@kroustou)
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

# _uuid_generate_random was deprecated and removed in newer python
import uuid
uuid._uuid_generate_random = None
try:
    from uuid import _uuid_generate_random
except ImportError:
    _uuid_generate_random = None

import os
import djcelery
djcelery.setup_loader()
from celery.schedules import crontab

DEBUG = True
TEMPLATE_DEBUG = DEBUG

ADMINS = (
    ('AdminName', 'admin@example.com'),
)
MANAGERS = ADMINS
here = lambda x: os.path.join(os.path.abspath(os.path.dirname(__file__)), x)
BASE_DIR = os.path.dirname(os.path.dirname(__file__))

# Hosts/domain names that are valid for this site; required if DEBUG is False
ALLOWED_HOSTS = ['*']
SITE_ID = 1

# Place a sequence of random chars here
SECRET_KEY = '@sa@5234#$%345345^@#$%*()123^@12!&!()$JMNDF#$@(@#8FRNJWX_'

# Set up database

DATABASES = {
    'default': {
        'ENGINE': 'django.db.backends.sqlite3',  # Add 'postgresql_psycopg2', 'mysql', 'sqlite3' or 'oracle'.
        'NAME': 'example-data',
        'USER': '',
        'PASSWORD': '',
        'HOST': '',                      # Set to empty string for localhost.
        'PORT': '',                      # Set to empty string for default.
    }
}

# Local time zone for this installation. Choices can be found here:
# http://en.wikipedia.org/wiki/List_of_tz_zones_by_name
# although not all choices may be available on all operating systems.
# In a Windows environment this must be set to your system time zone.
#TIME_ZONE = 'Europe/Athens'
TIME_ZONE = 'UTC'

# Language code for this installation. All choices can be found here:
# http://www.i18nguy.com/unicode/language-identifiers.html
LANGUAGE_CODE = 'en'

# Language code for this installation. All choices can be found here:
# http://www.i18nguy.com/unicode/language-identifiers.html
_ = lambda s: s

LANGUAGES = (
    ('el', _('Greek')),
    ('en', _('English')),
)

LOCALE_PATHS = (
    os.path.join(os.path.dirname(os.path.dirname(os.path.abspath(__file__))), 'locale'),
)

# If you set this to False, Django will make some optimizations so as not
# to load the internationalization machinery.
USE_I18N = True

# If you set this to False, Django will not format dates, numbers and
# calendars according to the current locale.
USE_L10N = True

# If you set this to False, Django will not use timezone-aware datetimes.
USE_TZ = True

PROJECT_PATH = os.path.abspath(os.path.dirname(__file__))
STATIC_ROOT = os.path.join(BASE_DIR)
STATICFILES_DIRS = ( os.path.join(BASE_DIR, 'static'), )
STATIC_URL = '/static/'
STATICFILES_FINDERS = (
    'django.contrib.staticfiles.finders.FileSystemFinder',
    'django.contrib.staticfiles.finders.AppDirectoriesFinder',
)

# Templates
TEMPLATE_DIRS = (
    os.path.join(BASE_DIR, 'templates'),
    os.path.join('/srv/venv/django/contrib/admin/templates/'),
)

TEMPLATE_LOADERS = (
    'django.template.loaders.filesystem.Loader',
    'django.template.loaders.app_directories.Loader',
)

TEMPLATE_CONTEXT_PROCESSORS = (
    "django.contrib.auth.context_processors.auth",
    "django.core.context_processors.debug",
    "django.core.context_processors.i18n",
    "django.core.context_processors.media",
    "django.core.context_processors.static",
    "django.contrib.messages.context_processors.messages",
    "context.global_vars.settings_vars",
)

MIDDLEWARE_CLASSES = (
    'django.middleware.cache.UpdateCacheMiddleware',
    'django.middleware.common.CommonMiddleware',
    'django.contrib.sessions.middleware.SessionMiddleware',
    'django.middleware.locale.LocaleMiddleware',
    'django.middleware.csrf.CsrfViewMiddleware',
    'django.contrib.auth.middleware.AuthenticationMiddleware',
    'django.contrib.messages.middleware.MessageMiddleware',
    'django.middleware.cache.FetchFromCacheMiddleware',
    'django.contrib.flatpages.middleware.FlatpageFallbackMiddleware',
)

ROOT_URLCONF = 'flowspy.urls'
WSGI_APPLICATION = 'flowspy.wsgi.application'

AUTHENTICATION_BACKENDS = (
    'djangobackends.shibauthBackend.shibauthBackend',
    'django.contrib.auth.backends.ModelBackend',
)

INSTALLED_APPS = (
    'longerusername',
    'django.contrib.auth',
    'django.contrib.contenttypes',
    'django.contrib.sessions',
    'django.contrib.sites',
    'django.contrib.flatpages',
    'django.contrib.messages',
    'django.contrib.staticfiles',
    'flowspec',
    'poller',
    'south',
    'django.contrib.admin',
    'djcelery',
    'peers',
    'registration',
    'accounts',
    'tinymce',
    'widget_tweaks',
    'rest_framework',
    'rest_framework.authtoken',
)

#GRAPHS_API_URL = 'graphs'
GRAPHS_API_URL = 'http://127.0.0.1:8080/api/routes/'

# A sample logging configuration. The only tangible logging
# performed by this configuration is to send an email to
# the site admins on every HTTP 500 error when DEBUG=False.
# See http://docs.djangoproject.com/en/dev/topics/logging for
# more details on how to customize your logging configuration.
LOGGING = {
    'version': 1,
    'disable_existing_loggers': False,
    'handlers': {
        'file': {
            'level': 'DEBUG',
            'class': 'logging.FileHandler',
            'filename': 'debug.log',
        },
    },
    'loggers': {
        'django': {
            'handlers': ['file'],
            'level': 'DEBUG',
            'propagate': True,
        },
    },
}

LOGIN_URL = '/welcome'

# CACHES = {
#     'default': {
#         'BACKEND': 'django.core.cache.backends.memcached.MemcachedCache',
#         'LOCATION': '127.0.0.1:11211',
#     }
# }
CACHES = {
    'default': {
        'BACKEND': 'django.core.cache.backends.dummy.DummyCache',
    }
}

AUTH_PROFILE_MODULE = 'accounts.UserProfile'

# Netconf Device credentials
# The following variables should contain the address of the device with
# flowspec, the username and password of the appliers account and the netconf
# port.
NETCONF_DEVICE = ""
NETCONF_USER = ""
NETCONF_PASS = ""
NETCONF_PORT = 830

# The filter applied in the device in order to find the flowspec routes
ROUTES_FILTER = "<configuration><routing-options><flow/></routing-options></configuration>"
ROUTE_FILTER = "<configuration><routing-options><flow><route><name>%s</name></route></flow></routing-options></configuration>"
COMMIT_CONFIRMED_TIMEOUT = "120"

# Change the following values only if you know what you are doing!!!
# To integrate FoD with tables (Peer, Networks, Contacts)
# from your CRM platform, set the following values to False and create the views that are
# exact matches of the tables in peers/models.py
PEER_MANAGED_TABLE = True
PEER_RANGE_MANAGED_TABLE = True
PEER_TECHC_MANAGED_TABLE = True

# Actually apply the rules
COMMIT = True

# Flowspy configuration
#EXPIRATION_DAYS_OFFSET = 7
EXPIRATION_DAYS_OFFSET = 30

USE_X_FORWARDED_HOST = True

# Beanstalk configuration (as a broker for celery)
BROKER_HOST = "localhost"
BROKER_PORT = 11300
POLLS_TUBE = 'polls'
BROKER_URL = "beanstalk://localhost:11300//"
BROKER_VHOST = "/"
CELERY_CONCURRENCY = 1
POLL_SESSION_UPDATE = 60.0

CELERYBEAT_SCHEDULE = {
    "every-day-sync": {
        "task": "flowspec.tasks.check_sync",
        "schedule": crontab(minute=01, hour=01),
        "args": (),
    },
    "notify-expired": {
        "task": "flowspec.tasks.notify_expired",
        "schedule": crontab(minute=01, hour=02),
        "args": (),
    },
    "snmp-stats-poll": {
        "task": "flowspec.tasks.poll_snmp_statistics",
        "schedule": crontab(minute="*/5"),
        "args": (),
    },
}

# List of modules to import when celery starts.
CELERY_IMPORTS = ("flowspec.tasks", )

# Notifications
DISABLE_EMAIL_NOTIFICATION = True
SERVER_EMAIL = "Example FoD Service <noreply@example.com>"
EMAIL_SUBJECT_PREFIX = "[FoD] "
EXPIRATION_NOTIFY_DAYS = 4
# max number of days into the future that is allowed to pick in rule expiration datepicker
MAX_RULE_EXPIRE_DAYS = 30
PREFIX_LENGTH = 29
POLL_SESSION_UPDATE = 60.0

# Shibboleth
#SHIB_AUTH_ENTITLEMENT = 'urn:mace:example.com:pki:user'
SHIB_AUTH_ENTITLEMENT = ''
SHIB_ADMIN_DOMAIN = 'example.com'
SHIB_LOGOUT_URL = 'https://example.com/Shibboleth.sso/Logout'

##############################################################################
# Shibboleth attribute map

# general info on these shibboleth attribute definitions:
# *_DISPLAY_NAME and *_ADDINFO should give edugain-global names and definitions and so match definitions in /etc/shibboleth/attribute-map.xml
# as values of the * variables (SHIB_ENTITLEMENT, SHIB_USERNAME, SHIB_MAIL, SHIB_FIRSTNAME, SHIB_LASTNAME) are in principle only host-config-local keys
#
# values of *_DISPLAY* are shown in edugain/login-related error messages for users; 
# instead, the values of * variables (e.g. SHIB_ENTITLEMENT, ...) are of no use for users and just confusing!
#
# specifically:
# *_DISPLAY_NAME should be a single string fully identifying the required attribute in an human-readable fashion
# *_DISPLAY_ADDINFO should be a string and should correspondingly contain descriptions for each array element of the value of the * variable

# e.g. for SHIB_ENTITLEMENT = "HTTP_ENTITLEMENT" => 
# 
# key in /etc/shibboleth/attribute-map.xml is "entitlement":
#    <Attribute name="urn:mace:dir:attribute-def:eduPersonEntitlement" id="entitlement"/>
#    <Attribute name="urn:oid:1.3.6.1.4.1.5923.1.1.1.7" id="entitlement"-->

#SHIB_ENTITLEMENT = ['HTTP_SHIB_EP_ENTITLEMENT'] # value in settings.py.dist
SHIB_ENTITLEMENT = ['HTTP_ENTITLEMENT']
SHIB_ENTITLEMENT_DISPLAY_NAME = "eduPersonEntitlement"
SHIB_ENTITLEMENT_DISPLAY_ADDINFO = "urn:oid:1.3.6.1.4.1.5923.1.1.1.7; the value of this attribute also has to include 'urn:mace:example.com:pki:user'"
#SHIB_ENTITLEMENT_DISPLAY_ADDINFO = "urn:oid:1.3.6.1.4.1.5923.1.1.1.7"

# (";"-separated) part of value of attribute with key SHIB_ENTITLEMENT needed in order to be considered a valid user:
# if SHIB_AUTH_ENTITLEMENT is empty no constraint on SHIB_ENTITLEMENT attribute value is enforced (can even be missing)
#SHIB_AUTH_ENTITLEMENT = 'urn:mace:example.com:pki:user'
SHIB_AUTH_ENTITLEMENT = '' # is also in settings_local.py so override it there

#SHIB_USERNAME = ['HTTP_EPPN'] # in settings.py.dist # originally used for SHIB_USERNAME
#SHIB_USERNAME_DISPLAY_NAME = "eduPersonPrincipalName"
#SHIB_USERNAME_DISPLAY_ADDINFO = "urn:mace:dir:attribute-def:eduPersonPrincipalName or urn:oid:1.3.6.1.4.1.5923.1.1.1.6"
#SHIB_USERNAME = ['HTTP_PERSISTENT_ID']
SHIB_USERNAME = ['HTTP_PERSISTENT_ID', 'HTTP_PRINCIPALNAME']
#SHIB_USERNAME = ['mail', 'HTTP_MAIL', 'HTTP_SHIB_INETORGPERSON_MAIL']
SHIB_USERNAME_DISPLAY_NAME = "PERSISTENT_ID"
SHIB_USERNAME_DISPLAY_ADDINFO = "urn:oid:1.3.6.1.4.1.5923.1.1.1.10"

#SHIB_SLUGIFY_USERNAME = False # value in settings.py.dist
SHIB_SLUGIFY_USERNAME = True

SHIB_MAIL = ['mail', 'HTTP_MAIL', 'HTTP_SHIB_INETORGPERSON_MAIL']
SHIB_MAIL_DISPLAY_NAME = "MAIL"
SHIB_MAIL_DISPLAY_ADDINFO = "urn:mace:dir:attribute-def:mail or urn:oid:0.9.2342.19200300.100.1.3 or SHIB_INETORGPERSON_MAIL"

# both optional:
SHIB_FIRSTNAME = ['HTTP_SHIB_INETORGPERSON_GIVENNAME'] # value in settings.py.dist
#SHIB_FIRSTNAME = ['HTTP_GIVENNAME']
SHIB_FIRSTNAME_DISPLAY_NAME = "GIVENNAME"
SHIB_FIRSTNAME_DISPLAY_ADDINFO = "urn:mace:dir:attribute-def:givenName or urn:oid:2.5.4.42"

SHIB_LASTNAME = ['HTTP_SHIB_PERSON_SURNAME'] # value in settings.py.dist
#SHIB_LASTNAME = ['HTTP_SURNAME']
SHIB_LASTNAME_DISPLAY_NAME = "SURNAME"
SHIB_LASTNAME_DISPLAY_ADDINFO = "urn:mace:dir:attribute-def:sn or urn:oid:2.5.4.4"

##############################################################################

# BCC mail addresses
NOTIFY_ADMIN_MAILS = ["admin@example.com"]

# Then actions in the ui (dropdown)
UI_USER_THEN_ACTIONS = ['discard', 'rate-limit']
UI_USER_PROTOCOLS = ['icmp', 'tcp', 'udp']
ACCOUNT_ACTIVATION_DAYS = 7

# Define subnets that should not have any rules applied whatsoever
PROTECTED_SUBNETS = ['10.10.0.0/16']

# Add two whois servers in order to be able to get all the subnets for an AS.
PRIMARY_WHOIS = 'whois.example.com'
ALTERNATE_WHOIS = 'whois.example.net'

TINYMCE_JS_URL = STATIC_URL + 'js/tinymce/tiny_mce.js'

TINYMCE_DEFAULT_CONFIG = {
    'extended_valid_elements': 'iframe[src|width|height|name|align]',
    'plugins': "table,spellchecker,paste,searchreplace",
    'theme': "advanced",
}

import _version
SW_VERSION = _version.VERSION

LOG_FILE_LOCATION = "/var/log/fod"


BRANDING = {
    'name': 'Example',
    'url': 'https://example.com',
    'footer_iframe': 'https://example.com/iframe',
    'facebook': '//facebook.com/',
    'twitter': '//twitter.com/',
    'phone': '800-example-com',
    'email': 'helpdesk@example.com',
    'logo': 'fodlogo2.png',
    'favicon': 'favicon.ico',
}


# Django Rest Framework configuration.
# You should leave this intact.
REST_FRAMEWORK = {
    'DEFAULT_AUTHENTICATION_CLASSES': (
        'rest_framework.authentication.TokenAuthentication',
    ),
    'DEFAULT_RENDERER_CLASSES': (
        'rest_framework.renderers.JSONRenderer',
    ),
    'DEFAULT_PERMISSION_CLASSES': [
        'rest_framework.permissions.DjangoModelPermissions',
        'rest_framework.permissions.IsAuthenticated'
    ]
}

# Limit of ports in 'ports' / 'SrcPorts' / 'DstPorts' of a rule:
#PORTRANGE_LIMIT = 100
PORTRANGE_LIMIT = 65535

# Statistics polled via SNMP:
# Default community string
SNMP_COMMUNITY = "abcd"

# list of IP addresses, each IP is a dict with "ip", "port" (optional, default
# is 161), "community" (optional, default is SNMP_COMMUNITY) keys
SNMP_IP = [
    {"ip": "192.168.0.1", "port": 1000},
    {"ip": "192.168.0.2", "port": 1001, "community": "abcdef"},
    {"ip": "192.168.0.3", "port": 1002},
    {"ip": "192.168.0.4", "port": 1002}
]

# or simpler way of IP list:
# SNMP_IP = ["10.0.0.1", "10.0.0.2"]

# OID of bytes counter (currently unused)
SNMP_CNTBYTES =     "1.3.6.1.4.1.2636.3.5.2.1.5"
# OID of packet counter
SNMP_CNTPACKETS =   "1.3.6.1.4.1.2636.3.5.2.1.4"

# get only statistics of specified tables
SNMP_RULESFILTER = ["__flowspec_default_inet__", "__flowspec_IAS_inet__"]
# load new data into cache if it is older that a specified number of seconds
SNMP_POLL_INTERVAL = 8 #seconds
# cache file for data
SNMP_TEMP_FILE = "/tmp/snmp_temp_data"
SNMP_POLL_LOCK = "/var/run/fod/snmppoll.lock"

# Number of historical values to store for a route.
# Polling interval must be set for "snmp-stats-poll" celery task in CELERYBEAT_SCHEDULE.
# By default, it is 5 min interval, so SNMP_MAX_SAMPLECOUNT=12 means we have about
# one hour history.
SNMP_MAX_SAMPLECOUNT = 12

# Age of inactive routes that can be already removed (in seconds)
SNMP_REMOVE_RULES_AFTER = 3600

##############################################################################
##############################################################################

# REST API config (v1.6 only)

DISABLE_RULE_OVERLAP_CHECK = False

ALLOW_DELETE_FULL_FOR_NONADMIN = False

MAIL_NOTIFICATION_TO_ALL_MATCHING_PEERS = True

# statistics calc

STATISTICS_PER_MATCHACTION_ADD_FINAL_ZERO = False # not necessary if STATISTICS_PER_RULE==True
STATISTICS_PER_RULE = True

STATISTICS_PER_RULE__ADD_INITIAL_ZERO = True

##############################################################################
##############################################################################

#MYSETTING1="default"
#from settings_local import *
from flowspy.settings_local import *

#print "MYSETTING1="+MYSETTING1
#print("MYSETTING1="+MYSETTING1, file=sys.stderr)
#print "debug settings.NOTIFY_ADMIN_MAILS="+str(NOTIFY_ADMIN_MAILS)

##############################################################################
##############################################################################

