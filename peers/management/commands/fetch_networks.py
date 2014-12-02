# -*- coding: utf-8 -*- vim:encoding=utf-8:
# vim: tabstop=4:shiftwidth=4:softtabstop=4:expandtab

# Copyright (C) 2010-2014 GRNET S.A.
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

from django.core.management.base import BaseCommand, CommandError
from flowspy.peers.models import *

class Command(BaseCommand):
    args = ''
    help = 'Fetches networks for each peer in database'

    def handle(self, *args, **options):
        for p in Peer.objects.all():
            self.stdout.write('Fetching networks for %s...' % p.peer_name.encode('utf8'))
            p.fill_networks()
            self.stdout.write('done\n')
        self.stdout.write('Finished!\n')