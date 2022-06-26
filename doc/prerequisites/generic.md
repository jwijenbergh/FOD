# Prerequistes

Operation of FoD requires a router which is 

* BGP FlowSpec-capable and 
* supports JUNOS-specific NETCONF YANG models to inject/update the FlowSpec rules :

   + for BGP FlowSpec rules with IPv4 addresses: flow.route entries in configuration.routing-options 
   (NETCONF filter ``<configuration><routing-options><flow/></routing-options></configuration>``)
   + for BGP FlowSpec rules with IPv6 addresses: rib.flow entries in configuration.routing-options 
   (NETCONF filter ``<configuration><routing-options><rib><name>inet6.0</name><flow/></rib></routing-options></configuration>``)
   + or combined NETCONF FILTER: ``<configuration><routing-options><rib><name>inet6.0</name><flow/></rib><flow/></routing-options></configuration>``
   + NETCONF/ssh account on the router with appropriate rights to perform NETCONF RPC operations ``get_config`` and ``edit_config`` on the subtree given by NETCONF FILTER

example result of a NETCONF ``get_config`` query on a router with one IPv4-based BGP FlowSpec rule and one IPv6-based one:

<?xml version="1.0" encoding="UTF-8"?><data xmlns="urn:ietf:params:xml:ns:netconf:base:1.0" xmlns:nc="urn:ietf:params:xml:ns:netconf:base:1.0">
    <configuration xmlns="http://xml.juniper.net/xnm/1.1/xnm">

      <routing-options>

        <flow>
          <route>
            <name>FoD_testrule1_529HMW</name>
            <then>
              <rate-limit>10000k</rate-limit>
            </then>
            <match>
              <protocol>tcp</protocol>
              <protocol>udp</protocol>
              <source-port>1-5</source-port>
              <source-port>10-11</source-port>
              <source-port>12</source-port>
              <destination>10.0.0.2/32</destination>
              <source>10.0.0.1/32</source>
            </match>
          </route>
        </flow>

        <rib>
          <name>inet6.0</name>
          <flow>
            <route>
              <name>FoD_testipv6_MPSKD8</name>
              <then>
                <discard/>
              </then>
              <match>
                <protocol>icmp</protocol>
                <destination>
                  <prefix>1242:ac11::/127</prefix>
                </destination>
                <source>
                  <prefix>242:ac11:1::/127</prefix>
                </source>
              </match>
            </route>
          </flow>
        </rib>

      </routing-options>
    </configuration>
  </data>


