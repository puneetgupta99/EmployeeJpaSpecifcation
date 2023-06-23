package com.emp.reporting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@SpringBootApplication
public class EmpReportingApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpReportingApplication.class, args);
	}

}
