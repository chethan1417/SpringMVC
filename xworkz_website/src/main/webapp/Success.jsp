<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Success Page</title>
</head>
<body>
    <h1>Welcome, <a href="/user">${userName}</a></h1>

    <c:if test="${not empty userName}">
        <h2>User Details:</h2>
        <p>Name: ${userDetails.name}</p>
        <p>Email: ${userDetails.email}</p>
        <p>Age: ${userDetails.age}</p>
        <p>Phone: ${userDetails.ph}</p>
    </c:if>
</body>
</html>
