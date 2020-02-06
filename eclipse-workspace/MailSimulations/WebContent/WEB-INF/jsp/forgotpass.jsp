<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Forgot Password</h1>
<form action="forgotvalidation" method="post">
${msg}
Email:<input type="email"name="Email"placeholder="Email"><br><br>
Security Question:<input type="text" size=50   value="Which is your favourite movie ?"><br><br>
Answer:<input type="text"name="SAnswer"><br><br>
New Password:<input type="password"name="Password"placeholder="Password"><br>
<input type="submit"value="Update Password">
</form>


</body>
</html>