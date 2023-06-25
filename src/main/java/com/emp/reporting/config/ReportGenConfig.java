package com.emp.reporting.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.emp.reporting.util.EmployeeCSVGenerator;
import com.emp.reporting.util.PdfGenerator;
import com.emp.reporting.util.ReportGenerator;

@Component
@Configuration
public class ReportGenConfig {

//	
//	@Value("${report.generator.type}")
//    private String reportType;
//
//	@Primary
//    @Bean
//    @ConditionalOnProperty(name ="report.generator.type" , havingValue = "csv")
//    public ReportGenerator csvGen() {
//    System.out.println("using CSv Genrator");
//    	return new EmployeeCSVGenerator();
//    }
//
//    @Primary
//    @Bean
//    @ConditionalOnProperty(name ="report.generator.type" , havingValue = "pdf")
//    public ReportGenerator pdfGen() {
//    	System.out.println("using PDf Genrator");
//        return new PdfGenerator();
//    }
	
	
}
