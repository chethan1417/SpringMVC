<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Xworkz</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

    <style>

    body {
             background-image: url('https://img.freepik.com/free-photo/affectionate-indian-couple-celebrating-propose-day-together_23-2151111025.jpg?semt=ais_hybrid');
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            min-height: 100vh;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;

     }

     label{
             color: white;
          }

          h1{
                       color: white;

          }
        </style>

</head>
<body class="bg-light">
    <div class="container mt-5">
        <h1 class="text-center mb-4">MATRIMONY PAGE</h1>
        <form action="matrimony" method="post" >
            <div class="mb-3">
                <label for="name" class="form-label">Name</label>
                <input name="name" type="text" class="form-control" id="name" placeholder="Enter your name" required>
            </div>
            <div class="mb-3">
                <label for="age" class="form-label">Age</label>
                <input name="age" type="number" class="form-control" id="age" placeholder="Enter age" required>
            </div>
            <div class="mb-3">
                <label for="gender" class="form-label">Gender</label>
                <input type="text" name="gender" class="form-control" id="gender" placeholder="Gender" required>
            </div>
            <div class="mb-3">
                <label for="qualification" class="form-label">Qualification</label>
                <input type="text" name="qualification" class="form-control" id="qualification" placeholder="Enter qualification" required>
            </div>
            <div class="mb-3">
                <label for="caste" class="form-label">Caste</label>
                <input type="text" name="caste" class="form-control" id="caste" placeholder="Enter caste" required>
            </div>
            <div class="mb-3">
                <label for="religion" class="form-label">Religion</label>
                <input type="text" name="religion" class="form-control" id="religion" placeholder="Enter religion" required>
            </div>
            <div class="mb-3">
                <label for="address" class="form-label">Address</label>
                <input type="text" name="address" class="form-control" id="address" placeholder="Enter address" required>
            </div>
            <div class="mb-3">
                <label for="city" class="form-label">City</label>
                <input type="text" name="city" class="form-control" id="city" placeholder="Enter city name" required>
            </div>
            <div class="mb-3">
                <label for="state" class="form-label">State</label>
                <input type="text" name="state" class="form-control" id="state" placeholder="Enter state name" required>
            </div>
            <div class="mb-3">
                <label for="country" class="form-label">Country</label>
                <input type="text" name="country" class="form-control" id="country" placeholder="Enter country name" required>
            </div>
            <div class="text-center">
                <input type="submit" class="btn btn-primary" value="SUBMIT">
            </div>
        </form>
    </div>
</body>
</html>
