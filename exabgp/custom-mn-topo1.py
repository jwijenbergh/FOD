"""Custom topology example

Two directly connected switches plus a host for each switch:

   host --- switch --- switch --- host

Adding the 'topos' dict with a key/value pair to generate our newly defined
topology enables one to pass in '--topo=mytopo' from the command line.
"""

from mininet.topo import Topo
import sys

class MyTopo( Topo ):
    "Simple topology example."

    def build( self ):
        "Create custom topo."

        # Add hosts and switches
        leftHost = self.addHost( 'h1', ip='10.0.1.1/24')
        leftSwitch = self.addSwitch( 's3' )
        router1 = self.addHost( 'r1', ip='10.0.1.3/24')
        print("mmmmmm: "+str(type(router1)),file=sys.stderr)
        print("mmmmmm: "+str(router1),file=sys.stderr)
        #router1.cmd('ifconfig r1-eth1 10.0.2.3/24')
        rightSwitch = self.addSwitch( 's4' )
        rightHost = self.addHost( 'h2', ip='10.0.2.2/24')

        # Add links
        self.addLink( leftHost, leftSwitch )
        #self.addLink( leftSwitch, rightSwitch )
        self.addLink( leftSwitch, router1 )
        self.addLink( router1, rightSwitch, params1={ 'ip' : '10.0.2.3/24' } )
        self.addLink( rightSwitch, rightHost )


topos = { 'mytopo': ( lambda: MyTopo() ) }

