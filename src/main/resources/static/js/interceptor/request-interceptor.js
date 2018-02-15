
//Register the interceptor as service
appCliente.factory("requestInterceptor",function($q, $location){


    return {
        'request' : function(config) {
        config.headers.Authorization = 'Bearer ' + localStorage.getItem("userToken");
        return config;
        },

        'responseError' : function(rejection){

                $location.path("/login");
                return $q.reject(rejection);
        }
    };


});