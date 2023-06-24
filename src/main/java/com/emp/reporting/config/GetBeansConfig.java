package com.emp.reporting.config;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.emp.reporting.dto.FilterDto;
import com.emp.reporting.dto.RequestDto;

import ch.qos.logback.core.filter.Filter;

@Component
@Configuration
public class GetBeansConfig {

	
	@Bean 
	FilterDto getdto()
	{
		
		return new FilterDto("dateField","2021-05-05", "ls");
	}

	@Bean
	FilterDto getdto2()
	{
		return new FilterDto("salary","1500", "gt");
	}
	
	@Bean RequestDto getrdto() {
	
		FilterDto f1=getdto();
		FilterDto f2=getdto2();
		List<FilterDto> l=new ArrayList<>();
		l.add(f1);
		l.add(f2);
		return new RequestDto(l);
		
	}
	
	
}
