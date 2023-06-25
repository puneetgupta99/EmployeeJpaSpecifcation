package com.emp.reporting.util;

import java.util.List;

import org.springframework.stereotype.Component;

import com.emp.reporting.models.Employee;


public interface ReportGenerator {
	 public void generateReport(List<Employee> employees);
}
