<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Trainers</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <style>
 body {
            background: url('https://wallpaperaccess.com/full/4615469.jpg') no-repeat center center fixed;
            background-size: cover;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            padding-top: 0px;
            margin-top: 0px;
        }

        .form-container {
            background-color: rgba(255, 255, 255, 0.9);
            border-radius: 25px;
            padding: 30px;
            box-shadow: black;
            width: 500px;
            margin-left: -500px;
        }

        label {
            color: black;
        }

        input.form-control:focus {
            border-color: #1e3a8a;
            box-shadow: 0px 5px 10px #1e3a8a;
        }

        .form-group {
            position: relative;
        }

        .form-group input {
            border-radius: 25px;
            height: 45px;
            font-size: 15px;
            border: 1px solid #ddd;
            padding-left: 40px;
        }

        .form-group input:focus {
            border-color: #1e3a8a;
        }

        .input-icon {
            position: absolute;
            left: 15px;
            top: 70%;
            transform: translateY(-50%);
            color: #1e3a8a;
        }

        .btn {
            border-radius: 25px;
            height: 45px;
            font-size: 20px;
            border: 1px solid #ddd;
        }

        .btn:focus {
            border-color: #1e3a8a;
            box-shadow: 0px 5px 10px #1e3a8a;
        }

        .error {
            color: red;
            text-align: center;
            margin-top: 10px;
            font-size: 14px;
        }

        select.form-control:focus {
            border-color: #1e3a8a;
            box-shadow: 0px 5px 10px #1e3a8a;
        }

        .journey-heading {
            position: absolute;
            right: 250px;
            top: 70%;
            transform: translateY(-50%);
            font-size: 3rem;
            font-family: 'Lora', serif;
            color: white;
            font-weight: bold;
            text-shadow: 2px 2px 5px rgba(0, 0, 0, 0.6);
        }

        .journey-heading .fitness-journey {
            display: block;
            animation: slideInUp 3s ease-in-out forwards;
        }

        @keyframes slideInUp {
            0% {
                opacity: 0;
                transform: translateY(50px);
            }
            100% {
                opacity: 1;
                transform: translateY(0);
            }
        }

        .navbar {
            position: fixed;
            top: 0;
            width: 100%;
            background: transparent;
            padding: 15px 0;
            z-index: 10;
        }

.fitness-image {
        width: 6cm;
        height: 6cm;
        position: relative;
        top: -13cm;
        right: -30cm;
        animation: fadeIn 5s ease-in-out infinite;
        opacity: 0;
    }

    @keyframes fadeIn {
        0% {
            opacity: 0;
        }
        50% {
            opacity: 1;
        }
        100% {
            opacity: 0;
        }
    }
        .navbar .logo img {
            height: 60px;
            animation: bounce 5s ease-out infinite;
            filter: hue-rotate(180deg);
        }

        @keyframes bounce {
            0% { transform: translateY(0); }
            25% { transform: translateY(-10px); }
            50% { transform: translateY(0); }
            75% { transform: translateY(-5px); }
            100% { transform: translateY(0); }
        }

        .navbar ul {
            list-style-type: none;
            padding: 0;
            margin: 0;
            display: flex;
            justify-content: flex-end;
        }

        .navbar ul li {
            margin-right: 40px;
        }

        .navbar ul li a {
            color: white;
            font-size: 18px;
            font-weight: 600;
            text-decoration: none;
            padding: 10px 15px;
            border-radius: 5px;
            transition: all 0.3s ease;
        }

        .navbar ul li a:hover {
            background-color: black;
            color: white;
        }

        .navbar ul li.active a {
            background-color: #007bff;
            color: white;
        }    </style>
</head>
<body>
    <nav class="navbar">
        <a href="#" class="logo"><img src="https://www.pngall.com/wp-content/uploads/13/Dragon-Ball-PNG-Image-HD.png" alt="Gym Logo"></a>
        <ul>
            <li><a href="Success.jsp">Home</a></li>
        </ul>
    </nav>

    <div class="form-container">
        <h2 class="text-center" style="color:darkblue; margin-bottom: 1.5rem;">Trainer Entry</h2>
        <form id="trainerForm" action="trainers" method="post">
            <div class="form-group">
                <label for="name">Trainer Name:</label>
                <i class="fas fa-user input-icon"></i>
   <input type="text" name="name" class="form-control" id="name" required onchange="onName()">
   <span id="nameError" class="error"></span>

            </div>
            <div class="form-group">
                <label for="area">Trainer Ph:</label>
                <i class="fas fa-phone-alt input-icon"></i>
                <input type="text" name="ph" class="form-control" id="ph" required onchange="onPhone()" >
                <span id="phoneError" class="error"></span>

            </div>
                        <h6>${error}</h6>
            <button type="submit" class="btn btn-primary btn-block" style="background-color:#1e3a8a;">Submit</button>
        </form>
    </div>

    <img src="https://www.pngall.com/wp-content/uploads/13/Dragon-Ball-PNG-Image-HD.png"
         alt="Fitness Image" class="fitness-image" style="width: 6cm; height: 6cm; position: relative; top: -3cm; right: -6cm;">


<script>
    function onName() {
        const name = document.getElementById("name").value.trim();
        const nameError = document.getElementById("nameError");
        const nameRegex = /^[A-Za-z\s]+$/;

        if (name.length < 3) {
            nameError.textContent = "Name must be at least 3 characters long.";
        } else if (!nameRegex.test(name)) {
            nameError.textContent = "Name must contain only English alphabets.";
        } else {
            nameError.textContent = "";
        }
    }

    function onPhone() {
        const phone = document.getElementById("ph").value.trim();
        const phoneError = document.getElementById("phoneError");
        const phoneRegex = /^(?:\+91[-\s]?)?[6789]\d{9}$/;

        if (!phoneRegex.test(phone)) {
            phoneError.textContent = "Enter a valid contact number.";
        } else {
            phoneError.textContent = ""; // Clear error if valid
        }
    }

    document.getElementById("trainerForm").addEventListener("submit", function (event) {
        onName();
        onPhone();

        if (document.getElementById("nameError").textContent !== "" ||
            document.getElementById("phoneError").textContent !== "") {
            event.preventDefault(); // Stop form submission if validation fails
        }
    });
</script>

</body>
</html>
