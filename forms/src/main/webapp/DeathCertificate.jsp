<!DOCTYPE html>
<html lang="en">
<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <title>X-workz</title>
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <style>

    body {
             background-image: url('https://img.freepik.com/free-photo/close-up-weathered-wall-with-old-candle_23-2151840984.jpg?semt=ais_hybrid');
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
      <h1 class="text-center mb-4">DEATH CERTIFICATE FORM</h1>
      <form action="death" method="post" >
         <div class="mb-3">
            <label for="deceasedName" class="form-label">Deceased Name</label>
            <input type="text" class="form-control" id="deceasedName" name="deceasedName">
         </div>
         <div class="mb-3">
            <label for="deceasedAge" class="form-label">Deceased Age</label>
            <input type="text" class="form-control" id="deceasedAge" name="deceasedAge">
         </div>
         <div class="mb-3">
            <label for="deceasedAddress" class="form-label">Deceased Address</label>
            <input type="text" class="form-control" id="deceasedAddress" name="deceasedAddress">
         </div>
         <div class="mb-3">
            <label for="deceasedDob" class="form-label">Deceased DOB</label>
            <input type="text" class="form-control" id="deceasedDob" name="deceasedDob">
         </div>
         <div class="mb-3">
            <label for="deceasedLastDate" class="form-label">Deceased Last Date</label>
            <input type="text" class="form-control" id="deceasedLastDate" name="deceasedLastDate">
         </div>
         <div class="mb-3">
            <label for="deceasedCause" class="form-label">Cause of Death</label>
            <input type="text" class="form-control" id="deceasedCause" name="deceasedCause">
         </div>
         <div class="text-center">
            <input type="submit" class="btn btn-primary" value="SUBMIT">
         </div>
      </form>
   </div>
</body>
</html>
