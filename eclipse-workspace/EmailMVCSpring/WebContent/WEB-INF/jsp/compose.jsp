<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<input type='text' name="receiver" placeholder='to' align=middle><br>
SUB:<br>
<input type='text' name="subject" placeholder='sub' align=middle><br>
TEXT:<br>
<input type='text', name="body"  align=middle><br>
 <input type='submit'  value='send'>
 <!--  style="height: 400px;width:400px;"  -->
</form>
</h4>
</body>
</html>