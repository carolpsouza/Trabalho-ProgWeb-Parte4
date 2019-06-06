<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Objetos.Cliente" %>
    
<%
	ArrayList<Cliente> clientes = (ArrayList<Cliente>)request.getAttribute("clientes");
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listar Clientes</title>
</head>
<body>

<p><a href="/Trabalho1/AdicionarCliente">Adicionar</a></p>

<table border="1">
	<thead>
		<tr>
			<th>Id</th>
			<th>Nome</th>
			<th>Email</th>
			<th colspan="2">Acoes</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="cliente" items="${clientes}">
			<tr>
				<td><c:out value="${cliente.getId()}" /></td>
				<td><c:out value="${cliente.getNome()}" /></td>
				<td><c:out value="${cliente.getEmail()}" /></td>
				<td><a href="/Trabalho1/EditarCliente?id=${cliente.getId()}">Editar</a></td>
				<td><a href="/Trabalho1/ApagarCliente?id=${cliente.getId()}">Apagar</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<p><a href="/Trabalho1/index.html">Voltar para menu</a></p>
</body>
</html>