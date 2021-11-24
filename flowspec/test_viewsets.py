import pytest
from viewsets import *
from flowspec.models import *
from rest_framework.authtoken.models import Token

@pytest.fixture
def api_client():
    from rest_framework.test import APIClient
    token = Token.objects.get(user__username='admin').key
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

pytestmark = pytest.mark.django_db

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

    def test_add(self, api_client):
        endpoint = '/api/routes/'
        data = {
            "comments": "test route",
            "destination": "1.0.0.2/32",
            "destinationport": "123",
            "name": "testcreate",
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
        
        # lookup created object
        Route.objects.get(id=route_id)

        response = api_client.delete(f"{endpoint}{route_id}/")

        try:
            Route.objects.get(id=route_id)
        except:
            # should be deleted by now
            pass




