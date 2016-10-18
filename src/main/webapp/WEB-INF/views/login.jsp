<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="loginControllerApp">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Aplicação de teste Angular</title>
		
		<script type="text/javascript" src="../resources/javascript/angular.min.js"></script>
		<script type="text/javascript" src="../resources/javascript/loginController.js"></script>
	</head>
	<body>
		<form ng-controller="LoginController">
			<h1>Spring MVC e AngularJS</h1>
			
			<h2>LOGIN</h2>
		
			<label for="input-login">Login:</label>
			<input type="text" id="input-login" style="width: 120px;" ng-model="login">
			
			<br />
			
			<label for="input-login">Login:</label>
			<input type="text" id="input-login" style="width: 120px;" ng-model="login">
		
			<br />
			
			<input type="button" value="Logar" ng-click="login()">
			
			<br />
			
			<h3>*Efetue o login antes de acessar a aplicação.</h3>
			
		</form>		
	</body>
</html>