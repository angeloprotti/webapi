appCliente.controller("loginController", function($scope, $http, $location){


        $scope.user={};
        $scope.token={};


        $scope.auth = function(){


             $http({
                      method: 'POST',
                      url: 'http://localhost:8080/login',
                      data: $scope.user
                    }).then(function successCallback(response) {

                            $scope.token = response.data.token;
                            localStorage.setItem("userToken", response.data.token);


                      }, function errorCallback(response) {
                            console.log("Error");
                            console.log(response.data);
                            console.log(response.status);

                      });


        //            console.log("Chamou o auth " + $scope.user.name + " " + $scope.user.password);

        }



});