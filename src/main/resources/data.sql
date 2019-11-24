DROP TABLE IF EXISTS employee_table;

CREATE TABLE employee_table (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  emp_first_name VARCHAR(250) NOT NULL,
  emp_last_name VARCHAR(250) NOT NULL,
  emp_department VARCHAR(250) NOT NULL,
  emp_dob date NOT NULL,
  emp_gender VARCHAR(10) NOT NULL
);