(function () {
    'use strict';
    angular
        .module('app.services')
        .factory('apiService', apiService);

    function apiService($http) {
        let ALL_EMPLOYEES = '/employees';
        let ADD_EMPLOYEE = '/add';
        return {
            getAllEmployees: getAllEmployees,
            addEmployee: addEmployee
        };

        function getAllEmployees() {
            return $http.get(ALL_EMPLOYEES);
        }

        function addEmployee(params) {
            return $http.post(ADD_EMPLOYEE, params);
        }
    }

})();