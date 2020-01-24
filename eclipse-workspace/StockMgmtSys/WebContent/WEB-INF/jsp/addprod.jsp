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
<form action="addproductinstock" method="post">
PName:<input type="text"name="PName" placeholder="PName">
Price:<input type="text"name="Price"placeholder="Price">
Quantity:<input type="text"name="Quantity"placeholder="Quantity">

<input type="submit"value="add">
</form>
</body>
</html>