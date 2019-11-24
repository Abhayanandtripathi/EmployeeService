package com.kata.employeeportal.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private String firstName;
    private String lastName;
    private String department;
    private String gender;
    private String dateOfBirth;
}
