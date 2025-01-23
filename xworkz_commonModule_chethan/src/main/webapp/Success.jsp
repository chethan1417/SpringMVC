<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Signin Success</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
            font-family: apple-system, sans-serif;
        }

        .container {
            max-width: 600px;
            margin-top: 100px;
        }

        .welcome-message {
            font-size: 1.5rem;
            font-weight: bold;
        }

        .btn-container {
            display: flex;
            justify-content: center;
            margin-bottom: 20px;
        }
        .image{
                    display: flex;
                    justify-content: center;
        }
    </style>
</head>

<body>

    <div class="container">
        <div class="btn-container">
            <a href="http://localhost:8090/xworkz_commonModule_chethan/signin" class="btn btn-primary">Update</a>
        </div>
        <div class="card p-4">
            <div class="text-center mb-4">
                <h2 class="text-success">Signin Successfully</h2>
                <i class="bi bi-check-circle text-success" style="font-size: 3rem;"></i>
            </div>
        </div>
    </div>
  <div class="image">
<img src="download?filePath=${filePath}" alt="${filePath}" width="500" height="500">
    </div>

</body>

</html>
