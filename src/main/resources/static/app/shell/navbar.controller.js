(function () {
    'use strict';
    angular
        .module('app.services')
        .controller('navbarController', navbarController);

    function navbarController() {
        var vm = this;

        activate();
        ////////////////

        function activate() {
            vm.pageName = 'Employee Portal';
            vm.register = 'New Registration';
            vm.all = 'Employee List';
        }
    }
})();