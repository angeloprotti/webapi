appCliente.controller("clienteController", function($scope, $http, $location){

    $scope.clientes = [];
    $scope.cliente = {};
    $scope.estados = {};
    $scope.clienteAlterar = false;


    $scope.loadClientes = function (){

        $http({
              method: 'GET',
              url: 'http://localhost:8080/clientes'
            }).then(function successCallback(response) {

                    $scope.clientes = response.data;
                    console.log(response.data);

              }, function errorCallback(response) {
                    console.log("Error");
                    console.log(response.data);
                    console.log(response.status);
              });

    };


    $scope.salvarCliente = function (){

        $scope.cliente.estado = $scope.estado;

        if($scope.clienteAlterar){
            $http({
                      method: 'PUT',
                      url: 'http://localhost:8080/auth/clientes',
                      data: $scope.cliente
                    }).then(function successCallback(response) {

                            $scope.loadClientes();

                      }, function errorCallback(response) {
                            console.log("Error");
                            console.log(response.data);
                            console.log(response.status);

                      });


                      $scope.clienteAlterar = false;
        } else {
            $http({
                  method: 'POST',
                  url: 'http://localhost:8080/auth/clientes',
                  data: $scope.cliente
                }).then(function successCallback(response) {

                        $scope.loadClientes();

                  }, function errorCallback(response) {
                        console.log("Error");
                        console.log(response.data);
                        console.log(response.status);

                  });
        }

         $scope.cliente = {};

    }

    $scope.excluirCliente = function (id){

            $http({
                  method: 'DELETE',
                  url: 'http://localhost:8080/auth/clientes/' + id
                }).then(function successCallback(response) {
                        $scope.loadClientes();
                  }, function errorCallback(response) {
                        console.log("Error");
                        console.log(response.data);
                        console.log(response.status);

                  });
        }

     $scope.atualizarCliente = function (clienteAlteracao){
        $scope.clienteAlterar = true;
        $scope.cliente = angular.copy(clienteAlteracao);
     }

    $scope.cancelar = function (){
        $scope.cliente = {};
        $scope.clienteAlterar = false;
    }



     $scope.loadEstados = function (){

            $http({
                  method: 'GET',
                  url: 'http://localhost:8080/estados'
                }).then(function successCallback(response) {

                        $scope.estados = response.data;
                        $scope.estado = $scope.estados[0];

                  }, function errorCallback(response) {
                        console.log("Error");
                        console.log(response.data);
                        console.log(response.status);
                  });

        };



    $scope.loadEstados();
    $scope.loadClientes();



});
