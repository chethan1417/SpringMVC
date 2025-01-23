<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Signup</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background-color: #1f242d;
            font-family: Arial, sans-serif;
        }
        .signup-container {
            background-image: url('https://tse3.mm.bing.net/th?id=OIP.OqiL0S-SN6rb_FUGp8YRLgHaFP&pid=Api&P=0&h=180');
            max-width: 500px;
            margin: 50px auto;
            padding: 40px;
            background-color: #1f242d;
            border-radius: 12px;
            box-shadow: 0 5px 30px white;
        }
        h2 {
            text-align: center;
            margin-bottom: 30px;
            color: #fff;
            font-size: 25px;
        }
        .form-control {
            margin-bottom: 15px;
        }
        .form-label {
            color: white;
        }
        .error {
            color: red;
            text-align: center;
            margin-top: 10px;
        }
        .btn {
            color: white;
            display: flex;
            justify-content: center;
        }
        .signup-container h4 {
            color: red;
        }
        .error {
            color: red;
            font-size: 14px;
            margin-top: 5px;
        }
        .header-buttons a {
            margin-left: 10px;
            text-decoration: none;
        }
    </style>
</head>
<body>

<header class="bg-dark py-3">
    <div class="container d-flex justify-content-between align-items-center">
        <div>
            <img src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png" alt="Xworkz Logo" height="50">
        </div>
        <div class="header-buttons d-flex">
            <a href="index.jsp" class="btn btn-outline-light btn-sm me-2">Home</a>
            <a href="Signin.jsp" class="btn btn-outline-light btn-sm me-2">Signin</a>
        </div>
    </div>
</header>

<div class="signup-container">
    <h2>Course Signup</h2>
    <form method="post" action="signup" onsubmit="return validateSignupForm()">
        <div class="mb-3">
            <label for="name" class="form-label">Name</label>
            <input type="text" name="name" id="name" class="form-control" onchange="onUserName()" required />
            <span id="displayName" class="error"></span>
        </div>

        <div class="mb-3">
            <label for="email" class="form-label">Email</label>
            <input type="text" name="email" id="email" class="form-control" onchange="onEmail()" required />
            <span id="displayEmail" class="error"></span>
        </div>
        <div class="mb-3">
            <label for="ph" class="form-label">Phone</label>
            <input type="text" name="ph" id="ph" class="form-control" onchange="onPhone()" required />
            <span id="displayPhone" class="error"></span>
        </div>
        <div class="mb-3">
            <label for="alterEmail" class="form-label">Alter Email</label>
            <input type="text" name="alterEmail" id="alterEmail" class="form-control" onchange="onAlterEmail()" required />
            <span id="displayAlterEmail" class="error"></span>
        </div>
        <div class="mb-3">
            <label for="alterPh" class="form-label">Alter Phone</label>
            <input type="text" name="alterPh" id="alterPh" class="form-control" onchange="onAlterPhone()" required />
            <span id="displayAlterPhone" class="error"></span>
        </div>
        <div class="mb-3">
            <label for="location" class="form-label">Location</label>
             <select id="location" name="location">
              <option value = ""> select the option</option>
                <c:forEach items="${ListOfLocation}" var="location">
                    <option value="${location}">${location}</option>
                </c:forEach>

                      </select>
        </div>
        <div class="btn">
            <button type="submit">Signup</button>
        </div>
    </form>
</div>

<script>
function onUserName() {
    var name = document.getElementById('name').value;
    if (name !== "") {
        var xhttp = new XMLHttpRequest();
        xhttp.open("GET", "http://localhost:8090/xworkz_commonModule_chethan/name/" + name, true);
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
        xhttp.open("GET", "http://localhost:8090/xworkz_commonModule_chethan/email/" + email + "?alterEmail=" + alterEmail, true);
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
        xhttp.open("GET", "http://localhost:8090/xworkz_commonModule_chethan/phone/" + phone + "?alterPhone=" + alterPhone, true);
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
        xhttp.open("GET", "http://localhost:8090/xworkz_commonModule_chethan/alterEmail/" + alterEmail + "?email=" + email, true);
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
        xhttp.open("GET", "http://localhost:8090/xworkz_commonModule_chethan/alterPhone/" + alterPhone + "?phone=" + phone, true);
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

</script>

</body>
</html>
