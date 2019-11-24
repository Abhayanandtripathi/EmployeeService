package com.kata.employeeportal.data.repositories;

import com.kata.employeeportal.data.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Integer> {
}
