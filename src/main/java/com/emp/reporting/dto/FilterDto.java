package com.emp.reporting.dto;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Component
public class FilterDto {

	
	String fieldName;
	String value;
	String equality;
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getEquality() {
		return equality;
	}
	public void setEquality(String equality) {
		this.equality = equality;
	}
	@Override
	public String toString() {
		return "FilterDto [fieldName=" + fieldName + ", value=" + value + ", equality=" + equality + "]";
	}
	public FilterDto(String fieldName, String value, String equality) {
		super();
		this.fieldName = fieldName;
		this.value = value;
		this.equality = equality;
	}
	public FilterDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	 

	 
}
