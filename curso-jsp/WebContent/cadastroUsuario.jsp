<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Usuário</title>
</head>
<body>
	<h1>Cadastro de Usuário</h1>
	<form action="salvarUsuario" method="post">
		<table>
			<tr>
				<td>
					Codigo:
				</td>
				<td>
					<input type="text" name="id" id="id" value="${user.id}">
				</td>
			</tr>
			<tr>
				<td>
					Login:
				</td>
				<td>
					<input type="text" name="login" id="login" value="${user.login}">
				</td>
			</tr>
			
			<tr>
				<td>
					Senha:
				</td>
				<td>
					<input type="password" name="password" id="password" value="${user.senha}">
				</td>
			</tr>
			
			<tr>
				<td></td>
				<td>
					<input type="submit" value="cadastrar">
				</td>
			</tr>
		</table>
	</form>
	
	<table>
		<tr>
			<td>
				Login
			</td>
			<td>
				Senha
			</td>
		</tr>
		<c:forEach items="${usuarios }" var="user">
			<tr>
				<td>
					<c:out value="${user.id}"></c:out>
				</td>
				<td>
					<c:out value="${user.login}"></c:out>
				</td>
				<td>
					<c:out value="${user.senha}"></c:out>
				</td>
				<td>
					<a href="salvarUsuario?acao=deletarUsuario&user=${user.id}">Excluir</a>
				</td>
				<td>
					<a href="salvarUsuario?acao=editarUsuario&user=${user.id}">Editar</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>