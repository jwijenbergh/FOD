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
#from peers.models import *
import psutil

import pytest
#from views import welcome

#

class Command(BaseCommand):
    args = ''
    help = 'test1'

    def add_arguments(self, parser):
      parser.add_argument('--pids_all', nargs='?', type=bool, const=True, default=False, help='pids of all FoD processes')
      parser.add_argument('--pid_gunicorn1', nargs='?', type=bool, const=True, default=False, help='pid of main FoD gunicorn process')
      parser.add_argument('--pid_celery1', nargs='?', type=bool, const=True, default=False, help='pid of main FoD celery process')
      parser.add_argument('--pids_gunicorn', nargs='?', type=bool, const=True, default=False, help='pids of all FoD gunicorn processes')
      parser.add_argument('--pids_celery', nargs='?', type=bool, const=True, default=False, help='pids of all FoD celery processes')
      parser.add_argument('-p', '--pids', nargs='?', type=bool, const=True, default=False, help='pids - main pids of gunicorn and celery')
      parser.add_argument('-P', '--port', nargs='?', type=bool, const=True, default=False, help='gunicorn port')
      parser.add_argument('-L', '--logfiles1', nargs='?', type=bool, const=True, default=False, help='list of log files with pids')
      parser.add_argument('-l', '--logfiles', nargs='?', type=bool, const=True, default=False, help='list of log files')
      
      parser.add_argument('-s', '--status', nargs='?', type=bool, const=True, default=False, help='run-time status')

    #@pytest.mark.asyncio
    #async def test_welcome(async_rf):
    #    request = await aync_rf.get('/welcome/')
    #    response = welcome(request)
    #    assert response.status_code == 200

    #def test_welcome(rf):
    #  request = rf.get('/welcome/')
    #  response = welcome(request)
    #  assert response.status_code == 200

    def get_gunicorn1_process(self):

      for process in psutil.process_iter():
        name = process.name()
        if name == 'gunicorn':
          return process

      return None

    def get_celery1_process(self):

      for process in psutil.process_iter():
        name = process.name()
        if name == 'celery':
          return process

      return None

    def get_pids_all(self, only_gunicorn=False):

      ret=[]

      for process in psutil.process_iter():
        name = process.name()
        if name == 'gunicorn' or (not only_gunicorn and name == 'celery'):
          ret.append(process.pid)

      return ret

    def get_gunicorn_port(self):
      gunicorn_pids = self.get_pids_all(only_gunicorn=True)
      #self.stderr.write("gunicorn_pids="+str(gunicorn_pids))
      gunicorn_pids_dict = {pid: True for i,pid in enumerate(gunicorn_pids)}
      #self.stderr.write("gunicorn_pids_dict="+str(gunicorn_pids_dict))

      isockets = psutil.net_connections(kind='inet')
      for isock in isockets:
          #self.stderr.write(str(isock))
          #self.stderr.write(str(isock.pid))
          if (isock.pid in gunicorn_pids_dict):
            #self.stderr.write("found sock "+str(isock))
            #self.stderr.write("found sock port="+str(isock.laddr.port))
            return isock.laddr.port

      return None

    def get_logfiles(self):

      ret=[]

      for process in psutil.process_iter():
        #print (process)
        name = process.name()
        if name == 'gunicorn' or name == 'celery':
          #process.kill(signal=0)

          ofiles = process.open_files()
          #self.stderr.write(str(ofiles))
          for ofile in ofiles:
            #self.stderr.write(str(ofile))
            ret.append({ 'file': ofile, 'filename': ofile.path, 'pid': process.pid })

      return ret

    def handle(self, *args, **options):

      pids_all_opt = options["pids_all"]
      pid_gunicorn_opt1 = options["pid_gunicorn1"]
      pid_celery_opt1 = options["pid_celery1"]
      pids_gunicorn_opt = options["pids_gunicorn"]
      pids_celery_opt = options["pids_celery"]
      pids_opt = options["pids"]
      port_opt = options["port"]
      logfiles_opt = options["logfiles"]
      logfiles_opt1 = options["logfiles1"]

      status_opt = options["status"]

      #

      if status_opt:
        fail=0
        errors_str=""

        p1 = self.get_gunicorn1_process()
        gunicorn_found=False
        if p1 == None:
          fail=1
          errmsg="gunicorn NOT running?"
          self.stdout.write(errmsg)
          errors_str = errors_str+" "+errmsg
        else:
          gunicorn_found=True
          self.stdout.write("gunicorn main pid: "+str(p1.pid))

        p1 = self.get_celery1_process()
        if p1 == None:
          fail=1
          errmsg="celery NOT running?"
          self.stdout.write(errmsg)
          errors_str = errors_str+" "+errmsg
        else:
          self.stdout.write("celery main pid: "+str(p1.pid))

        if gunicorn_found:
          gunicorn_port = self.get_gunicorn_port()
          if gunicorn_port == None:
            fail=1
            errmsg="gunicorn_port not listening?"
            self.stdout.write(errmsg)
            errors_str = errors_str+" "+errmsg
          else:
            self.stdout.write("gunicorn_port: "+str(gunicorn_port))

        if fail:      
          raise CommandError(errors_str)

      if pids_all_opt:
        pids_all = self.get_pids_all()
        for p in pids_all:
          self.stdout.write(str(p))
      elif pid_gunicorn_opt1:
        p1 = self.get_gunicorn1_process()
        if p1 != None:
            self.stdout.write(str(p1.pid))
      elif pid_celery_opt1:
        p1 = self.get_celery1_process()
        if p1 != None:
            self.stdout.write(str(p1.pid))
      elif pids_opt:
        p1 = self.get_gunicorn1_process()
        if p1 != None:
          self.stdout.write(str(p1.pid))
        p1 = self.get_celery1_process()
        if p1 != None:
          self.stdout.write(str(p1.pid))
      elif pids_gunicorn_opt:
        pids_all = self.get_pids_all(only_gunicorn=True)
        for p in pids_all:
          self.stdout.write(str(p))
      elif pids_celery_opt:
        pids_all = self.get_pids_all(only_gunicorn=False)
        for p in pids_all:
          self.stdout.write(str(p))

      if port_opt:
        gunicorn_port = self.get_gunicorn_port()
        if gunicorn_port != None:
          self.stdout.write(str(gunicorn_port))

      if logfiles_opt1:
        logfiles = self.get_logfiles()
        for l in logfiles:
          self.stdout.write(str(l["pid"])+" "+str(l["filename"]))
      elif logfiles_opt:
        logfiles = self.get_logfiles()
        seen={}
        for l in logfiles:
          filename = str(l["filename"])
          if not filename in seen:
            seen[filename]=True
            self.stdout.write(filename)

      status=""
      return status


