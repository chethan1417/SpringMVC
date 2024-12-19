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
            font-family: apple-system, sans-serif;
        }
        .signin-container {
            background-image: url('https://img.freepik.com/free-photo/paper-that-has-word-book-it_1340-35690.jpg?t=st=1734176634~exp=1734180234~hmac=d42ea6121a46623173fb6c1da59c2850ce007d0c16309b8c59ff2a8452892142&w=740');
            max-width: 400px;
            margin: 50px auto;
            padding: 35px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
        }
        h2 {
            text-align: center;
            margin-bottom: 30px;
            color: black;
            font-size: 40px;

        }
        .error {
            color: red;
            margin-top: 10px;
            text-align: center;
        }
        .success {
            color: black;
            margin-top: 10px;
            text-align: center;
            font-size: 19px;
        }
    </style>
</head>
<body>
    <div class="signin-container">
        <h2>Course Signin</h2>


        <form method="post" action="signin">
            <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <input type="text" name="email" id="email" class="form-control" required />
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Password</label>
                <input type="password" name="password" id="password" class="form-control" required />
            </div>
            <button type="submit" class="btn btn-success w-100">Signin</button>
        </form>
    </div>

</body>
</html>
