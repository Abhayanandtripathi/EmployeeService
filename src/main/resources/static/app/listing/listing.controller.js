
(function () {
    'use strict';
    angular
        .module('app.home')
        .controller('listingController', listingController);

    function listingController(apiService) {
        var vm = this;
        vm.employeeList = [];
        activate();

        function activate() {
            apiService.getAllEmployees().then(prepareEmployeeData).catch(_error);
        }
        
        function prepareEmployeeData(responce) {
            vm.employeeList = responce.data.employees;
        }

        function _error() {
            console.log("Could not fetch employees")
        }
    }
})();