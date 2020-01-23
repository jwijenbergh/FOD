"""
Serializers for flowspec models
"""
from rest_framework import serializers
from flowspec.models import (
    Route, MatchPort, ThenAction, FragmentType, MatchProtocol, MatchDscp)
from flowspec.validators import (
    clean_source, clean_destination, clean_expires, clean_status)

from django.conf import settings
import os
import logging
FORMAT = '%(asctime)s %(levelname)s: %(message)s'
logging.basicConfig(format=FORMAT)
logger = logging.getLogger(__name__)
logger.setLevel(logging.DEBUG)
LOG_FILENAME = os.path.join(settings.LOG_FILE_LOCATION, 'mylog.log')
handler = logging.FileHandler(LOG_FILENAME)
formatter = logging.Formatter('%(asctime)s %(levelname)s: %(message)s')
handler.setFormatter(formatter)
logger.addHandler(handler)

class RouteSerializer(serializers.HyperlinkedModelSerializer):
    """
    A serializer for `Route` objects
    """
    applier = serializers.CharField(source='applier_username', read_only=True)

    #def validate_source(self, attrs, source):
    def validate_source(self, source):
        user = self.context.get('request').user
        #logger.info("attrs="+str(attrs))
        source_ip = source #attrs.get('source')
        res = clean_source(user, source_ip)
        if res != source_ip:
            raise serializers.ValidationError(res)
        #return attrs
        return res

    #def validate_destination(self, attrs, source):
    def validate_destination(self, destination):
        user = self.context.get('request').user
        #destination = attrs.get('destination')
        res = clean_destination(user, destination)
        if res != destination:
            raise serializers.ValidationError(res)
        #return attrs
        return res

    #def validate_expires(self, attrs, source):
    def validate_expires(self, expires):
        #expires = attrs.get('expires')
        res = clean_expires(expires)
        if res != expires:
            raise serializers.ValidationError(res)
        #return attrs
        return res

    #def validate_status(self, attrs, source):
    def validate_status(self, status):
        #status = attrs.get('status')
        res = clean_status(status)
        if res != status:
            raise serializers.ValidationError(res)
        #return attrs
        return res

    class Meta:
        model = Route
        fields = (
            'name', 'id', 'comments', 'applier', 'source', 'sourceport',
            'destination', 'destinationport', 'port', 'dscp', 'fragmenttype',
            'icmpcode', 'packetlength', 'protocol', 'tcpflag', 'then', 'filed',
            'last_updated', 'status', 'expires', 'response', 'comments',
            'requesters_address')
        read_only_fields = (
            'requesters_address', 'response', 'last_updated', 'id', 'filed')


class PortSerializer(serializers.HyperlinkedModelSerializer):
    class Meta:
        model = MatchPort
        fields = ('id', 'port', )
        read_only_fields = ('id', )


class ThenActionSerializer(serializers.HyperlinkedModelSerializer):
    class Meta:
        model = ThenAction
        fields = ('id', 'action', 'action_value')
        read_only_fields = ('id', )


class FragmentTypeSerializer(serializers.HyperlinkedModelSerializer):
    class Meta:
        model = FragmentType
        fields = ('id', 'fragmenttype', )
        read_only_fields = ('id', )


class MatchProtocolSerializer(serializers.HyperlinkedModelSerializer):
    class Meta:
        model = MatchProtocol
        fields = ('id', 'protocol', )
        read_only_fields = ('id', )


class MatchDscpSerializer(serializers.HyperlinkedModelSerializer):
    class Meta:
        model = MatchDscp
        fields = ('id', 'dscp', )
        read_only_fields = ('id', )
