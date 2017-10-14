appCliente.controller("clienteController", function($scope, $http, $location){

    $scope.clientes = [];
    $scope.cliente = {};
    $scope.clienteAlterar = false;

    $scope.loadClientes = function (){

        $http({
              method: 'GET',
              url: 'http://localhost:8080/clientes'
            }).then(function successCallback(response) {

                    $scope.clientes = response.data;

              }, function errorCallback(response) {
                    console.log("Error");
                    console.log(response.data);
                    console.log(response.status);
              });

    };


    $scope.salvarCliente = function (){

        if($scope.clienteAlterar){
            $http({
                      method: 'PUT',
                      url: 'http://localhost:8080/clientes',
                      data: $scope.cliente
                    }).then(function successCallback(response) {

                            $scope.loadClientes();

                      }, function errorCallback(response) {
                            console.log("Error");
                            console.log(response.data);
                            console.log(response.status);

                      });

                      $scope.cliente = {};
                      $scope.clienteAlterar = false;
        } else {
            $http({
                  method: 'POST',
                  url: 'http://localhost:8080/clientes',
                  data: $scope.cliente
                }).then(function successCallback(response) {

                        $scope.loadClientes();

                  }, function errorCallback(response) {
                        console.log("Error");
                        console.log(response.data);
                        console.log(response.status);

                  });
        }

    }

    $scope.excluirCliente = function (id){

            $http({
                  method: 'DELETE',
                  url: 'http://localhost:8080/clientes/' + id
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

      $scope.go = function(path){
//            $location.path(path);
            console.log(path);
            console.log('ahahajahahahhahah');
        }





    $scope.loadClientes();



});
