package com.kata.employeeportal.web;

import com.kata.employeeportal.api.IEmployeeRemoteController;
import com.kata.employeeportal.business.EmployeeService;
import com.kata.employeeportal.data.EmployeeDTO;
import com.kata.employeeportal.data.EmployeesDTO;
import com.kata.employeeportal.mapper.EmployeeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmployeeRemoteController implements IEmployeeRemoteController {

    private final EmployeeService employeeService;
    private final EmployeeMapper mapper;

    @Override
    public void addNewEmployee(@RequestBody EmployeeDTO employee){
        employeeService.addEmployee(mapper.toEmployeeEntity(employee));
    }

    @Override
    public EmployeesDTO getAllEmployees(){
        return mapper.toEmployeesDTO(employeeService.getAllEmployees());
    }
}
