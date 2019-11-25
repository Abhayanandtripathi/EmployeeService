(function () {
        angular.module('app.home')
            .config(['$routeProvider', function config($routeProvider) {
                $routeProvider.when('/', {
                    templateUrl: "/app/registration/registration.html",
                    controller: "registrationController as vm"
                });
            }]);
    }
)();