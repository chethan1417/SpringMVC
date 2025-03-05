<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Success</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background: url('https://png.pngtree.com/thumb_back/fw800/background/20230527/pngtree-gym-filled-with-machines-and-equipment-image_2687616.jpg') no-repeat center center fixed;
            background-size: cover;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            flex-direction: column;
            color: white;
        }

        .navbar {
            position: fixed;
            top: 0;
            width: 100%;
            background: rgba(0, 0, 0, 0.5); /* Adjusted transparency */
            padding: 15px 30px;
            display: flex;
            align-items: center;
            justify-content: space-between;
            z-index: 10;
        }

        .navbar .logo img {
            height: 60px;
            transition: transform 0.3s ease;
        }

        .navbar .logo img:hover {
            transform: scale(1.1);
        }

        .navbar ul {
            list-style-type: none;
            padding: 0;
            margin: 0;
            display: flex;
        }

        .navbar ul li {
            margin-left: 20px;
        }

        .navbar ul li a {
            color: white;
            font-size: 18px;
            font-weight: 600;
            text-decoration: none;
            padding: 10px 20px;
            border-radius: 5px;
            transition: all 0.3s ease;
        }

        .navbar ul li a:hover {
            background-color: white;
            color: black;
        }

        .navbar ul li.active a {
            background-color: #007bff;
            color: white;
        }

        /* Centered Content */
        .content {
            text-align: center;
        }

        h1 {
            font-size: 50px;
            font-weight: bold;
            text-transform: uppercase;
            letter-spacing: 2px;
            text-shadow: 2px 2px 10px rgba(0, 0, 0, 0.8);
        }
    </style>
</head>
<body>

    <nav class="navbar">
        <a href="#" class="logo">
            <img src="https://www.pngall.com/wp-content/uploads/13/Dragon-Ball-PNG-Image-HD.png" alt="Gym Management System Logo">
        </a>
        <ul>
    <a class="nav-link text-white" href="http://localhost:8080/chethan_gym/userHome?email=${registrationEntity.email}">Home</a>
        </ul>
    </nav>

    <div class="content">
<h1> ${not empty registrationEntity.email ? "Successful" : "Successful"} </h1>
    </div>

</body>
</html>
