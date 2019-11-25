
Steps to deploy
----------
* Git Clone https://github.com/Abhayanandtripathi/EmployeeService.git
* Run gradlew build
* Goto Path EmployeeService/src/main/resources/static and run following
  * npm install
  * bower install
  * finally do gradlew bootrun
 
API Documentation
----------
API documentations available at http://localhost:8080/swagger-ui.html.

UI Info
----------

Simple Employee application-
* Navigate to views (registration/ all employees) with navbar
* Registration view - Fill in user details and click on register to add to employee database
* All Employee View - Navigate with top header and see all available employees
* DB is initially kept empty - to change this add inserts to EmployeeService/src/main/resources/data.sql. 