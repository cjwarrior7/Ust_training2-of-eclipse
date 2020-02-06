<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show</title>
</head>
<body>
<h1 align='center'>SHOW PRODUCT</h1>
<table border=2 align=center ><tr><th>Pname</th><th>Category</th><th>PCompany</th><th>Price</th><th>Quantity</th><th>MODIFY</th></tr>
<c:forEach var="ele" items="${list}" >
<tr><td>${ele.getPname()}</td><td>${ele.getCategory()}</td><td>${ele.getCompany()}</td><td>${ele.getPrice()}</td><td>${ele.getQuantity()}</td><td><a href="modifyproduct?id=${ele.getId()}">MODIFY</a></td></tr>
</c:forEach>
</table>

</body>
</html>