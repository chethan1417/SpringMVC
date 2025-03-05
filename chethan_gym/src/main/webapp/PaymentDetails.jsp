<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Payment Details</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <style>
        body {
            background: url('https://wallpaperaccess.com/full/4615469.jpg') no-repeat center center fixed;
            background-size: cover;
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
            height: 100vh;
            margin: 0;
        }

        .navbar {
            position: fixed;
            top: 0;
            width: 100%;
            background: transparent;
            padding: 15px 0;
            z-index: 10;
        }

        .navbar .logo img {
            height: 60px;
            animation: bounce 5s ease-out infinite;
            filter: hue-rotate(180deg);
        }

        @keyframes bounce {
            0% { transform: translateY(0); }
            25% { transform: translateY(-10px); }
            50% { transform: translateY(0); }
            75% { transform: translateY(-5px); }
            100% { transform: translateY(0); }
        }

        .nav-link {
            color: #ffffff !important;
            font-weight: bold;
        }
        .nav-link:hover {
            color: blue !important;
        }

        .table-container {
            width: 90%;
            max-width: 1200px;
            background: #ffffff;
            border-radius: 10px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            padding: 20px;
            margin-top: calc(60px + 1cm);
            overflow-x: auto;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }
        .nav-item {
            margin-right: 40px;
        }

        h2 {
            color: #1e3a8a;
            font-weight: bold;
            text-align: center;
            margin-bottom: 20px;
        }
        .thead-dark th {
            background-color: #1e3a8a;
            color: #ffffff;
            text-align: center;
        }
        td, th {
            text-align: center;
            vertical-align: middle;
        }

        .btn-success {
            background-color: #1e3a8a;
            color: white;
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
            text-decoration: none;
            font-weight: bold;
            display: inline-block;
            transition: all 0.3s ease;
        }
        .btn-success:hover {
            background-color: black;
            color: white;
        }
    </style>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark">
        <a href="#" class="logo">
            <img src="https://www.pngall.com/wp-content/uploads/13/Dragon-Ball-PNG-Image-HD.png" alt="Gym Logo">
        </a>
        <ul class="navbar-nav ml-auto">
            <li class="nav-item"><a href="Success.jsp" class="nav-link">Home</a></li>
            <li class="nav-item"><a href="Enquiry.jsp" class="nav-link">Enquiry</a></li>
            <li class="nav-item"><a href="http://localhost:8080/chethan_gym/registration" class="nav-link">Registration</a></li>
            <li class="nav-item"><a href="http://localhost:8080/chethan_gym/update" class="nav-link">Update</a></li>
        </ul>
    </nav>

    <div class="table-container">
        <h2>Payment Details</h2>
        <table class="table table-bordered table-striped table-hover">
            <thead class="thead-dark">
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Paid Amount</th>
                    <th>Balance</th>
                    <th>Updated On</th>
                </tr>
            </thead>
            <tbody>
                <c:set var="counter" value="1" />
                <c:forEach items="${regUpdateEntityList}" var="regUpdateEntity">
                    <tr>
                        <td>${counter}</td>
                        <td>${regUpdateEntity.name}</td>
                        <td>${regUpdateEntity.paidAmount}</td>
                        <td>${regUpdateEntity.balance}</td>
                        <td>
                            <c:choose>
                                <c:when test="${not empty regUpdateEntity.updatedDateAndTime}">
                                    <fmt:parseDate value="${regUpdateEntity.updatedDateAndTime}" pattern="yyyy-MM-dd'T'HH:mm" var="formattedDate" />
                                    <fmt:formatDate value="${formattedDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </c:when>
                                <c:otherwise>
                                    N/A
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                    <c:set var="counter" value="${counter + 1}" />
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
