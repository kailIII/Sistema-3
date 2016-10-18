<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="cadastrarControllerApp">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Cadastrar Novo Login</title>
		<style type="text/css">
			label {
				display: inline-block;
				width: 90px;
			}
		</style>
		
		<script type="text/javascript" src="../resources/javascript/angular.min.js"></script>
		<script type="text/javascript" src="../resources/javascript/cadastrarController.js"></script>
		
	</head>
	<body>
		<form ng-controller="cadastrarController">
			
			<h1>Cadastrar Novo Usuário</h1>
			<br/>
			
			<label for="input-name">Nome:</label>
			<input type="text" id="input-nome" style="width: 220px;" ng-model="nome">
			
			<br />
			
			<label for="input-login">Login:</label>
			<input type="text" id="input-login" style="width: 120px;" ng-model="login">
			
			<br />
			
			<label for="input-senha">Senha:</label>
			<input type="text" id="input-senha" style="width: 120px;" ng-model="senha">
			
			<br />
			
			<label for="input-ativo">Ativo:</label>
			<input type="checkbox" id="input-ativo" style="width: 120px;" ng-model="ativo">
			
			<br />
			
			<p>
				<a href="../">Voltar</a>
				
				<input type="button" value="Salvar" ng-click="salvarUsuario()">
				
			</p>
			
		</form>
	</body>
</html>