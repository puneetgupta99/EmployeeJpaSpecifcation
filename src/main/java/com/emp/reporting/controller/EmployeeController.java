package com.emp.reporting.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp.reporting.dto.FilterDto;
import com.emp.reporting.dto.RequestDto;
import com.emp.reporting.models.Employee;
import com.emp.reporting.repository.EmpRepository;
import com.emp.reporting.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@Autowired 
	EmpRepository empRepository;
	
	
	
	
	@DeleteMapping("/delete/{id}")
	void deleteEmp(@PathVariable Long id)
	{
		employeeService.delete(id);
		
	}
	
	@PostMapping("/add")
	void addEmp(@RequestBody Employee e)
	{
		employeeService.addEmp(e);
	}
	
	@GetMapping("/{id}")
	Employee getbyId(@PathVariable Long id)
	{
 
		return  employeeService.getbyEmp(id);
		
	}


	@GetMapping("/all")
	Employee get()
	{

		return  employeeService.getbyEmp((long) 10L);

	}
	
	@GetMapping("/filter")
	List<Employee> getfilter()
	{
 		
			
// 		Specification<Employee> spec=(root, query, criteriaBuilder) -> 
//		{
//		
//			LocalDate date=LocalDate.of(2021, 5, 1);
//return criteriaBuilder.greaterThan(root.get("dateField"), date);
//			
//			  
//					
//		};
		Specification<Employee> spec=employeeService.getSpecificatio();
		
		return  empRepository.findAll(spec);
		
	}
	
	
	
	
	@PostMapping("/filters")
	List<Employee> getfilteredlis(@RequestBody RequestDto rdto)
	{
 		List<FilterDto> filters =rdto.getFdto();
		System.out.println(filters);
 		
// 		Specification<Employee> spec=(root, query, criteriaBuilder) -> 
//		{	
//			List<Predicate>  predicates= new ArrayList<>();
//			for( FilterDto f :filters)
//			{
//				
//				
//				 if(f.getEquality().equals("gt"))
//				{
//					 Predicate p;
//					 if(f.getField().equals("dateField"))
//					 {
//							p=criteriaBuilder.greaterThan(root.get(f.getField()),LocalDate.parse(f.getValue()));	
//					 }else {
//						 p=criteriaBuilder.greaterThan(root.get(f.getField()),f.getValue());	
//	 
//					 }
//					predicates.add(p);
//					
//				}
//				else if(f.getEquality().equals("ls"))
//				{
//					Predicate p; 
//					if(f.getField().equals("dateField"))
//					 {
//							 p=criteriaBuilder.greaterThan(root.get(f.getField()),LocalDate.parse(f.getValue()));	
//					 }else {
//							 p=criteriaBuilder.greaterThan(root.get(f.getField()),f.getValue());	
//	 
//					 }	
//					predicates.add(p);
//						
//					
//					
//				}
//				else {
//				
//					Predicate p;
//					 if(f.getField().equals("dateField"))
//					 {
//				p=criteriaBuilder.greaterThan(root.get(f.getField()),LocalDate.parse(f.getValue()));	
//					 }else {
//						 p=criteriaBuilder.greaterThan(root.get(f.getField()),f.getValue());	
//	 
//					 }
//					predicates.add(p);
//								
//				
//				}
//			  
//					
//		}	
//		
//		
//			return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
//			
//	};	
				
				
				Specification<Employee> spec=employeeService.getSpecificatio();
			
	
		return  empRepository.findAll(spec);
		
	}
	
	
}
