<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Kreiranje korisnika</title>
</head>
<body>
<h1>Kreiranje novog korisnika</h1>
<form action="?action=createUser" method="post">
Ime: <input type="text" name="name" id="name"></br>
Prezime: <input type="text" name="surname" id="surname"></br>
Grad: <input type="text" name="city" id="city"></br>
Mejl: <input type="text" name="mail" id="mail"></br>
Korisnicko ime: <input type="text" name="username" id="username"></br>
Lozinka: <input type="password" name="password" id="password"></br>
<input type="submit" name="submit" value="Create">
</form>
</body>
</html>