<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CHANGE PASSWORD</title>
</head>
<body>
<form action="changepassword" method="post">
${msg}
Email:<input type="email"name="Email"placeholder="Email"><br>
Old Password:<input type="password"name="Password"placeholder="Password"><br>
New Password:<input type="password"name="nPassword"placeholder="Password"><br>
confirm Password:<input type="password"name="cpassword"placeholder="confirm Password"><br>
<input type="submit"value="CHANGE PASSWORD"><br>
</form>

</body>
</html>