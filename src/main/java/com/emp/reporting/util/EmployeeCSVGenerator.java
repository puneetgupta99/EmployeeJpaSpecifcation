package com.emp.reporting.util;



import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.emp.reporting.models.Employee;

@Component("csv")
public class EmployeeCSVGenerator implements ReportGenerator{
    
    public void generateReport(List<Employee> employees) {
        
    	LocalDate currentDate = LocalDate.now();
  
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        System.out.println(new Date());
        LocalDateTime s=LocalDateTime.now();
String uniqueId = UUID.randomUUID().toString(); 
        
        String csvFilePath = uniqueId + "_employees.csv";
    	
      
        try (FileWriter writer = new FileWriter(csvFilePath)) {
           
            writer.append("ID,Name,Date,Salary\n");
            
            for (Employee employee : employees) {
                writer.append(String.format("%d,%s,%s,%d\n",
                        employee.getId(),
                        employee.getName(),
                        employee.getDateField(),
                        employee.getSalary()));
            }
		    System.out.println("CSV file generated successfully.");

		    
           
        } catch (IOException e) {
            System.out.println("Error while generating CSV file: " + e.getMessage());
        }
    }
}
