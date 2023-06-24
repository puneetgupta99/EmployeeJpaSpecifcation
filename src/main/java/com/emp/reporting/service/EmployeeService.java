package com.emp.reporting.service;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.emp.reporting.models.Employee;




@Service
public interface EmployeeService {

	
List<Employee> getaall();
	

   Employee addEmp(Employee e);
   
   Employee modifyEmp(Employee e);
   
   Employee getbyEmp(Long id);
   
   void delete(Long id);
   
   List<Employee> getFilteredList();
   
   public Specification<Employee> getSpecificatio();
}
