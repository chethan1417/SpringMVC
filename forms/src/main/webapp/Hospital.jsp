<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>X-workz</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<style>

    body {
             background-image: url('https://img.freepik.com/free-photo/modern-hospital-room-with-empty-bed-chair-generated-by-ai_188544-20204.jpg?semt=ais_hybrid');
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
             color: black;
          }
        </style>
</head>
<body class="bg-light">
    <div class="container mt-5">
        <h1 class="text-center mb-4">Hospital Form</h1>
        <form action="hospital" method="post">
            <div class="mb-3">
                <label for="name" class="form-label">Name</label>
                <input type="text" class="form-control" id="name" name="name">
            </div>
            <div class="mb-3">
                <label for="age" class="form-label">Age</label>
                <input type="number" class="form-control" id="age" name="age">
            </div>
            <div class="mb-3">
                <label for="contact" class="form-label">Contact</label>
                <input type="tel" class="form-control" id="contact" name="contact">
            </div>
            <div class="mb-3">
                <label for="gender" class="form-label">Gender</label>
                <input type="text" class="form-control" id="gender" name="gender">
            </div>
            <div class="mb-3">
                <label for="reason" class="form-label">Reason</label>
                <input type="text" class="form-control" id="reason" name="reason">
            </div>
            <div class="text-center">
                <input type="submit" class="btn btn-primary" value="SUBMIT">
            </div>
        </form>
    </div>
</body>
</html>
