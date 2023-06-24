package com.emp.reporting.serviceimpl;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
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
		Specification<Employee> spec= new Specification<Employee>() {
			
			@Override
			public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				// TODO Auto-generated method stub
				return null;
			}
		};
		
		
		return spec;
	}
	
	
	
	

}
