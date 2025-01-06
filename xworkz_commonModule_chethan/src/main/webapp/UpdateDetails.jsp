<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Signin</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #1f242d;
            font-family: Arial, sans-serif;
        }

        .update-container {
            background-image: url('https://tse3.mm.bing.net/th?id=OIP.OqiL0S-SN6rb_FUGp8YRLgHaFP&pid=Api&P=0&h=180');
            max-width: 400px;
            margin: 50px auto;
            padding: 35px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 4px 20px white;
        }

        h2 {
            text-align: center;
            margin-bottom: 30px;
            color: white;
            font-size: 25px;
        }

        .mb-3 {
            color: white;
        }

        h4 {
            color: white;
        }

        .btn {
            color: white;
            display: flex;
            justify-content: center;
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
                <a href="Signup.jsp" class="btn btn-outline-light btn-sm">Signup</a>
                <a href="Signin.jsp" class="btn btn-outline-light btn-sm">Signin</a>
            </div>
        </div>
    </header>

    <div class="update-container">
        <h2>Update Details</h2>

        <c:if test="${not empty successmsg}">
                    <div class="message success" style="color:white; font-size:24px">${successmsg}</div>
                </c:if>
                <c:if test="${not empty errormsg}">
                    <div class="message error" style="color:red; font-size:24px">${errormsg}</div>
                </c:if>
        <form method="post" action="update">
            <div class="mb-3">
                <label for="name" class="form-label">Name</label>
                <input type="text" class="form-control" id="name" name="name" onchange="onUserName()" required value="${commonModuleEntity.name}">
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <input type="email" class="form-control" id="email" name="email" onchange="onEmail()" required value="${commonModuleEntity.email}">
            </div>
            <div class="mb-3">
                <label for="ph" class="form-label">Phone Number</label>
                <input type="tel" class="form-control" id="ph" name="ph" onchange="onPhone()" required value="${commonModuleEntity.ph}">
            </div>
            <div class="mb-3">
                <label for="alterEmail" class="form-label">Alternate Email</label>
                <input type="email" class="form-control" id="alterEmail" name="alterEmail" onchange="onAlterEmail()" value="${commonModuleEntity.alterEmail}">
            </div>
            <div class="mb-3">
                <label for="alterPh" class="form-label">Alternate Phone Number</label>
                <input type="tel" class="form-control" id="alterPh" name="alterPh" onchange="onAlterPhone()" value="${commonModuleEntity.alterPh}">
            </div>
            <div class="mb-3">
                <label for="location" class="form-label">Location</label>
                <input type="text" class="form-control" id="location" name="location" value="${commonModuleEntity.location}">
            </div>
            <div class="d-grid">
                <button type="submit" class="btn btn-primary">Update</button>
            </div>
        </form>
        </form>
            <form action="upload" method="post" enctype="multipart/form-data">
            <input type="file" name="picture" />
            <button  type="file">Upload Picture</button>
            </form>
    </div>

<script>
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
    }</script>


</body>

</html>
