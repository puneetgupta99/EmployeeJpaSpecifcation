package com.emp.reporting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.emp.reporting.models.Employee;

@Repository
public interface EmpRepository extends JpaRepository<Employee,Long> ,JpaSpecificationExecutor<Employee> {

	
	
	
}
