<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import = "net.etfbl.dto.User" %>
 <%@page import = "net.etfbl.dto.UserAccount" %>
 <jsp:useBean id="userBean" class="net.etfbl.beans.UserBean" scope="application"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Korisnici</title>
</head>
<body>
<h1>Korisnici</h1>
<% for(User user : userBean.getAll()) { %>
<form method="post" action="?action=users">
Ime: <%= user.getName() %>
Prezime: <%= user.getSurname() %>
Mejl: <%= user.getMail() %>
<input type="submit" name="update" value="Update">
<input type="submit" name="delete" value="Delete">
<input type="hidden" name="id" value="<%=user.getId() %>">
<input type="hidden" name="name" value="<%=user.getName() %>">
<input type="hidden" name="surname" value="<%=user.getSurname() %>">
<input type="hidden" name="city" value="<%=user.getCity() %>">
<input type="hidden" name="mail" value="<%=user.getMail() %>">
<input type="hidden" name="username" value="<%=user.getUserAccount().getUsername() %>">
<input type="hidden" name="password" value="<%=user.getUserAccount().getPassword() %>">
<input type="hidden" name="isActivated" value="<%=user.getUserAccount().getIsActivated() %>">
</form>

<% } %>
<br /> <a href="?action=createUser">Kreiraj korisnika &gt;&gt;&gt;</a>
</body>
</html>