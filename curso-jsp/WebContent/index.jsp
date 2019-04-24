

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="LoginServlet">
		Login:
		<input type="text" id="login" name="login">
		<br>
		<br/>
		Senha:
		<input type="password" id="login" name="senha">
		<br>
		<br/>
		<input type="submit" value="enviar">
	</form>
</body>
</html>