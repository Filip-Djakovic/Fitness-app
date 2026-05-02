<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Azuriranje korisnika</title>
</head>
<body>
<h1>Azuriranje</h1>
<form action="?action=userUpdate" method="POST">
<input type="text" name="id" value="${id}" readonly> </br>
<input type="text" name="name" value="${name}"> </br>
<input type="text" name="surname" value="${surname}"> </br>
<input type="text" name="city" value="${city}"> </br>
<input type="text" name="mail" value="${mail}"> </br>
<input type="text" name="username" value="${username}" readonly> </br>
<input type="text" name="password" value="${password}"> </br>
<input type="text" name="isActivated" value="${isActivated}"> </br>
<input type="submit" value="Submit">
</form>
</body>
</html>