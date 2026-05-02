<%@page import="net.etfbl.dto.Category" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="categoryBean" class="net.etfbl.beans.CategoryBean" scope="application"></jsp:useBean>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Categorys</title>
</head>
<body>
<h1>Kategorija</h1>
<form method="post" action="?action=categorys">
<%
for(Category category : categoryBean.getAll()) { %>
<form method="post" action="?action=categorys">
    Kategorija: <%= category.getName() %>  
    Atributi: <%= category.getAttributes() %> 
    <input type="submit" name="update" value="Update Button">
	<input type="submit" name="delete" value="Delete Button">
	<input type="hidden" name="id" value="<%=category.getId() %>">
	<input type="hidden" name="category" value="<%=category.getName() %>">
	<input type="hidden" name="attributes" value="<%=category.getAttributes() %>">
    </br>
</form>
<% } %>
<br /> <a href="?action=createProgramm">Kreiraj novi program &gt;&gt;&gt;</a>
<br /> <a href="?action=users">Korisnici program &gt;&gt;&gt;</a>
<br /> <a href="?action=loggs">Logovi &gt;&gt;&gt;</a>
</form>
</body>
</html>