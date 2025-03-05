<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Login</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background: url('https://png.pngtree.com/thumb_back/fw800/background/20230527/pngtree-gym-filled-with-machines-and-equipment-image_2687616.jpg') no-repeat center center fixed;
            background-size: cover;
            display: flex;
            justify-content: flex-start;
            align-items: center;
            height: 100vh;
            padding-left: 200px;
        }

        .form-container {
            background-color: rgba(255, 255, 255, 0.7);
            border-radius: 25px;
            padding: 30px;
            box-shadow: black;
            width: 400px;
        }

        label {
            color: black;
        }

        input.form-control:focus {
            border-color: black;
            box-shadow: 0px 5px 10px black;
        }

        .form-group input {
            border-radius: 25px;
            height: 45px;
            font-size: 15px;
            border: 1px solid #ddd;
        }

        .form-group input:focus {
            border-color: black;
        }

        .btn {
            border-radius: 25px;
            height: 45px;
            font-size: 20px;
            border: 1px solid #ddd;
        }

        .btn:focus {
            border-color: black;
            box-shadow: 0px 5px 10px black;
        }

        .error {
            color: red;
            font-size: 0.9rem;
        }

        h6 {
            color: red;
        }

        .forgot-password {
            display: block;
            text-align: right;
            margin-top: 10px;
        }

        .forgot-password a {
            color: black;
            text-decoration: none;
            font-size: 0.9rem;
        }

        .forgot-password a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2 class="text-center" style="color:black; margin-bottom: 1.5rem;">User Login</h2>
        <form id="loginForm" action="userLogin" method="post">
            <div class="form-group">
                <label for="email">User Email:</label>
                <input type="text" name="email" class="form-control" id="email" required>
                <small id="emailError" class="error"></small>
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" name="password" class="form-control" id="password" required>
                <small id="passwordError" class="error"></small>
            </div>
            <h4>${noMatch}</h4>
            <button type="submit" class="btn btn-primary btn-block" style="background-color:black;">Login</button>
            <div class="forgot-password">
                <a href="UpdateUserPassword.jsp">Forgot Password?</a>
            </div>
            <h6>${logInerror}</h6>
        </form>
    </div>

    <script>
        document.getElementById("loginForm").addEventListener("submit", function(event) {
            event.preventDefault();

            const email = document.getElementById("email").value;
            const password = document.getElementById("password").value;

            const emailError = document.getElementById("emailError");
            const passwordError = document.getElementById("passwordError");

            emailError.textContent = "";
            passwordError.textContent = "";

            let valid = true;

            const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
            if (!emailRegex.test(email)) {
                emailError.textContent = "Please enter a valid email address.";
                valid = false;
            }

            if (password.length < 5) {
                passwordError.textContent = "Password must be at least 5 characters long.";
                valid = false;
            }

            if (valid) {
                alert("Form submitted successfully!");
                this.submit();
            }
        });
    </script>
</body>
</html>
