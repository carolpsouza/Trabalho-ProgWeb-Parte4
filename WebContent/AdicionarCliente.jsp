<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Barbearia</title>
</head>
<body>
<h1>Cadastro de Cliente</h1>

<form action="AdicionarCliente" method="post">
	<p>Informe seus dados: </p>
	Nome: <input type="text" name="nome"><br><br>
	Email: <input type="text" name="email"><br><br>
	<input type="submit" value="Salvar">
</form>

<p><a href="/Trabalho1/index.html">Voltar para menu</a></p>

</body>
</html>