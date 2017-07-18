/**
 * Created by k.tith on 6/12/2017.
 */
var app = angular.module('UserApp', []);
app.controller('UpdateUserController', function($scope, $http, $filter, $window, $rootScope){

    $scope.product;
    $scope.isDisable = true;
    $scope.disable = true;

    $scope.findAllDealer = function (dealerType) {
        $http({
            method: 'GET',
            url: $scope.product+"/api/v1/dealer?dealerType="+dealerType,
        })
            .then(function (response) {
                $scope.dealers = response.data.DATA;
            }, function (response) {

            });
    };

    $scope.checkProfile = function (profile) {
        if(profile == "2" || profile == "3")
        {
            $scope.isDisable = false;
        }
        else {
            $scope.isDisable = true;
        }
    }
});