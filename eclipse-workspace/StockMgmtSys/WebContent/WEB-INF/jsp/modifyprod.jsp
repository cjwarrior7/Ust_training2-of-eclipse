<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 align='center'>MODIFY PRODUCT </h1>

<form action="modifyproductofdb" method="post">
<input type="hidden"name="id" value="${plist.getId()}">
PName:<input type="text"name="Pname" value="${plist.getPname()}">
Category:<input type="text"name="Category" value="${plist.getCategory()}">
PCompany:<input type="text"name="Company" value="${plist.getCompany()}">
Price:   <input type="text"name="price"   value="${plist.getPrice()}">
Quantity:<input type="text"name="Quantity" value="${plist.getQuantity()}">
<input type="submit"value="MODIFY">


</body>
</html>