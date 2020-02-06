<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">Welcome to Register</h1>
<h4 align="center">
<form action="registerationvalidation" method="post">
UserName:<input type="text"name="UserName" placeholder="UserName"><br>
Password:<input type="password"name="Password"placeholder="Password"><br>
Email:   <input type="email"name="Email"placeholder="Email"><br>
Security Question:<input type="text" size=50 value="Which is your favourite movie ?"><br>
Answer:<input type="text"name="SAnswer"><br>
<input type="submit"value="Register"> |
<a href=link1>LOGIN</a><br>
</form>
</h4>
</body>
</html>