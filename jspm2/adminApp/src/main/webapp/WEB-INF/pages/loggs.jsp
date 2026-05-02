<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:useBean id="categoryBean" class="net.etfbl.beans.CategoryBean" scope="application"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Loggs</title>
</head>
<body>
<h1>Loggs</h1>
<% for(String str : categoryBean.getAllStrings()) { %>
<form method="post" action="?action=loggs">
Username: <%= str.split("#")[0] %>
Date: <%= str.split("#")[2] %>
</br>
</form>

<% } %>
</body>
</html>