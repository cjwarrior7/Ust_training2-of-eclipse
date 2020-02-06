 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Product</title>
${msg}
</head>
<body>
<h1 align='center'>WELCOME TO ADD CART</h1>

<table border=1 align=center ><tr><th>Pname</th><th>Category</th><th>PCompany</th><th>Price</th><th>Quantity</th><th>ADD CART</th></tr>
<form action="addcartdata?id=${dto.getId()}" method="post">
<tr><td>${dto.getPname()}</td><td>${dto.getCategory()}</td><td>${dto.getCompany()}</td><td>${dto.getPrice()}</td><td><input type="text" name="quantity" placeholder="quantity" value="1"></td><td><input type="submit" value="Add"></td></tr>
</form>

</body>
</html>