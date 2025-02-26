<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Xworkz</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <style>

    body {
             background-image: url('https://img.freepik.com/free-photo/view-3d-book-with-graduation-cap_23-2151103704.jpg?semt=ais_hybrid');
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            min-height: 100vh;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;

     }

     h1{
             color: white;
          }
        </style>

</head>
<body class="bg-light">
    <div class="container mt-5">
        <h1 class="text-center mb-4">SCHOLARSHIP PAGE</h1>
        <form action="scholar" method="post">
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
                <label for="college" class="form-label">College</label>
                <input name="college" type="text" class="form-control" id="college" placeholder="Enter college name" required>
            </div>
            <div class="mb-3">
                <label for="district" class="form-label">District</label>
                <input type="text" name="district" class="form-control" id="district" placeholder="Enter District name" required>
            </div>
            <div class="text-center">
                <input type="submit" class="btn btn-primary" value="SUBMIT">
            </div>
        </form>
    </div>
</body>
</html>
