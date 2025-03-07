<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Signup</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">


    <style>
        body {
            background-color: #f9f9f9;
            font-family: Arial, sans-serif;
        }
        .signup-container {
            max-width: 500px;
            margin: 50px auto;
            padding: 40px;
            background-color: #1f242d;
            border-radius: 12px;
            box-shadow: 0 5px 30px rgba(0, 0, 0, 0.1);
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
        .form-label{
            color:white;
        }
        .error {
            color: red;
            text-align: center;
            margin-top: 10px;
        }
        .success {
            color: green;
            text-align: center;
            margin-top: 10px;
        }
        .btn-custom {
            background-color: #007bff;
            color: white;
            width: 100%;
            padding: 12px;
        }
        .btn-custom:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="signup-container">
        <h2>Course Signup</h2>


        <form method="post" action="xworkz">
            <div class="mb-3">
                <label for="name" class="form-label">Name</label>
                <input type="text" name="name" id="name" class="form-control" required />
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <input type="text" name="email" id="email" class="form-control" required />
            </div>
            <div class="mb-3">
                <label for="age" class="form-label">Age</label>
                <input type="number" name="age" id="age" class="form-control" required />
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Password</label>
                <input type="password" name="password" id="password" class="form-control" required />
            </div>
            <div class="mb-3">
                <label for="cPassword" class="form-label">Confirm Password</label>
                <input type="password" name="cPassword" id="cPassword" class="form-control" required />
            </div>
            <div class="mb-3">
                <label for="ph" class="form-label">Phone</label>
                <input type="text" name="ph" id="ph" class="form-control" required />
            </div>
            <button type="submit" class="btn btn-success">Signup</button>
        </form>


        <c:if test="${not empty failure}">
            <div class="error">${failure}</div>
        </c:if>


        <c:if test="${not empty success}">
            <div class="success">${success}</div>
        </c:if>
    </div>

</body>
</html>
