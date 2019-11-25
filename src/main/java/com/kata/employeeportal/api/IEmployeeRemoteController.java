package com.kata.employeeportal.api;

import com.kata.employeeportal.data.EmployeeDTO;
import com.kata.employeeportal.data.EmployeesDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static com.kata.employeeportal.api.IEmployeeRemoteController.API.ADD_EMPLOYEE_API;
import static com.kata.employeeportal.api.IEmployeeRemoteController.API.GET_ALL_EMPLOYEES_API;

public interface IEmployeeRemoteController {

    @ApiOperation(value = "")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = ADD_EMPLOYEE_API)
    void addNewEmployee(@RequestBody EmployeeDTO employee);

    @ApiOperation(value = "", response = EmployeesDTO.class)
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = GET_ALL_EMPLOYEES_API)
    EmployeesDTO getAllEmployees();

    class API{
        public static final String ADD_EMPLOYEE_API = "api/v1/add";
        public static final String GET_ALL_EMPLOYEES_API = "api/v1/employees";
    }
}
