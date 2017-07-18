/**
 * Created by k.tith on 5/24/2017.
 */
var app = angular.module('LoginApp', []);
app.controller('LoginController', function($scope){

    $scope.isHide = false;

    $scope.change = function () {
        $scope.isHide = true;
    }
});
