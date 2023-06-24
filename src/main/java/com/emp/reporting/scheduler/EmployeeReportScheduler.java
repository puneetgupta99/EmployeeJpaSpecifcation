package com.emp.reporting.scheduler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
@EnableScheduling
public class EmployeeReportScheduler {
    
	@Autowired
  EmployeeService employeeService;
    
	@Autowired
	  ReportGenerator reportGenerator;

//	
//	@Autowired
//	List<FilterDto> fdtos;
   

	 @Scheduled(cron = "0 */30 * * * *")// Run every Monday at midnight
    public void generateEmployeeReport() {
		 List<Employee> employees = employeeService.getaall();
		    
		    EmployeeCSVGenerator csvGenerator = new EmployeeCSVGenerator();
		    csvGenerator.generateEmployeeCSV(employees,1);
		    
        
        
    }
}