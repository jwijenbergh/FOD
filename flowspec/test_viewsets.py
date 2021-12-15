import sys
import pytest
from viewsets import *
from flowspec.models import *
from accounts.models import *
from rest_framework.authtoken.models import Token

@pytest.fixture
def test_settings(settings):
    settings.DEBUG = True
    settings.LOG_FILE_LOCATION = "/srv/flowspy/log/testing"

pytestmark = pytest.mark.django_db

@pytest.fixture(scope='session')
def api_client(django_db_blocker):
  with django_db_blocker.unblock():
    settings.DEBUG = True
    settings.LOG_FILE_LOCATION = "/srv/flowspy/log/testing"

    from rest_framework.test import APIClient

    #token = Token.objects.get(user__username='admin').key
    username='admin'
    try:
      #print("adminuser list="+str(User.objects), file=sys.stderr)
      print("adminuser list="+str([x.username for x in User.objects.filter()]), file=sys.stderr)
      adminuser = User.objects.get(username=username)
      print("adminuser existing used", file=sys.stderr)
    except Exception as e:
      print("adminuser exception "+str(e), file=sys.stderr)
      adminuser = User.objects.create(username=username)
      print("adminuser created", file=sys.stderr)
    print("adminuser="+str(adminuser), file=sys.stderr)

    try:
      ap = UserProfile.objects.get(user=adminuser)
      print("ap existing used", file=sys.stderr)
    except Exception as e:
      print("ap exception "+str(e), file=sys.stderr)
      ap = UserProfile(user=adminuser)
      ap.save()
      print("ap created", file=sys.stderr)
    print("ap="+str(ap), file=sys.stderr)

    try:
      an = PeerRange.objects.get(network="0.0.0.0/0")
      print("an existing used", file=sys.stderr)
    except Exception as e:
      print("an exception "+str(e), file=sys.stderr)
      an = PeerRange.objects.create(network="0.0.0.0/0")
      print("an created", file=sys.stderr)
      #an = PeerRange(network="0.0.0.0/0")
      #an.save() 
    print("an="+str(an), file=sys.stderr)

    try:
      aPeer = Peer.objects.get(peer_name="allnet")
      print("aPeer existing used", file=sys.stderr)
    except Exception as e:
      print("aPeer exception "+str(e), file=sys.stderr)
      aPeer = Peer(peer_id=100, peer_name="allnet")
      aPeer.save()
      aPeer.networks.set([an])
      ap.peers.set([aPeer])
      print("aPeer created", file=sys.stderr)
    print("aPeer="+str(aPeer), file=sys.stderr)

    try:
      token = Token.objects.get(user__username=username).key
      print("token existing used", file=sys.stderr)
    except Token.DoesNotExist:
      token = Token.objects.create(user=adminuser).key
      print("token created", file=sys.stderr)
    print("token="+str(token), file=sys.stderr)

    api_client = APIClient()
    api_client.credentials(HTTP_AUTHORIZATION='Token ' + token)
    return api_client


@pytest.fixture(scope='session')
def django_db_setup():
    settings.DATABASES['default'] = {
        'ENGINE': 'django.db.backends.sqlite3',
        'NAME': 'example-data',
        'USER': '',
        'PASSWORD': '',
        'HOST': '',
        'PORT': '',
    }
    #django_setup2()

pytestmark = pytest.mark.django_db


##@pytest.fixture(scope='session')
#def django_setup2():
#  print("django_setup2", file=sys.stderr)
#  pytestmark = pytest.mark.django_db
#  #Author.objects.create(name="Joe")
#  #an_author = Author(name="Joe") 
#  #an_author.save() 
#  an = PeerRange.objects.create(network="0.0.0.0/0")
#  #an = PeerRange(network="0.0.0.0/0")
#  #an.save() 
#  print("an="+str(an), file=sys.stderr)
#  aPeer = Peer(peer_id=100, peer_name="allnet")
#  aPeer.save()
#  aPeer.networks.set([an])
#  print("aPeer="+str(aPeer), file=sys.stderr)
#  #adminuser = User.objects.get(username='admin')
#  adminuser = User.objects.create(username='testadmin')
#  try:
#      token = adminuser.auth_token
#  except Token.DoesNotExist:
#      token = Token.objects.create(user=adminuser)
#  ap = UserProfile(user=adminuser)
#  ap.save()
#  ap.peers.set([aPeer])
#  print("ap="+str(ap), file=sys.stderr)

#django_setup2()

#@pytest.fixture
#def user() -> settings.AUTH_USER_MODEL:
#    # return the UserFactory (factoryboy)
#    return UserFactory()

#def test_test1():
#	django_setup2()
 
class TestFragmenttypes:
    def test_list(self, api_client):
        endpoint = '/api/matchprotocol/'
        response = api_client.get(endpoint)
        assert response.status_code == 200
        resp_data = json.loads(response.content)
        assert len(resp_data) == 3
        assert resp_data == [ "icmp", "tcp", "udp" ]


