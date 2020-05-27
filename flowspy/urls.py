from django.conf.urls import include, url
from django.urls import path
from django.views.generic import TemplateView
from django.conf import settings
from django.contrib import admin
from django.contrib.auth.views import LoginView
from rest_framework import routers
from flowspec import views as flowspec_views
from accounts import views as accounts_views
from flowspec.viewsets import (
    RouteViewSet,
    PortViewSet,
    ThenActionViewSet,
    FragmentTypeViewSet,
    MatchProtocolViewSet,
    MatchDscpViewSet,
    StatsRoutesViewSet,
)
from django_registration import views as registration_views

admin.autodiscover()

# Routers provide an easy way of automatically determining the URL conf.
router = routers.DefaultRouter()
router.register(r'routes', RouteViewSet, basename='route')
router.register(r'ports', PortViewSet)
router.register(r'thenactions', ThenActionViewSet)
router.register(r'fragmentypes', FragmentTypeViewSet)
router.register(r'matchprotocol', MatchProtocolViewSet)
router.register(r'matchdscp', MatchDscpViewSet)
router.register(r'stats/routes', StatsRoutesViewSet, basename='statsroute')


urlpatterns = [
    path('poll/', include('poller.urls')),
    path('', flowspec_views.group_routes, name="group-routes"),
    url(r'^routes_ajax/?$', flowspec_views.group_routes_ajax, name="group-routes-ajax"),
    url(r'^overview_ajax/?$', flowspec_views.overview_routes_ajax, name="overview-ajax"),
    path('dashboard/', flowspec_views.dashboard, name="dashboard"),
    url(r'^profile/?$', flowspec_views.user_profile, name="user-profile"),
    url(r'^add/?$', flowspec_views.add_route, name="add-route"),
    url(r'^addport/?$', flowspec_views.add_port, name="add-port"),
    url(r'^edit/(?P<route_slug>[\w\-]+)/$', flowspec_views.edit_route, name="edit-route"),
    url(r'^delete/(?P<route_slug>[\w\-]+)/$', flowspec_views.delete_route, name="delete-route"),
    url(r'^login/?', flowspec_views.user_login, name="login"),
    path('welcome/', flowspec_views.welcome, name="welcome"),
    url(r'^logout/?', flowspec_views.user_logout, name="logout"),
    # TODO (r'^setlang/?$', django.views.i18n.set_language),
    path('/', include('django.conf.urls.i18n')),
    url(r'^selectinst/?$', flowspec_views.selectinst, name="selectinst"),
    url(r'^profile/token/$', accounts_views.generate_token, name="user-profile-token"),

    # Account registration process - activation is partially done by FoD, other URLs are included from django_registration
    url(r'^accounts/activate/(?P<activation_key>[-:\w]+)/$', accounts_views.activate, name='activate_account'),
    path('accounts/', include('django_registration.backends.activation.urls')),
    url(r'^activate/complete/$', TemplateView.as_view(template_name='django_registration/activation_complete.html'), name='registration_activation_complete'),

    url(r'^load_js/(?P<file>[\w\s\d_-]+)/$', flowspec_views.load_jscript, name="load-js"),
    path('altlogin/', LoginView.as_view(template_name='overview/login.html'), name="altlogin"),
    path('admin/', admin.site.urls),
    path('tinymce/', include('tinymce.urls')),
    url(r'^overview/?$', flowspec_views.overview, name="overview"),
    url(r'^api/', include(router.urls)),
    url(r'^details/(?P<route_slug>[\w\-]+)/$', flowspec_views.routedetails, name="route-details"),
    url(r'^routestats/(?P<route_slug>[\w\-]+)/$', flowspec_views.routestats, name="routestats"),
    url(r'^setup/', flowspec_views.setup, name='setup'),
]

if 'graphs' in settings.INSTALLED_APPS:
    from graphs import urls as graphs_urls
    urlpatterns += ('', url(r'^graphs/', include('graphs.urls')),)


try:
    if settings.DEBUG:
        # only for development / testing mode:
        from django.contrib.staticfiles.urls import staticfiles_urlpatterns
        urlpatterns += staticfiles_urlpatterns()
except:
    pass

