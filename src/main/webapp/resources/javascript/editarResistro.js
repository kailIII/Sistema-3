var editarRegistroControllerApp = angular.module("editarRegistroControllerApp",[]);
 
editarRegistroControllerApp.controller("editarRegistroController",function($scope, $window, $http){
 
	$scope.codigo = null;
	$scope.nome   = null;
	$scope.login  = null;
	$scope.senha  = null;
	$scope.ativo  = null;
 
 
	$scope.alterarUsuario = function(){
 
		var usuarioModel =  new Object();
		usuarioModel.codigo = $scope.codigo;
		usuarioModel.nome   = $scope.nome,
		usuarioModel.login  = $scope.login,
		usuarioModel.senha  = $scope.senha		
		usuarioModel.ativo  = $scope.ativo;	
 
		/*EXECUTA O POST PARA ALTERAR O REGISTRO*/
		var response = $http.post("../alterar", usuarioModel);
 
		response.success(function(data, status, headers, config) {
 
		 if(data.codigo == 1){
 
			 $window.alert(data.mensagem);
 
			 window.location.href = "../consultarRegistros.html";
 
		 }
		 else{
 
			 $window.alert(data.mensagem);
 
		 }
	 });
 
	 response.error(function(data, status, headers, config) {

		 $window.alert(data);
 
	 });		
	};
});