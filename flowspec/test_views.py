import pytest
from views import welcome

#@pytest.mark.asyncio
#async def test_welcome(async_rf):
#    request = await aync_rf.get('/welcome/')
#    response = welcome(request)
#    assert response.status_code == 200


def test_welcome(rf):
    request = rf.get('/welcome/')
    response = welcome(request)
    assert response.status_code == 200

