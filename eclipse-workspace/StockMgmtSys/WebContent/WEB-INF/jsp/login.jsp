
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center" >Welcome to Login Page</h1>
${msg}
<h4 align="center">
<form action="loginvalidation" method="post">
Email:   <input type="email"name="Email"placeholder="Email"><br>
Password:<input type="password"name="Password"placeholder="Password"><br>
<input type="submit"value="LOGIN"><br>
<a href=link2>Register</a><br>
</h4>


</form>
</body>
</html>