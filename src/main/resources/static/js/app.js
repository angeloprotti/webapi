
var appCliente = angular.module("appCliente",['ngRoute']);



appCliente.config(function($routeProvider, $locationProvider){

      $routeProvider
       .when('/clientes', {
            templateUrl: 'view/cliente.html',
            controller: 'clienteController'
        })
        .when('/estados', {
            templateUrl: 'view/estado.html',
            controller: 'estadoController'
        })
        .when('/cidades/', {
            templateUrl: '/view/cidade.html',
            controller: 'cidadeController'
        })
        .when('/clientes/:id', {
            templateUrl: '/view/cliente-detalhe.html',
            controller: 'clienteDetalheController'
        })
        .when('/login', {
            templateUrl: '/view/login.html',
            controller: 'loginController'
        })
        .otherwise({redirectTo:'/'});

      // configure html5 to get links working on jsfiddle
        $locationProvider.html5Mode({
             enabled: true,
             requireBase: false
         });﻿



    });

appCliente.config(function($httpProvider){

    $httpProvider.interceptors.push("requestInterceptor");

});

