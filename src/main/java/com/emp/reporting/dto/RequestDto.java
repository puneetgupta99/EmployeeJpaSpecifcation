package com.emp.reporting.dto;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


public class RequestDto {

	
	List<FilterDto> fdto;

	public List<FilterDto> getFdto() {
		return fdto;
	}

	public void setFdto(List<FilterDto> fdto) {
		this.fdto = fdto;
	}

	public RequestDto(List<FilterDto> fdto) {
		super();
		this.fdto = fdto;
	}

	public RequestDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "RequestDto [fdto=" + fdto + "]";
	}
	
}
