<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Slots</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <style>
        body {
            background: url('https://wallpaperaccess.com/full/4615469.jpg') no-repeat center center fixed;
            background-size: cover;
            display: flex;
            flex-direction: column;
            align-items: center;
            min-height: 100vh;
            margin: 0;
        }

        .navbar {
            position: fixed;
            top: 0;
            width: 100%;
            background: rgba(0, 0, 0, 0);
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

        .navbar ul {
            list-style: none;
            display: flex;
            justify-content: flex-end;
            margin: 0;
            padding: 0;
        }

        .navbar ul li {
            margin: 0 20px;
        }

        .navbar ul li a {
            color: white;
            font-size: 18px;
            text-decoration: none;
            padding: 10px 15px;
            transition: background 0.3s, color 0.3s;
        }

        .navbar ul li a:hover,
        .navbar ul li.active a {
            background-color: #007bff;
            color: white;
            border-radius: 5px;
        }

        .table-container {
            margin-top: 150px;
            width: 90%;
            max-width: 800px;
            background: rgba(255, 255, 255, 0.9);
            padding: 20px;
            border-radius: 15px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }

        .table th, .table td {
            text-align: center;
        }

        .table thead th {
            background-color: #007bff;
            color: white;
        }

        .table-striped tbody tr:nth-of-type(odd) {
            background-color: #f0f8ff;
        }

        .table-striped tbody tr:nth-of-type(even) {
            background-color: #e6f7ff;
        }

        .table-hover tbody tr:hover {
            background-color: #d0ebff;
            cursor: pointer;
        }

         .remove-btn {
                background-color: #007bff;
                color: white;
                border: none;
                padding: 8px 16px;
                border-radius: 8px;
                cursor: pointer;
                transition: background 0.3s, transform 0.2s;
            }

            .remove-btn:hover {
                background-color: black;
                transform: scale(1.05);
            }
    </style>
</head>
<body>
    <nav class="navbar">
        <a href="#" class="logo"><img src="https://www.pngall.com/wp-content/uploads/13/Dragon-Ball-PNG-Image-HD.png" alt="Gym Logo"></a>
        <ul>
            <li><a href="Success.jsp">Home</a></li>
            <li><a href="AddSlots.jsp">Add Slots</a></li>
            <li><a href="Trainers.jsp">Add Trainers</a></li>
            <li><a href="http://localhost:8080/chethan_gym/allotment">Assign Slots</a></li>
                        <li><a href="SearchClient.jsp">Search Client</a></li>
        </ul>
    </nav>

    <div class="table-container">
        <table class="table table-bordered table-striped table-hover">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Trainer Name</th>
                    <th>Contact</th>
                    <th>Slots</th>
                    <th>Remove Slot</th>
                    <th>Delete Trainer</th>

                </tr>
            </thead>
            <tbody>
                <c:forEach items="${trainersEntities}" var="trainersEntities" varStatus="status">
                    <tr>
                        <td>${status.index + 1}</td>
                        <td>${trainersEntities.name}</td>
                        <td>${trainersEntities.ph}</td>
                        <td>${trainersEntities.slots}</td>
                        <td>
                            <form action="removeSlot" method="post" >
                                <input type="hidden" name="trainerName" value="${trainersEntities.name}" />
                                <button type="submit" class="remove-btn">Remove Slot</button>
                            </form>
                        </td>
                        <td>
                            <form action="deleteTrainer" method="post" >
                              <input type="hidden" name="trainerName" value="${trainersEntities.name}" />
                              <button type="submit" class="remove-btn">Delete Trainer</button>
                              </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

</body>
</html>
