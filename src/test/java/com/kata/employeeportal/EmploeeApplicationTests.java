package com.kata.employeeportal;

import com.kata.employeeportal.business.EmployeeService;
import com.kata.employeeportal.data.EmployeeEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@ActiveProfiles("DEV")
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = EmployeePortalApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmploeeApplicationTests {

	EmployeeEntity employeeEntity;
	@Mock
	private EmployeeService employeeService;


	@Before
	public void before() {
		//mocks
		List<EmployeeEntity> mockedList = new ArrayList<>();
		mockedList.add(new EmployeeEntity(1,"a","b","c","d", new Date()));
		mockedList.add(new EmployeeEntity(2,"e","f","g","h", new Date()));
		MockitoAnnotations.initMocks(this);
		when(employeeService.getAllEmployees()).thenReturn(mockedList);
	}

	@Test
	public void testCallingServiceForALL() {
		List<EmployeeEntity> allEmployees = employeeService.getAllEmployees();
		assertTrue(allEmployees.size() == 2);
	}
}

