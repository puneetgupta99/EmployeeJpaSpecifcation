package com.emp.reporting.models;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;




@Entity
public class Employee {
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    
	private String name;
    
	@JsonFormat(pattern = "dd-MM-yy")
    private LocalDate dateField;
    
	private int salary;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDateField() {
		return dateField;
	}

	public void setDateField(LocalDate dateField) {
		this.dateField = dateField;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", dateField=" + dateField + ", salary=" + salary + "]";
	}

	
	
	

    
    // Constructors, getters, and setters
}
