<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to login</h1>
${msg}
<form action="loginvalidation" method="post">
Email:<input type="text"name="Email"placeholder="Email">
Password:<input type="password"name="Password"placeholder="Password">
<input type="submit"value="LOGIN">
</form>
</body>
</html>