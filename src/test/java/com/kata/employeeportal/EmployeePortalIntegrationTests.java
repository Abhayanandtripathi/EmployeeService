package com.kata.employeeportal;



import com.kata.employeeportal.data.EmployeeDTO;
import com.kata.employeeportal.data.EmployeeEntity;
import com.kata.employeeportal.data.EmployeesDTO;
import com.kata.employeeportal.data.repositories.EmployeeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

@ActiveProfiles("DEV")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = EmployeePortalApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeePortalIntegrationTests {

    EmployeeEntity employeeEntity;
    @Autowired
    private TestRestTemplate anonymousRestTemplate;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void checkHealth() throws Exception {
        ResponseEntity<String> response = anonymousRestTemplate.getForEntity("/actuator/health", String.class);
        assertTrue(response.getStatusCode().value() == 200);
    }

    @Before
    public void before() {
        employeeEntity = new EmployeeEntity(1, "a", "b", "c", "01/01/1992", new Date());
        employeeEntity = employeeRepository.save(employeeEntity);
    }

    @Test
    public void testEmployeesApi() {
        String url = "/api/v1/employees";
        ResponseEntity<EmployeesDTO> forEntity = anonymousRestTemplate.getForEntity(url, EmployeesDTO.class);
        EmployeesDTO employees = forEntity.getBody();
        assertNotNull("Should not be NULL", employees);
        assertTrue(forEntity.getStatusCode().value() == 200);
        assertTrue(employees.getEmployees().size() == 1);
    }

    @Test
    public void testAddApi() {
        String url = "/api/v1/add";
        ResponseEntity<EmployeeEntity> response = anonymousRestTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(new EmployeeDTO("The", "Joker", "chaos", "male", "10/01/1995")), EmployeeEntity.class);
        EmployeeEntity body = response.getBody();
        assertNull("Should be NULL", body);
        assertTrue(response.getStatusCode().value() == 200);
    }
}
