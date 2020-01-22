function validateForm() {
    var password = document.getElementsByName["password"].value;
    if (password == "") {
        alert("Password must be filled out!");
        return false;
    }
}