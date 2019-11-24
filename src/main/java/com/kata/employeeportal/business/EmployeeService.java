package com.kata.employeeportal.business;

import com.kata.employeeportal.data.EmployeeEntity;
import com.kata.employeeportal.data.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository repository;

    public void addEmployee(EmployeeEntity employee){
        log.info("Request to save employee {}", employee.getFirstName());
        repository.save(employee);
    }

    public List<EmployeeEntity> getAllEmployees(){
        List<EmployeeEntity> employees = new ArrayList<>();
        Iterable<EmployeeEntity> employeeEntities = repository.findAll();
        employeeEntities.forEach(employees::add);
        log.info("Fetched {}", employees.size());
        return employees;
    }
}
