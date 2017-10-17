appCliente.controller("estadoController", function($scope, $http){


    $scope.estados = {};

     $scope.loadEstados = function (){

            $http({
                  method: 'GET',
                  url: 'http://localhost:8080/estados'
                }).then(function successCallback(response) {

                        $scope.estados = response.data;

                  }, function errorCallback(response) {
                        console.log("Error");
                        console.log(response.data);
                        console.log(response.status);
                  });

        };




     $scope.salvarEstado = function (){

             if($scope.estadoAlterar){
                 $http({
                           method: 'PUT',
                           url: 'http://localhost:8080/estados',
                           data: $scope.estado
                         }).then(function successCallback(response) {

                                 $scope.loadEstados();

                           }, function errorCallback(response) {
                                 console.log("Error");
                                 console.log(response.data);
                                 console.log(response.status);

                           });


                           $scope.estadoAlterar = false;
             } else {
                 $http({
                       method: 'POST',
                       url: 'http://localhost:8080/estados',
                       data: $scope.estado
                     }).then(function successCallback(response) {

                             $scope.loadEstados();

                       }, function errorCallback(response) {
                             console.log("Error");
                             console.log(response.data);
                             console.log(response.status);

                       });
             }

              $scope.estado = {};

         }

         $scope.excluirEstado = function (id){

                 $http({
                       method: 'DELETE',
                       url: 'http://localhost:8080/estado/' + id
                     }).then(function successCallback(response) {
                             $scope.loadEstados();
                       }, function errorCallback(response) {
                             console.log("Error");
                             console.log(response.data);
                             console.log(response.status);

                       });
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









    $scope.loadEstados();

});