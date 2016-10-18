var consultarRegistrosControllerApp = angular.module("consultarRegistrosControllerApp",[]);
 
consultarRegistrosControllerApp.controller("consultarRegistrosController",function($scope, $window, $http){
 
	 $scope.usuarios = new Array();
 
	 $scope.init = function(){
 
		 var response = $http.get("consultarTodos");
 
		 response.success(function(data, status, headers, config) {

			 $scope.usuarios = data;
 
		 });
 
		 response.error(function(data, status, headers, config) {

			 $window.alert(data);
 
		 });
	 }
 
	 $scope.excluirRegistro = function(codigo){
 
		 if($window.confirm("Deseja realmente excluir esse registro?")){
 
			 var response = $http.delete("excluirRegistro/" + codigo);
 
			 response.success(function(data, status, headers, config) {
 
				 $scope.init();
 
			 });
 
			 response.error(function(data, status, headers, config) {

				 $window.alert(data);
 
			 });
		 };
	 };
});