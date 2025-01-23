<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        .tech-logos {
            text-align: center;
            padding: 20px;
        }
        .tech-logos img {
            width: 80px;
            margin: 10px;
        }
        .tech-logos .header {
            font-size: 24px;
            font-weight: bold;
        }
        .tech-logos .header span {
            color: #007bff;
        }

        h1 {
            color: orange;
        }

        h2 {
            margin-bottom: 0;
        }

        .header-container {
            text-align: center;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">
                <img src="https://www.x-workz.in/static/media/Logo.cf195593dc1b3f921369.png" alt="Xworkz Logo" height="40">
            </a>
        </div>
    </nav>

    <div class="container">
        <div class="header-container">
            <h2>Welcome To</h2>
            <h1>X-workz ODC</h1>
        </div>

        <div class="row justify-content-center my-4">
            <div class="col-auto text-center">
                <img src="https://www.x-workz.in/static/media/coding_img.bef297f81da57125500a.png"
                     alt="Coding Image" class="img-fluid" style="max-width: 300px; height: auto;">
            </div>
        </div>

        <div class="row justify-content-center">
            <div class="col-auto text-center">
                <a href="http://localhost:8090/xworkz_commonModule_chethan/signup" class="btn btn-primary btn-lg mb-2">Signup</a>
                <h6>Click Here To Sign Up</h6>
            </div>
            <div class="col-auto text-center">
                <a href="Signin.jsp" class="btn btn-secondary btn-lg mb-2">Signin</a>
                <h6>Click Here To Sign In</h6>
            </div>
        </div>
    </div>

    <div class="tech-logos">
        <div class="header">We <span>Teach</span></div>
        <img src="https://logos-download.com/wp-content/uploads/2016/10/Java_logo.png" alt="Java">
        <img src="https://seeklogo.com/images/S/spring-boot-logo-9D6125D4E7-seeklogo.com.png" alt="Spring">
        <img src="https://pngimg.com/uploads/mysql/mysql_PNG23.png" alt="MySQL">
        <img src="https://cdn.icon-icons.com/icons2/2621/PNG/512/brand_angularjs_icon_157345.png" alt="Angular">
        <img src="https://logodownload.org/wp-content/uploads/2022/04/javascript-logo-0.png" alt="JavaScript">
        <img src="https://logodownload.org/wp-content/uploads/2016/10/html5-logo.png" alt="HTML5">
        <img src="https://cdn.freebiesupply.com/logos/large/2x/css3-logo-png-transparent.png" alt="CSS3">
        <img src="https://cdn.freebiesupply.com/logos/thumbs/2x/git-logo.png" alt="Git">
        <img src="https://icon-icons.com/downloadimage.php?id=169034&root=2699/PNG/512/&file=hibernate_logo_icon_169034.png" alt="Hibernate">
    </div>

</body>
</html>
