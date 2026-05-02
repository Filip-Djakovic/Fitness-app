<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login page</title>
</head>
<body>
<h1>Login</h1>
<form method="POST" action="?action=login">
Korisnicko ime <input type="text" name="username" id="username"></br>
Lozinka <input type="password" name="password" id="password"></br>
<input type="submit" value="Login" name="submit">

</form>
</body>
</html>