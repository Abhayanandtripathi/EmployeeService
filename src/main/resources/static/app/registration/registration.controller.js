
(function () {
    'use strict';
    angular
        .module('app.home')
        .controller('registrationController', registrationController);

    function registrationController(apiService) {
        var vm = this;
        vm.register = register;
        vm.selectDOB = selectDOB;

        activate();
        ////////////////

        function activate() {
            vm.selctorOpen = false;
            vm.employee = {};
        }

        function register(){
            _parseData();
            apiService.addEmployee(vm.employee).then(_success).catch(_error)
        }

        function selectDOB() {
            vm.selctorOpen = true;
        }

        function _error() {
            vm.employee = {};
            console.log("Could not add employee")
        }

        function _success() {
            console.log("Employee registered successfully!")
        }


        function _parseData(){
            vm.employee.dateOfBirth = new Date(vm.employee.dateOfBirth).toLocaleDateString()
        }

    }
})();