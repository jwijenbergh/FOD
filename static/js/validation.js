function validateForm() {
    var isError = false;
    var password = document.getElementById("id_password").value;
    var netconf_device = document.getElementById("id_netconf_device").value;
    var netconf_port = document.getElementById("id_netconf_port").value;
    var netconf_user = document.getElementById("id_netconf_user").value;
    var netconf_pass = document.getElementById("id_netconf_pass").value;
    var test_peer_addr = document.getElementById("id_test_peer_addr").value;

    if (password == "") {
        isError = true;
        document.getElementById("id_password").classList.add("input-error");

    }
    if (netconf_device == "") {
        isError = true;
        document.getElementById("id_netconf_device").classList.add("input-error");

    }
    if (netconf_port == "") {
        isError = true;
        document.getElementById("id_netconf_port").classList.add("input-error");

    }
    if (netconf_user == "") {
        isError = true;
        document.getElementById("id_netconf_user").classList.add("input-error");

    }
    if (netconf_pass == "") {
        isError = true;
        document.getElementById("id_netconf_pass").classList.add("input-error");

    }
    if (test_peer_addr == "") {
        isError = true;
        document.getElementById("id_test_peer_addr").classList.add("input-error");   
    }
    if (isError == true) {
        alert("Fields must be filled out!");
        return false;
    }

}