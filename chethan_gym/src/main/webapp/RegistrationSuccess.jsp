<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Success - Gym Management</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    <style>
        /* Animated Gradient Background */
        body {
            background: linear-gradient(-45deg, #1a1a2e, #16213e, #0f3460, #533483);
            background-size: 400% 400%;
            animation: gradientBG 10s ease infinite;
            height: 100vh;
            color: white;
            overflow: hidden;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        @keyframes gradientBG {
            0% { background-position: 0% 50%; }
            50% { background-position: 100% 50%; }
            100% { background-position: 0% 50%; }
        }

        /* Glassmorphism Navbar */
        .navbar {
            position: fixed;
            top: 0;
            width: 100%;
            background: rgba(255, 255, 255, 0.1);
            backdrop-filter: blur(15px);
            padding: 12px 0;
            z-index: 100;
            box-shadow: 0px 4px 15px rgba(0, 0, 0, 0.3);
        }

        .navbar .logo img {
            height: 50px;
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

        .navbar-nav .nav-link {
            color: white !important;
            font-size: 18px;
            font-weight: 600;
            padding: 10px 15px;
            transition: all 0.4s ease-in-out;
            position: relative;
        }

        /* Glowing effect on hover */
        .navbar-nav .nav-link:hover {
            background: rgba(255, 255, 255, 0.2);
            border-radius: 8px;
            box-shadow: 0px 0px 10px rgba(255, 255, 255, 0.5);
        }

        /* Success Box with Entrance Animation */
        .success-container {
            text-align: center;
            animation: fadeIn 1.5s ease-in-out;
        }

        @keyframes fadeIn {
            0% { opacity: 0; transform: translateY(-30px); }
            100% { opacity: 1; transform: translateY(0); }
        }

        /* Glassmorphism Card */
        .success-box {
            background: rgba(255, 255, 255, 0.1);
            backdrop-filter: blur(15px);
            padding: 40px;
            border-radius: 15px;
            box-shadow: 0px 10px 30px rgba(255, 255, 255, 0.1);
            max-width: 450px;
            margin: auto;
            animation: scaleUp 1s ease-in-out;
        }

        @keyframes scaleUp {
            0% { transform: scale(0.9); opacity: 0; }
            100% { transform: scale(1); opacity: 1; }
        }

        .success-box h1 {
            font-size: 3rem;
            font-weight: bold;
            color: #ffffff;
            text-shadow: 0px 0px 20px rgba(255, 255, 255, 0.6);
        }

        .success-box p {
            font-size: 1.2rem;
            color: rgba(255, 255, 255, 0.8);
            margin-top: 10px;
        }

        /* Glowing Button with Animation */
        .btn-premium {
            background: linear-gradient(90deg, #ff416c, #ff4b2b);
            color: white;
            font-size: 18px;
            font-weight: bold;
            padding: 12px 24px;
            border: none;
            border-radius: 50px;
            transition: all 0.4s ease-in-out;
            text-decoration: none;
            display: inline-block;
            margin-top: 20px;
            box-shadow: 0px 0px 15px rgba(255, 75, 43, 0.6);
            position: relative;
            overflow: hidden;
        }

        .btn-premium:hover {
            transform: scale(1.05);
            background: linear-gradient(90deg, #ff4b2b, #ff416c);
            box-shadow: 0px 0px 25px rgba(255, 75, 43, 0.9);
        }

        .btn-premium::after {
            content: "";
            position: absolute;
            top: 50%;
            left: 50%;
            width: 300%;
            height: 300%;
            background: rgba(255, 255, 255, 0.2);
            transition: all 0.6s ease;
            transform: translate(-50%, -50%) scale(0);
            border-radius: 50%;
        }

        .btn-premium:hover::after {
            transform: translate(-50%, -50%) scale(1);
            opacity: 0;
        }
    </style>
</head>
<body>



    <!-- Centered Success Message -->
    <div class="success-container">
        <div class="success-box">
            <h1>Success!</h1>
            <p>Your operation was completed successfully.</p>
            <a href="Success.jsp" class="btn btn-premium">Go to Dashboard</a>
        </div>
    </div>

</body>
</html>
