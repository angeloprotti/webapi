appCliente.controller("loginController", function($scope, $http){


        $scope.user={};

        $scope.auth = function(){


             $http({
                      method: 'POST',
                      url: 'http://localhost:8080/login',
                      data: $scope.user
                    }).then(function successCallback(response) {

                            console.log("funfou");
                            console.log(response);

                      }, function errorCallback(response) {
                            console.log("Error");
                            console.log(response.data);
                            console.log(response.status);

                      });


        //            console.log("Chamou o auth " + $scope.user.name + " " + $scope.user.password);

        }



});