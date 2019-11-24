package com.kata.employeeportal.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.Date;

import static com.kata.employeeportal.data.EmployeeEntity.ColNames.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Employees")
public class EmployeeEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = FIRST_NAME)
    private String firstName;
    @Column(name = LAST_NAME)
    private String lastName;
    @Column(name = DEPARTMENT)
    private String department;
    @Column(name = GENDER)
    private String gender;
    @Column(name = DOB)
    private Date dateOfBirth;

    class ColNames{
        public static final String FIRST_NAME = "emp_first_name";
        public static final String LAST_NAME = "emp_last_name";
        public static final String DEPARTMENT = "emp_department";
        public static final String GENDER = "emp_gender";
        public static final String DOB = "emp_dob";
    }

}
