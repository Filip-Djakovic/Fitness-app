<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Kreiranje</title>
</head>
<body>
<form method="post" action="?action=createProgramm">
Naziv: <input type="text" name="name" id="name"></br>
Atribut: <input type="text" name="attributes" id="attributes"></br>
<input type="submit" name="create" value="Create">
</form>
</body>
</html>