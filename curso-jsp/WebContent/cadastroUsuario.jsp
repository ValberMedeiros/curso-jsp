<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap2/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.02/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animate2/animate.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/select22/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/perfect-scrollbar2/perfect-scrollbar.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/util2.css">
	<link rel="stylesheet" type="text/css" href="css/main2.css">
<!--===============================================================================================-->
<title>Cadastro de Usuário</title>
</head>
<body>
	
	
	<div class="limiter">
		<div class="container-table100">
			<div class="wrap-table100">
				<div class="table100">
				<h1>Cadastro de Usuário</h1>
	<form action="salvarUsuario" method="post">
		
		<table>
			<tr>
				<td>
					Codigo:
				</td>
				<td>
					<input type="text" name="id" id="id" value="${user.id}" class="cor-diferente">
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
					Nome:
				</td>
				<td>
					<input type="text" name="nome" id="nome" value="${user.nome}" class="cor-diferente">
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
						<thead>
							<tr class="table100-head">
								<th class="column1">Código</th>
								<th class="column2">Usuário</th>
								<th class="column3">Nome</th>
								<th class="column5">Opção</th>
								<th class="column6">Opção</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${usuarios }" var="user">
							<tr>
								<td class="column1">
									<c:out value="${user.id}"></c:out>
								</td>
								<td class="column2">
									<c:out value="${user.login}"></c:out>
								</td>
								<td class="column3">
									<c:out value="${user.nome}"></c:out>
								</td>
								<td class="column5">
									<a href="salvarUsuario?acao=deletarUsuario&user=${user.id}">Excluir</a>
								</td>
								<td class="column6">
									<a href="salvarUsuario?acao=editarUsuario&user=${user.id}">Editar</a>
								</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<!--===============================================================================================-->	
	<script src="vendor/jquery2/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/bootstrap2/js/popper.js"></script>
	<script src="vendor/bootstrap2/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/select22/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="js/main2.js"></script>
</body>
</html>