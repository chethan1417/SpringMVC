<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Xworkz</title>
</head>
<body>
    <h1>Product Form</h1>
       <h2>${fmessage}</h2>

    <form action="product" method="post">
        <pre>
    Name <input type="text" name="name" value="${productDto.name}">
    Type <select name="type">
        <option>--Select--</option>
        <option>Household</option>
        <option>Electronics</option>
        <option>Dairy And Eggs</option>
        <option>Beverages</option>
        <option>Bakery</option>
    </select>
    Cost <input type="number" name="cost" value="${productDto.cost}">
    Manufacturer <select name="manufacturer">
        <option>--Select--</option>
        <option>Whirlpool</option>
        <option>Tata</option>
        <option>Amul</option>
        <option>Parle</option>
    </select>
    Manufacture date <input type="text" name="manufactureDate" value="${productDto.manufactureDate}">
    Warranty <input type="number" name="warranty" value="${productDto.warranty}">
    <input style="background-color: green; color: white;" type="submit" value="SUBMIT">
</pre>
</form>
</body>
</html>