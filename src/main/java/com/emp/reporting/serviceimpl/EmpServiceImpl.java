package com.emp.reporting.serviceimpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.emp.reporting.dto.FilterDto;
import com.emp.reporting.dto.RequestDto;
import com.emp.reporting.models.Employee;
import com.emp.reporting.repository.EmpRepository;
import com.emp.reporting.service.EmployeeService;

@Component
public class
EmpServiceImpl implements EmployeeService{

	@Autowired
	private EmpRepository empRepository;
	

	@Autowired  RequestDto  rdto;
	
	
	
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

	@Override
	public Employee getbyEmp(Long id) {
		return empRepository.findById(id).get();
	}

	@Override
	public void delete(Long id) {
	 
		
		empRepository.deleteById(id);
		
	}

	@Override
	public List<Employee> getFilteredList() {
		
	List<Employee> list=	empRepository.findAll(getSpecificatio());
		
		
		return list ;
	}
	
	
	public Specification<Employee> getSpecificatio()
	{
		List<FilterDto> filters =rdto.getFdto();
		System.out.println(filters);
		
 		
 		Specification<Employee> spec=(root, query, criteriaBuilder) -> 
		{	
			List<Predicate>  predicates= new ArrayList<>();
			for( FilterDto f :filters)
			{
				
				
				 if(f.getEquality().equals("gt"))
				{
					 Predicate p;
					 if(f.getField().equals("dateField"))
					 {
							p=criteriaBuilder.greaterThan(root.get(f.getField()),LocalDate.parse(f.getValue()));	
					 }else {
						 p=criteriaBuilder.greaterThan(root.get(f.getField()),f.getValue());	
	 
					 }
					predicates.add(p);
					
				}
				 else  if(f.getEquality().equals("gteq"))
				{
					 Predicate p;
					 if(f.getField().equals("dateField"))
					 {
							p=criteriaBuilder.greaterThanOrEqualTo(root.get(f.getField()),LocalDate.parse(f.getValue()));	
					 }else {
						 p=criteriaBuilder.greaterThanOrEqualTo(root.get(f.getField()),f.getValue());	
	 
					 }
					predicates.add(p);
					
				}
				else if(f.getEquality().equals("ls"))
				{
					Predicate p; 
					if(f.getField().equals("dateField"))
					 {
							 p=criteriaBuilder.lessThan(root.get(f.getField()),LocalDate.parse(f.getValue()));	
					 }else {
							 p=criteriaBuilder.lessThan(root.get(f.getField()),f.getValue());	
	 
					 }	
					predicates.add(p);
						
					
					
				}
				else if(f.getEquality().equals("lseq"))
				{
					Predicate p; 
					if(f.getField().equals("dateField"))
					 {
							 p=criteriaBuilder.lessThanOrEqualTo(root.get(f.getField()),LocalDate.parse(f.getValue()));	
					 }else {
							 p=criteriaBuilder.lessThanOrEqualTo(root.get(f.getField()),f.getValue());	
	 
					 }	
					predicates.add(p);
						
					
					
				}
				else {
				
					Predicate p;
					 if(f.getField().equals("dateField"))
					 {
				p=criteriaBuilder.equal(root.get(f.getField()),LocalDate.parse(f.getValue()));	
					 }else {
						 p=criteriaBuilder.equal(root.get(f.getField()),f.getValue());	
	 
					 }
					predicates.add(p);
								
				
				}
			  
					
		}	
		
		
			return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
			
	};	
				
		return spec;
	}
	
	
	
	

}
