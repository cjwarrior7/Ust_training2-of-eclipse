<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body align="center">
<h1>WELCOME TO SHOW CART PAGE </h1>
<form action="billgen?email=${m.getPur_email()}">
<table align='center' border='2'><tr><th>Product Name</th> <th>Quantity</th> <th>Per_Price</th> <th>Total_Price</th><th>Gst</th><th>RemoveCart</th></tr><br>
<c:forEach var="m" items="${list}">
<tr> <td>${m.getPname()}</td> <td>${m.getQuant_pur()}</td> <td>${m.getPrice()}</td><td>${m.getTotal_money()}</td><td> ${m.getGst()}</td><td><a href="removecart?id=${ m.getId()}">Remove</a></td><tr>
</c:forEach>
</table>
<input type="submit" value="GenerateBill">
</form>
</body>
</html>