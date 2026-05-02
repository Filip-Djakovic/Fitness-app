<%@page import="java.io.*" %>
<%@ page import="java.util.List" %>
<%@ page import="org.apache.commons.fileupload.FileItem" %>
<%@ page import="org.apache.commons.fileupload.disk.DiskFileItemFactory" %>
<%@ page import="org.apache.commons.fileupload.servlet.ServletFileUpload" %>
<%@ page import="net.etfbl.Benas.EmailBean" %>
<%@ page import="java.nio.file.Paths" %>
<jsp:useBean id="emailService" class="net.efbl.service.EmailSerivce" scope="application"
></jsp:useBean>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
String mail = null;

if (ServletFileUpload.isMultipartContent(request)) {
    try {
        DiskFileItemFactory factory = new DiskFileItemFactory();
        
        ServletFileUpload upload = new ServletFileUpload(factory);
        
        List<FileItem> items = upload.parseRequest(request);
        
        for (FileItem item : items) {
            if (item.isFormField()) {
                if (item.getFieldName().equals("mail")) {
                    mail = item.getString(); 
                    System.out.println("Mejl je"+ mail);
                }
            } else {
                String fileName = new File(item.getName()).getName();
                String currentDirectory = Paths.get("").toAbsolutePath().toString();
                System.out.println("Putanja do fajla"+ currentDirectory);
                String filePath = currentDirectory+"/uploads/"+fileName;
                File uploadedFile = new File(filePath);
                item.write(uploadedFile);
                filePath.replace("\\", "/");
                EmailBean email = new EmailBean();
                email.setMess(mail);
                email.setPath(filePath);
                emailService.sendMail(email);
                
            }
        }

        // Now you can use the 'mail' variable
        out.println("Mail parameter: " + mail);
        out.println("<br>File uploaded successfully.");

    } catch (Exception ex) {
        //out.println("File upload failed: " + ex.getMessage());
        EmailBean email = new EmailBean();
        email.setMess(mail);
        String path = ex.getMessage().split(": ")[1].replace("\\", "/");
        email.setPath(path.substring(1, path.length()-1));
        emailService.sendMail(email);
    }
} else {
    out.println("This form is not a multipart form.");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mail</title>
</head>
<body>
<h1>Mail</h1>
<form method="POST" action="mail.jsp" enctype="multipart/form-data">
    <label for="file">Choose an image:</label>
    <input type="text" name="mail" id="mail">
    <input type="file" name="file" id="file" accept="image/*">
    <input type="submit" value="Upload" name="submit">
</form>
</body>
</html>