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
<a href=inbox>inbox</a>|<a href=sent>sentbox</a>|<a href=fetchdelete>deleted items</a>|<a href=comp>compose</a>
<h1 align='center'>WELCOME TO DRAFT</h1>
<table border=2 align=center ><tr><th>Body</th><th>Receiver</th><th>Sender</th><th>Subject</th><th>Delete</th></tr>
<c:forEach var="ele" items="${list}" >
<tr><td><a href="fetchbody?id=${ele.getId()}">BODY</a></td><td>${ele.getTo_id()}</td><td>${ele.getForm_id()}</td><td>${ele.getSubject()}</td><td><a href="deletedraft?id=${ele.getId()}">DELETE</a></td></tr>
</c:forEach>
</table>

</body>
</html>