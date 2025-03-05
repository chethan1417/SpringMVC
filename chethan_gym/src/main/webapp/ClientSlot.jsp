<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Allotment</title>
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
            }

              .btn {
                         border-radius: 25px;
                         height: 45px;
                         font-size: 18px;
                         background-color: #1e3a8a;
                         color: white;
                         border: none;
                     }

                     .btn:hover {
                         background-color: #143362;
                     }

                     .btn-search {
                         font-size: 12px;
                         padding: 5px 10px;
                         height: 30px;
                     }

                     .btn-gap {
                         margin-top: 10px;
                     }

                     @keyframes fadeInBounce {
                         0% {
                             opacity: 0;
                             transform: translateY(-20px);
                         }
                         50% {
                             opacity: 0.7;
                             transform: translateY(5px);
                         }
                         100% {
                             opacity: 1;
                             transform: translateY(0);
                         }
                     }

                     .animated-heading {
                         font-size: 1.8rem;
                         font-weight: bold;
                         color: red;
                         text-align: center;
                         text-shadow: 2px 2px 5px rgba(0, 0, 0, 0.3);
                         animation: fadeInBounce 1.5s ease-in-out;
                     }


             </style>
</head>
<body>

 <nav class="navbar">
        <a href="#" class="logo"><img src="https://www.pngall.com/wp-content/uploads/13/Dragon-Ball-PNG-Image-HD.png" alt="Gym Logo"></a>
        <ul>
            <li><a href="Success.jsp">Home</a></li>
        </ul>
    </nav>



    <div class="form-container">
        <h2 class="text-center" style="color:darkblue; margin-bottom: 1.5rem;">Allotment</h2>
<form id="allotmentForm" action="clientAllotment" method="post" onsubmit="return handleSubmit(event)">

<h4 class="animated-heading">Assign Another Trainer for ${clientNames[0].name}</h4>
            <div class="form-group">
                <label for="email">Search Email:</label>
                <div class="input-group">
                    <input type="text" name="email" class="form-control" id="email">
                    <div class="input-group-append">
                        <button type="button" class="btn btn-primary" onclick="searchEmail()">Search</button>
                    </div>
                </div>
                <span id="displayEmail" class="text-danger"></span>
            </div>

            <div class="form-group">
                <label for="clientName">Client Name:</label>
                <input type="text" name="clientName" class="form-control" id="clientName" required value="${registrationEntity.name}">
            </div>

            <div class="form-group">
                <label for="trainer">Assign Trainer:</label>
                <select name="trainer" class="form-control" id="trainer" required onchange="updateSlot()">
                    <option value="">--Select Trainer--</option>
                    <c:forEach var="trainer" items="${trainersEntities}">
                        <option value="${trainer.name}" data-slot="${trainer.slots}">${trainer.name}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="form-group">
                <label for="slot">Slot:</label>
                <input type="text" name="slot" class="form-control" id="slot" required readonly>
            </div>
            <h6>${error}</h6>
            <button type="submit" class="btn btn-primary btn-block">Submit</button>
        </form>


    </div>




<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>

    <script>
        function searchEmail() {
            var email = document.getElementById('email').value;
            if (email !== "") {
                var form = document.createElement('form');
                form.method = 'POST';
                form.action = 'clientsearch';

                var emailInput = document.createElement('input');
                emailInput.type = 'hidden';
                emailInput.name = 'email';
                emailInput.value = email;

                form.appendChild(emailInput);
                document.body.appendChild(form);
                form.submit();
            }
        }

        function updateSlot() {
            var trainerDropdown = document.getElementById("trainer");
            var selectedOption = trainerDropdown.options[trainerDropdown.selectedIndex];
            var slotInput = document.getElementById("slot");

            if (selectedOption.value !== "") {
                slotInput.value = selectedOption.getAttribute("data-slot");
            } else {
                slotInput.value = "";
            }
        }


    </script>



</body>
</html>
