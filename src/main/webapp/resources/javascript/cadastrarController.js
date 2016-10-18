var cadastrarControllerApp = angular.module("cadastrarControllerApp", []);

function inicia($scope) {
	$scope.nome = null;
	$scope.login = null;
	$scope.senha = null;
	$scope.ativo = null;
}

cadastrarControllerApp.controller("cadastrarController", function($scope, $window, $http){
	
	inicia($scope);
	
	$scope.salvarUsuario = function(){
		
		var usuarioModel = new Object();
		usuarioModel.nome = $scope.nome,
		usuarioModel.login = $scope.login,
		usuarioModel.senha = $scope.senha,
		usuarioModel.ativo = $scope.ativo;
		
		var response = $http.post("salvar", usuarioModel);
		
		response.success(function(data, status, headers, config){
			
			if (data.codigo==1){
				inicia($scope);
			}	
			$window.alert(data.mensagem);
		});
		
		response.error(function(data, status, headers, config){
			
			$window.alert(data);
		});
	};
});