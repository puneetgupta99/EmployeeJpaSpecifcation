package com.emp.reporting.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.emp.reporting.models.Employee;




@Service
public interface EmployeeService {

	
List<Employee> getaall();
	

   Employee addEmp(Employee e);
   
   Employee modifyEmp(Employee e);
   
}
