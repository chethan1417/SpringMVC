<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Xworkz</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <style>

    body {
             background-image: url('https://img.freepik.com/free-photo/portrait-professional-elegant-businessman_23-2150917142.jpg?t=st=1733721264~exp=1733724864~hmac=57d5c671ed451219372ab629ddf51924a40f853a701964ea0dfb5edb9dbcc426&w=740');
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
        </style>

</head>
<body class="bg-light">
    <div class="container mt-5">
        <h1 class="text-center mb-4">JOB APP PAGE</h1>
        <form action="job" method="post" >
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
                <label for="fatherName" class="form-label">Father Name</label>
                <input type="text" name="fatherName" class="form-control" id="fatherName" placeholder="Enter father Name" required>
            </div>
            <div class="mb-3">
                <label for="motherName" class="form-label">Mother Name</label>
                <input type="text" name="motherName" class="form-control" id="motherName" placeholder="Enter mother Name" required>
            </div>
            <div class="mb-3">
                <label for="yop" class="form-label">YOP</label>
                <input type="number" name="yop" class="form-control" id="yop" placeholder="Enter YOP" required>
            </div>
            <div class="mb-3">
                <label for="experience" class="form-label">Experience</label>
                <input type="number" name="experience" class="form-control" id="experience" placeholder="Enter experience" required>
            </div>
            <div class="mb-3">
                <label for="college" class="form-label">College</label>
                <input name="college" type="text" class="form-control" id="college" placeholder="Enter college name" required>
            </div>
            <div class="mb-3">
                <label for="district" class="form-label">District</label>
                <input type="text" name="district" class="form-control" id="district" placeholder="Enter District name" required>
            </div>
            <div class="mb-3">
                <label for="state" class="form-label">State</label>
                <input type="text" name="state" class="form-control" id="state" placeholder="Enter state name" required>
            </div>
            <div class="text-center">
                <input type="submit" class="btn btn-primary" value="SUBMIT">
            </div>
        </form>
    </div>
</body>
</html>
