angular.module('demo', [])
    .controller('Hello', function($scope, $http) {
        $http.get('/api/users').
            debugger;
        then(function(response) {
            $scope.greeting = response.data;
        });
    });
