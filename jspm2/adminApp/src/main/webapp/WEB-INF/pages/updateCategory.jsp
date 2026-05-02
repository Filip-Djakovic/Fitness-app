<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update</title>
</head>
<body>
<h1>Azuriranje kategorija</h1>
<form action="?action=updateCategory" method="POST">
<input type="text" name="id" value="${id}" readonly>
<input type="text" name="category" value="${category}">
<input type="text" name="attributes" value="${attributes}">
<input type="submit" value="Submit">
</form>
</body>
</html>