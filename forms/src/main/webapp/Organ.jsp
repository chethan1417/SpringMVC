<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Xworkz</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <style>

    body {
             background-image: url('https://media.istockphoto.com/id/472829838/photo/reminder-of-the-importance-of-being-an-organ-donor.jpg?s=612x612&w=0&k=20&c=ECXLuUSYmOP9SAW4MEm8zCC0M35xI8WVVo3oc79KrA4=');
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            min-height: 100vh;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;

     }
        </style>

</head>
<body class="bg-light">
    <div class="container mt-5">
        <h1 class="text-center mb-4">DONOR PAGE</h1>
        <form action="organ" method="post">
            <div class="mb-3">
                <label for="name" class="form-label">Name</label>
                <input name="name" type="text" class="form-control" id="name" placeholder="Enter your name" required>
            </div>
            <div class="mb-3">
                <label for="age" class="form-label">Age</label>
                <input name="age" type="number" class="form-control" id="age" placeholder="Enter age" required>
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <input name="email" type="text" class="form-control" id="email" placeholder="Enter mail" required>
            </div>
            <div class="mb-3">
                <label for="hospital" class="form-label">Hospital Name</label>
                <input name="hospital" type="text" class="form-control" id="hospital" placeholder="Enter hosp name" required>
            </div>
            <div class="mb-3">
                <label for="bloodGroup" class="form-label">Blood Group</label>
                <input type="text" name="bloodGroup" class="form-control" id="bloodGroup" placeholder="Enter bloodGroup" required>
            </div>
            <div class="mb-3">
                <label for="gender" class="form-label">Gender</label>
                <input type="text" name="gender" class="form-control" id="gender" placeholder="Gender" required>
            </div>
            <div class="mb-3">
                <label for="weight" class="form-label">Weight</label>
                <input type="number" name="weight" class="form-control" id="weight" placeholder="Enter weight" required>
            </div>
            <div class="mb-3">
                <label for="address" class="form-label">Address</label>
                <input type="text" name="address" class="form-control" id="address" placeholder="Enter address" required>
            </div>
            <div class="mb-3">
                <label for="city" class="form-label">City</label>
                <input type="text" name="city" class="form-control" id="city" placeholder="Enter city name" required>
            </div>
            <div class="text-center">
                <input type="submit" class="btn btn-primary" value="SUBMIT">
            </div>
        </form>
    </div>
</body>
</html>
