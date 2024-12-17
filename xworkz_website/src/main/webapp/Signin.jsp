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
            background-image: url('https://wallpapercave.com/wp/wp9764009.jpg');
            max-width: 400px;
            margin: 50px auto;
            padding: 35px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 4px 20px yellow;
        }
        h2 {
            text-align: center;
            margin-bottom: 30px;
            color: black;
            font-size: 40px;
        }

        .mb-3{
        color:white;
        }

        h4{
        color:white;
        }

.btn{
color:yellow;
display:flex;
justify-content:center;
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
            <div class="btn">
            <button type="submit" class="btn">Signin</button>
            </div>
        </form>

         <h4>${error}</h4>

    </div>

</body>
</html>
