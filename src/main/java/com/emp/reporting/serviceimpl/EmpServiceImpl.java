package com.emp.reporting.serviceimpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.emp.reporting.models.Employee;
import com.emp.reporting.repository.EmpRepository;
import com.emp.reporting.service.EmployeeService;

@Component
public class EmpServiceImpl implements EmployeeService{

	@Autowired
	private EmpRepository empRepository;
	
	@Override
	public List<Employee> getaall() {
		
		
	return empRepository.findAll();	
		
		
	}
	
	@Override
	public Employee addEmp(Employee e) {
		
 // Manually assign the ID
		System.out.println(e);
	
		return empRepository.save(e);
	}

	@Override
	public Employee modifyEmp(Employee e) {
		empRepository.save(e);
		return e;
	}
	
	
	
	

}
