<%@page import="net.etfbl.Benas.MessageBean"%>
<%@page import="net.etfbl.Benas.UserAccountBean"%>
<%@page import="net.etfbl.Benas.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<jsp:useBean id="messageService" class="net.efbl.service.MessageService" scope="application"
></jsp:useBean>
<%
try{
	String id = request.getParameter("id");
	String text = request.getParameter("text");
	String userId = request.getParameter("userId");
	String userName = request.getParameter("userName");
	String userSurname = request.getParameter("userSurname");
	String userCity = request.getParameter("userCity");
	String userMail = request.getParameter("userMail");
	String userUserName = request.getParameter("userUserName");
	String userUserPassword = request.getParameter("userUserPassword");
	System.out.println("userID"+ userId);
	UserAccountBean userAcc = new UserAccountBean();
	userAcc.setUsername(userUserName);
	userAcc.setPassword(userUserPassword);
	userAcc.setIsActivated(2);
	
	UserBean user = new UserBean();
	user.setId(Integer.valueOf(userId));
	user.setName(userName);
	user.setSurname(userSurname);
	user.setCity(userCity);
	user.setMail(userMail);
	user.setUserAccount(userAcc);
	
	MessageBean mess = new MessageBean();
	mess.setId(Integer.valueOf(id));
	mess.setText(text);
	mess.setIsRead(1);
	mess.setUser(user);
	messageService.updateMessage(mess);
	
	response.sendRedirect("mail.jsp");
}
catch(Exception e){
	
}
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Message</title>
</head>
<body>
<h1>Message</h1>

<%
	for(MessageBean mb : messageService.getAll()){
%>
		<form action="message.jsp" method="POST">
		<br/> 
		Text: <%= mb.getText() %> 
		Name: <%= mb.getUser().getName() %> 
		
		
		
		<input type="hidden" name="id" value="<%= mb.getId().toString() %>">
        <input type="hidden" name="text" value="<%= mb.getText() %>">
        <input type="hidden" name="userId" value="<%= mb.getUser().getId().toString() %>">
        <input type="hidden" name="userName" value="<%= mb.getUser().getName() %>">
        <input type="hidden" name="userSurname" value="<%= mb.getUser().getSurname() %>">
        <input type="hidden" name="userCity" value="<%= mb.getUser().getCity() %>">
        <input type="hidden" name="userMail" value="<%= mb.getUser().getMail() %>">
        <input type="hidden" name="userUserName" value="<%= mb.getUser().getUserAccount().getUsername() %>">
		<input type="hidden" name="userUserPassword" value="<%= mb.getUser().getUserAccount().getPassword() %>">
		
		
		<input type="submit" value="Open" name="submit">
		</form>
<%
System.out.println("ID:"+ mb.getUser().getId());
	}
%>
</body>
</html>