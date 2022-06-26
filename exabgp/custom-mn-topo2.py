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
        h1Host = self.addHost('h1', ip='10.0.1.1/24', defaultRoute='via 10.0.1.254')
        h2Host = self.addHost('h2', ip='10.0.2.1/24', defaultRoute='via 10.0.2.254')
        h3Host = self.addHost('h3', ip='10.0.3.1/24', defaultRoute='via 10.0.3.254')

        router1 = self.addHost('r1', ip='10.0.1.254/24')
        router2 = self.addHost('r2', ip='10.0.2.254/24')
        router3 = self.addHost('r3', ip='10.0.3.254/24')

        self.addLink(h1Host, router1)
        self.addLink(h2Host, router2)
        self.addLink(h3Host, router3)

        s12Switch = self.addSwitch('s12')
        s23Switch = self.addSwitch('s23')
        s13Switch = self.addSwitch('s13')

        self.addLink('r1', 's12', params1={ 'ip':'10.1.12.1/24' })
        self.addLink('r2', 's12', params1={ 'ip':'10.1.12.2/24' })

        self.addLink('r1', 's13', params1={ 'ip':'10.1.13.1/24' })
        self.addLink('r3', 's13', params1={ 'ip':'10.1.13.3/24' })
  
        self.addLink('r2', 's23', params1={ 'ip':'10.1.23.2/24' })
        self.addLink('r3', 's23', params1={ 'ip':'10.1.23.3/24' })

        #print("mmmmmm: "+str(type(router1)),file=sys.stderr)
        #print("mmmmmm: "+str(router1),file=sys.stderr)
        #router1.cmd('ifconfig r1-eth1 10.0.2.3/24')

topos = { 'mytopo': ( lambda: MyTopo() ) }

