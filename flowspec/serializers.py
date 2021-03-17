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

class ThenActionSerializer(serializers.Serializer):
    def to_representation(self, obj):
        if obj.action_value:
            return f"{obj.action}:{obj.action_value}"
        return obj.action

    def to_internal_value(self, data):
        try:
            action_desc = data.split(":")
            action = action_desc[0]
            action_value = action_desc[1] if len(action_desc) > 1 else "" 
            return ThenAction.objects.get(action=action, action_value=action_value)
        except ThenAction.DoesNotExist:
            raise serializers.ValidationError('ThenAction does not exist.')

class MatchProtocolSerializer(serializers.Serializer):
    def to_representation(self, obj):
        return obj.protocol

    def to_internal_value(self, data):
        try:
            protocol = data
            return MatchProtocol.objects.get(protocol=protocol)
        except MatchProtocol.DoesNotExist:
            raise serializers.ValidationError('MatchProtocol does not exist.')

class RouteSerializer(serializers.HyperlinkedModelSerializer):
    """
    A serializer for `Route` objects
    """
    applier = serializers.CharField(source='applier.username', read_only=True)

    def create(self, validated_data):
        if "applier" not in validated_data:
            u = self.context.get('request').user
            logger.info("Adding applier according to authentized user %s" % u.username)
            validated_data["applier"] = u
        protocol = validated_data.pop('protocol')
        then = validated_data.pop('then')
        route = Route.objects.create(**validated_data)
        route.protocol.set(protocol)
        route.then.set(then)
        return route

    def validate_applier(self, attrs, source):
        user = self.context.get('request').user
        return source

    #def validate_source(self, attrs, source):
    def validate_source(self, source):
        user = self.context.get('request').user
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

    then = ThenActionSerializer(many=True)
    protocol = MatchProtocolSerializer(many=True)
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

class FragmentTypeSerializer(serializers.HyperlinkedModelSerializer):
    class Meta:
        model = FragmentType
        fields = ('id', 'fragmenttype', )
        read_only_fields = ('id', )

class MatchDscpSerializer(serializers.HyperlinkedModelSerializer):
    class Meta:
        model = MatchDscp
        fields = ('id', 'dscp', )
        read_only_fields = ('id', )
