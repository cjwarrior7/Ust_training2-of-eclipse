<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Product</title>
${msg}
</head>
<body>
<h1 align='center'>WELCOME TO SEARCH RESULT</h1>

<table border=1 align=center ><tr><th>Pname</th><th>Category</th><th>PCompany</th><th>Price</th><th>Quantity</th><th>Order</th></tr>
<c:forEach var="ele" items="${list}" >
<tr><td>${ele.getPname()}</td><td>${ele.getCategory()}</td><td>${ele.getCompany()}</td><td>${ele.getPrice()}</td><td>${ele.getQuantity()}</td><td><a href="addtocart?id=${ele.getId()}">Order NOW</a></td></tr>
</c:forEach>

</body>
</html>