class TestRoute:
    def test_add(self, api_client):
        endpoint = '/api/routes/'
        data = {
            "comments": "test route",
            "destination": "1.0.0.2/32",
            "destinationport": "123",
            "name": "test",
            "protocol": [
                "tcp"
            ],
            "source": "0.0.0.0/0",
            "sourceport": "123",
            "then": ["discard"],
            "status": "ACTIVE"
        }

        response = api_client.post(endpoint, json.dumps(data), content_type='application/json')
        assert response.status_code == 201

        resp_data = json.loads(response.content)
        route_id = resp_data["id"]
        response = api_client.delete(f"{endpoint}{route_id}/")
        print(response.content)

    def test_fail_icmpwithport(self, api_client):
        endpoint = '/api/routes/'
        data = {
            "status": "ACTIVE",
            "comments": "test comment",
            "destination": "1.0.0.3/32",
            "destinationport": "80",
            "name": "test",
            "protocol": ["icmp"],
            "fragmenttype": [
                "is-fragment"
            ],
            "source": "0.0.0.0/0",
            "sourceport": "123",
            "then": ["discard"]
        }

        response = api_client.post(endpoint, json.dumps(data), content_type='application/json')
        assert response.status_code == 400
        assert json.loads(response.content) == {"non_field_errors": ["ICMP protocol does not allow to specify ports"]}


    def test_fail_unknownthenaction(self, api_client):
        endpoint = '/api/routes/'
        data = {
            "status": "ACTIVE",
            "comments": "test comment",
            "destination": "1.0.0.3/32",
            "port": "80",
            "name": "test-unknownthen",
            "source": "0.0.0.0/0",
            "then": ["drop"]
        }
 
        response = api_client.post(endpoint, json.dumps(data), content_type='application/json')
        assert response.status_code == 400
        assert json.loads(response.content) == {"then": [["ThenAction does not exist."]]}


    def test_fail_unknownfragmenttype(self, api_client):
        endpoint = '/api/routes/'
        data = {
            "status": "ACTIVE",
            "comments": "test comment",
            "destination": "1.0.0.3/32",
            "destinationport": "80",
            "name": "test",
            "protocol": [],
            "fragmenttype": [
                "unknown-fragment"
            ],
            "source": "0.0.0.0/0",
            "sourceport": "123",
            "then": ["discard"]
        }
 
        response = api_client.post(endpoint, json.dumps(data), content_type='application/json')
        assert response.status_code == 400
        assert json.loads(response.content) == {'fragmenttype': [['FragmentType does not exist.']]}

    def test_list(self, api_client):
        endpoint = '/api/routes/'
        response = api_client.get(endpoint)
        assert response.status_code == 200
        resp_data = json.loads(response.content)
        print(resp_data)

    def test_add_check(self, api_client, settings):
        settings.DEBUG = True
        settings.LOG_FILE_LOCATION = "/srv/flowspy/log/testing"

        endpoint = '/api/routes/'

        name = "testcreate"
        comments = "test route"
        destination = "1.0.0.2/32"
        destinationport = "123"
        source = "0.0.0.0/0"
        sourceport = "123"
        protocol = [ "tcp" ]
        then = ["discard"]

        data = {
            "name": name,
            "comments": comments,
            "destination": destination,
            "destinationport": destinationport,
            "protocol": protocol,
            "source": source,
            "sourceport": sourceport,
            "then": then,
            "status": "ACTIVE"
        }

        response = api_client.post(endpoint, json.dumps(data), content_type='application/json')

        assert response.status_code == 201


        resp_data = json.loads(response.content)
        print("myresp_data="+str(resp_data))

        route_id = resp_data["id"]
        print("myroute_id="+str(route_id))

        #assert "comments" in resp_data and resp_data.comments == comments
        assert resp_data["comments"] == comments
        assert resp_data["destination"] == destination
        assert resp_data["destinationport"] == destinationport
        assert resp_data["protocol"] == protocol
        assert resp_data["source"] == source
        assert resp_data["sourceport"] == sourceport
        assert resp_data["then"] == then
        
        # lookup created object
        Route.objects.get(id=route_id)
        print("myroute "+str(route_id)+" added")

        #

        endpoint = '/api/routes/' + str(route_id) + '/'
        response = api_client.get(endpoint)
        print("response="+str(response))
        print("route "+str(route_id)+" verified")

        assert response.status_code == 200
        resp_data = json.loads(response.content)
        print(resp_data)

        #

        #response = api_client.delete(f"{endpoint}{route_id}/")
        response = api_client.delete(f"{endpoint}")
        print("route "+str(route_id)+" deleted")
        
        assert response.status_code == 204

        try:
            Route.objects.get(id=route_id)
        except:
            # should be deleted by now
            pass

