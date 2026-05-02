<%@page import="net.etfbl.Benas.UserAccountBean"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<jsp:useBean id="userService" class="net.efbl.service.UserAccountService"
scope="application"></jsp:useBean>
<jsp:useBean id="user" class="net.etfbl.Benas.UserAccountBean" scope="session"></jsp:useBean>
<jsp:setProperty property="username" name="user" param="username"></jsp:setProperty>
<jsp:setProperty property="password" name="user" param="password"></jsp:setProperty>
<%
	if(request.getParameter("submit") != null){
		user.setIsActivated(0);
		UserAccountBean logUser = userService.logInUser(user);
		if(logUser != null){
			System.out.println("Ulogovan je");
			response.sendRedirect("message.jsp");
		}
		else
		{
			System.out.println("neispravni podaci");
		}
	}
	else{
		System.out.println("Neka greska");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Login page</title>
</head>
<body>
<h1>Welcome to login page</h1>

<form method="POST" action="login.jsp">
	Korisnicko ime <br/> <input type="text" name="username" id="username">
	<br/>
	<input type="password" name="password" id="password">
	<br/>
	<input type="submit" value="Prijava" name="submit">
</form>
</body>
</html>