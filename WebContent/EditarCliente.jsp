<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="Objetos.Cliente" %>

<%
	Cliente cliente = (Cliente)request.getAttribute("cliente");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Cliente</title>
</head>
<body>

<h1>Editar Cliente</h1>

<form action="EditarCliente" method="post">
	<input type="hidden" name="id" value="${cliente.getId()}">

	<p>Informe seus dados: </p>
	Id: <input type="text" disabled="disabled" value="${cliente.getId()}"><br><br>
	Nome: <input type="text" name="nome" value="${cliente.getNome()}"><br><br>
	Email: <input type="text" name="email" value="${cliente.getEmail()}"><br><br>
	<input type="submit" value="Salvar">
</form>

<p><a href="/Trabalho1/ListarClientes">Listar Clientes</a></p>

</body>
</html>