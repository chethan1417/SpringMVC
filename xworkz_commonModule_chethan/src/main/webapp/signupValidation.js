function onUserName() {
    var name = document.getElementById('name').value;
    if (name !== "") {
        var xhttp = new XMLHttpRequest();
        xhttp.open("GET", "http://localhost:8080/xworkz_commonModule_chethan/name/" + name, true);
        xhttp.send();
        xhttp.onload = function() {
            document.getElementById("displayName").innerHTML = this.responseText;
        }
    }
}

function onEmail() {
    var email = document.getElementById('email').value;
    var alterEmail = document.getElementById('alterEmail').value;

    if (email !== "") {
        var xhttp = new XMLHttpRequest();
        xhttp.open("GET", "http://localhost:8080/xworkz_commonModule_chethan/email/" + email + "?alterEmail=" + alterEmail, true);
        xhttp.send();
        xhttp.onload = function() {
            document.getElementById("displayEmail").innerHTML = this.responseText;
        }
    }
}

function onPhone() {
    var phone = document.getElementById('ph').value;
    var alterPhone = document.getElementById('alterPh').value;

    if (phone !== "") {
        var xhttp = new XMLHttpRequest();
        xhttp.open("GET", "http://localhost:8080/xworkz_commonModule_chethan/phone/" + phone + "?alterPhone=" + alterPhone, true);
        xhttp.send();
        xhttp.onload = function() {
            document.getElementById("displayPhone").innerHTML = this.responseText;
        }
    }
}

function onAlterEmail() {
    var alterEmail = document.getElementById('alterEmail').value;
    var email = document.getElementById('email').value;

    if (alterEmail !== "") {
        var xhttp = new XMLHttpRequest();
        xhttp.open("GET", "http://localhost:8080/xworkz_commonModule_chethan/alterEmail/" + alterEmail + "?email=" + email, true);
        xhttp.send();
        xhttp.onload = function() {
            document.getElementById("displayAlterEmail").innerHTML = this.responseText;
        }
    }
}

function onAlterPhone() {
    var alterPhone = document.getElementById('alterPh').value;
    var phone = document.getElementById('ph').value;

    if (alterPhone !== "") {
        var xhttp = new XMLHttpRequest();
        xhttp.open("GET", "http://localhost:8080/xworkz_commonModule_chethan/alterPhone/" + alterPhone + "?phone=" + phone, true);
        xhttp.send();
        xhttp.onload = function() {
            document.getElementById("displayAlterPhone").innerHTML = this.responseText;
        }
    }
}

function validateSignupForm() {
    var name = document.getElementById('name').value;
    var location = document.getElementById('location').value;
    var email = document.getElementById('email').value;
    var alterEmail = document.getElementById('alterEmail').value;
    var phone = document.getElementById('ph').value;
    var alterPhone = document.getElementById('alterPh').value;

    if (name.length < 3 || !/^[a-zA-Z\s]+$/.test(name)) {
        document.getElementById("displayName").innerHTML = "Name must be at least 3 characters long and contain only letters and spaces.";
        return false;
    }

    if (location.length < 3 || !/^[a-zA-Z\s]+$/.test(location)) {
        document.getElementById("displayLocation").innerHTML = "Location must be at least 3 characters long and contain only letters and spaces.";
        return false;
    }

    if (email === alterEmail) {
        document.getElementById("displayEmail").innerHTML = "Primary and alternate emails cannot be the same.";
        return false;
    }

    var emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailPattern.test(email)) {
        document.getElementById("displayEmail").innerHTML = "Invalid email format.";
        return false;
    }

    if (!emailPattern.test(alterEmail)) {
        document.getElementById("displayAlterEmail").innerHTML = "Invalid alternate email format.";
        return false;
    }

    if (phone === alterPhone) {
        document.getElementById("displayPhone").innerHTML = "Primary and alternate phone numbers cannot be the same.";
        return false;
    }

    var phonePattern = /^[0-9]{10}$/;
    if (!phonePattern.test(phone)) {
        document.getElementById("displayPhone").innerHTML = "Invalid phone number. Must be 10 digits.";
        return false;
    }

    if (!phonePattern.test(alterPhone)) {
        document.getElementById("displayAlterPhone").innerHTML = "Invalid alternate phone number. Must be 10 digits.";
        return false;
    }

    return true;
}
