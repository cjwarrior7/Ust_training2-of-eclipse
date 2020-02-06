<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to add product</h1>
<form action="addproductindb" method="post">
PName:<input type="text"name="Pname" placeholder="Pname">
Category:<input type="text"name="Category" placeholder="Category">
PCompany:<input type="text"name="Company"placeholder="Company">
Price:   <input type="text"name="Price"placeholder="Price">
Quantity:<input type="text"name="Quantity"placeholder="Quantity">
<input type="submit"value="Add">
</form>
</body>
</html>