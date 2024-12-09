<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Xworkz</title>
    <!-- Add Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

    <style>

    body {
             background-image: url('https://img.freepik.com/free-photo/3d-travel-icon-with-airplane_23-2151037375.jpg?semt=ais_hybrid');
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
<body>

<div class="container mt-5">
    <h1 class="mb-4">Passport Form</h1>
    <form action="passport" method="post">
        <!-- Passport Office -->
        <div class="mb-3">
            <label for="passportOffice" class="form-label">Passport Office</label>
            <select id="passportOffice" name="passportOffice" class="form-select" required>
                <option>-- Select --</option>
                <option>KARNATAKA</option>
                <option>AP</option>
                <option>TN</option>
                <option>UP</option>
                <option>MH</option>
            </select>
        </div>

        <!-- Given Name -->
        <div class="mb-3">
            <label for="givenName" class="form-label">Given Name</label>
            <input type="text" id="givenName" name="givenName" class="form-control" required>
        </div>

        <!-- Surname -->
        <div class="mb-3">
            <label for="surname" class="form-label">Surname</label>
            <input type="text" id="surname" name="surname" class="form-control" required>
        </div>

        <!-- Date of Birth -->
        <div class="mb-3">
            <label for="dob" class="form-label">Date of Birth</label>
            <input type="text" id="dob" name="dob" class="form-control" required>
        </div>

        <!-- Email -->
        <div class="mb-3">
            <label for="email" class="form-label">Email</label>
            <input type="email" id="email" name="email" class="form-control" required>
        </div>

        <!-- Do you want your Login ID to be the same as E-mail ID? -->
        <div class="mb-3">
            <label class="form-label">Do you want your Login ID to be the same as E-mail ID?</label><br>
            <div class="form-check form-check-inline">
                <input type="radio" id="loginYes" name="loginSameAsEmail" value="Yes" class="form-check-input" required>
                <label for="loginYes" class="form-check-label">Yes</label>
            </div>
            <div class="form-check form-check-inline">
                <input type="radio" id="loginNo" name="loginSameAsEmail" value="No" class="form-check-input">
                <label for="loginNo" class="form-check-label">No</label>
            </div>
        </div>

        <!-- Login ID -->
        <div class="mb-3">
            <label for="loginId" class="form-label">Login ID</label>
            <input type="text" id="loginId" name="loginId" class="form-control" required>
        </div>

        <!-- Password -->
        <div class="mb-3">
            <label for="password" class="form-label">Password</label>
            <input type="password" id="password" name="password" class="form-control" required>
        </div>

        <!-- Confirm Password -->
        <div class="mb-3">
            <label for="confirmPassword" class="form-label">Confirm Password</label>
            <input type="password" id="confirmPassword" name="confirmPassword" class="form-control" required>
        </div>

        <!-- Hint Question -->
        <div class="mb-3">
            <label for="hintQuestion" class="form-label">Hint Question</label>
            <select id="hintQuestion" name="hintQuestion" class="form-select" required>
                <option>-- Select --</option>
                <option>your pet name?</option>
                <option>your school name?</option>
                <option>your childhood best friend name?</option>
            </select>
        </div>

        <!-- Hint Answer -->
        <div class="mb-3">
            <label for="hintAnswer" class="form-label">Hint Answer</label>
            <input type="text" id="hintAnswer" name="hintAnswer" class="form-control" required>
        </div>

        <!-- Submit Button -->
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>

<!-- Bootstrap JS and dependencies -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-GLhlTQ8iRABzRiV1TtiEohPNXknb0T9kq5rcLE70b2wW9S9E1M6g3ERF9bB4x9v6F" crossorigin="anonymous"></script>

</body>
</html>
