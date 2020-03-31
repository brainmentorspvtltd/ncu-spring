<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome Page Message is ${msg}</h1>
<form action="login" method="post">
<input type="text" name="userid" placeholder="Type userid here">
<input type="password" name="pwd" placeholder="Type password here">
<button>Login</button>
</form>
</body>
</html>