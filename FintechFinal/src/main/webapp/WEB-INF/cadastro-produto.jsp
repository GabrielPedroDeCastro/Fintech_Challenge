
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Produto</title>
<%@ include file="header.jsp" %>
</head>
<body>
<%@ include file="menu.jsp" %>
<div class="container">
	<h1>Cadastro de Produto</h1>
	<form action="produto" method="post">
		<div class="form-group">
			<label for="id-nome">codigo</label>
			<input type="text" name="nome" id="codigo" class="form-control">
		</div>
		<div class="form-group">
			<label for="id-valor">nome</label>
			<input type="text" name="valor" id="nome" class="form-control">
		</div>
		<div class="form-group">
			<label for="id-quantidade">email</label>
			<input type="text" name="quantidade" id="email" class="form-control">
		</div>
		<div class="form-group">
			<label for="id-fabricacao">senha</label>
			<input type="text" name="fabricacao" id="senha" class="form-control">
		</div>
		<input type="submit" value="Salvar" class="btn btn-primary">
	</form>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>