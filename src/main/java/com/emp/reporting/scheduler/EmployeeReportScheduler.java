package com.emp.reporting.scheduler;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.emp.reporting.dto.FilterDto;
import com.emp.reporting.dto.RequestDto;
import com.emp.reporting.models.Employee;
import com.emp.reporting.service.EmployeeService;
import com.emp.reporting.util.EmployeeCSVGenerator;
import com.emp.reporting.util.ReportGenerator;


@Component
public class EmployeeReportScheduler {
    
	@Autowired
  EmployeeService employeeService;
    

//Qualifier is Static
     
//	@Autowired
	@Resource(name ="${report.generator.type}")
	private ReportGenerator reportGenerator;
	
   
    @Value("${employee.report.scheduler.cron}")
    private String schedulerCron;

	
	 @Scheduled(cron="${employee.report.scheduler.cron}")
    public void generateEmployeeReport() {
		 List<Employee> employees = employeeService.getFilteredList();
		 System.out.println(employees);
		 
		 reportGenerator.generateReport(employees);
		    
        
        
    }
}