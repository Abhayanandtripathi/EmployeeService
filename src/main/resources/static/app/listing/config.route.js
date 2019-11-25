(function () {
        angular.module('app.home')
            .config(['$routeProvider', function config($routeProvider) {
                $routeProvider.when('/all', {
                    templateUrl: "/app/listing/listing.html",
                    controller: "listingController as vm"
                });
            }]);
    }
)();