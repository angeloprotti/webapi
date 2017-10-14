appCliente.controller("clienteDetalheController", function($scope, $routeParams, $http){


    $scope.cliente = {};

    $http.get("http://localhost:8080/clientes/" + $routeParams.id )
        .then(function(response){

            console.log(response);
            $scope.cliente = response.data;

        }, function (response){

            console.log(response);

        });

});