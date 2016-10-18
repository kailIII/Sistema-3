var loginControllerApp = angular.module("loginControllerApp",[]);

function inicia($scope) {
	$scope.login = null;
	$scope.senha = null;
}

loginControllerApp.controller("loginController", function($scope, $window,$http){
	inicia($scope);
	
	$scope.logar = function(){
		
		var usuarioModel = new Object();
		usuarioModel.login = $scope.login,
		usuarioModel.senha = $scope.senha,
		usuarioModel.ativo = true;
		
		var response = $http.post("logar", usuarioModel);
		
		response.success(function(data, status, headers, config){
			
			if (data.codigo==1){
				$location.path('/principal');
			}	
			$window.alert(data.mensagem);
		});
		
		response.error(function(data, status, headers, config){
			
			$window.alert(data);
		});
	};
});