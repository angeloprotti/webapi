
var appCliente = angular.module("appCliente",[]);

appCliente.controller("indexController", function($scope, $http){

    $scope.nome = "Jao";
    $scope.clientes = [];

    $http({
      method: 'GET',
      url: 'http://localhost:8080/clientes'
    }).then(function successCallback(response) {

            $scope.clientes = response.data;
            console.log(response.data);
            console.log(response.status);

      }, function errorCallback(response) {
            console.log("Error");
            console.log(response.data);
            console.log(response.status);

      });


});
