<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>COMPOSE</h1>
<h4 align='center'>
<form action='composevalidation' method='Post'><br>

 
TO:<br>
<input type='text' name="To_id" placeholder="TO"  value="${mdto.getTo_id()}" ><br>
SUB:<br>
<input type='text' name="Subject" placeholder="Subject" value="${mdto.getSubject()}" ><br>
TEXT:<br>
<input type='text', name="Body" placeholder="Text" value="${mdto.getBody()}"><br>

 <input type='submit'  value='send'>
 <!--  style="height: 400px;width:400px;"  -->
</form>
</h4>

</body>
</html>