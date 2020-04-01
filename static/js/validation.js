function validateForm() {
    var isError = false;
    var password = document.getElementById("id_password").value;
    document.getElementById("id_password").classList.remove("input-error");
    var netconf_device = document.getElementById("id_netconf_device").value;
    document.getElementById("id_netconf_device").classList.remove("input-error");
    var netconf_port = document.getElementById("id_netconf_port").value;
    document.getElementById("id_netconf_port").classList.remove("input-error");
    var netconf_user = document.getElementById("id_netconf_user").value;
    document.getElementById("id_netconf_user").classList.remove("input-error");
    var netconf_pass = document.getElementById("id_netconf_pass").value;
    document.getElementById("id_netconf_pass").classList.remove("input-error");
    var test_peer_addr = document.getElementById("id_test_peer_addr").value;
    document.getElementById("id_test_peer_addr").classList.remove("input-error");
    var regnetconf_device = /^[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}$/;
    var regnetconf_port = /^()([1-9]|[1-5]?[0-9]{2,4}|6[1-4][0-9]{3}|65[1-4][0-9]{2}|655[1-2][0-9]|6553[1-5])$/;
    var refnetconf_user = /[<>,\/\\]/;
    var regtest_peer_addr = /^[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}\/[0-9]{1,3}$/;

    if (password == "") {
        isError = true;
        document.getElementById("id_password").classList.add("input-error");

    }
    if (netconf_device == "" || !regnetconf_device.test(netconf_device)) {
        isError = true;
        document.getElementById("id_netconf_device").classList.add("input-error");

    }
    if (netconf_port == "" || !regnetconf_port.test(netconf_port)) {
        isError = true;
        document.getElementById("id_netconf_port").classList.add("input-error");

    }
    if (netconf_user == "" || refnetconf_user.test(netconf_user)) {
        isError = true;
        document.getElementById("id_netconf_user").classList.add("input-error");

    }
    if (netconf_pass == "") {
        isError = true;
        document.getElementById("id_netconf_pass").classList.add("input-error");

    }
    if (test_peer_addr == "" || !regtest_peer_addr.test(test_peer_addr)) {
        isError = true;
        document.getElementById("id_test_peer_addr").classList.add("input-error");   
    }
    if (isError == true) {
        alert("Fields must be filled out!");
        return false;
    }

}