package com;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.builder.EmployeeBuilder;
import com.entity.Employee;
import com.service.IEmployeeSvc;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = { "classpath:spring-servlet.xml",
		"classpath:spring-servlet3.xml" })
public class EmployeeServiceTest {
	@Autowired
	IEmployeeSvc employeeSvc;

	@Test
	public void testEmployeeSave() {
		Employee employee = EmployeeBuilder.anyEmployee();
		Employee createdEmployee = employeeSvc.create(employee);
		Assert.assertEquals(employee.getEid(), createdEmployee.getEid());
		Assert.assertEquals(employee.getName(), createdEmployee.getName());
	}
}
