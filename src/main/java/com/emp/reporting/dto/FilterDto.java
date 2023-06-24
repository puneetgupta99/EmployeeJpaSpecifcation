package com.emp.reporting.dto;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;



public class FilterDto {
	
	String field;
	
	
	String value;
	String equality;
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
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
	public FilterDto(String field, String value, String equality) {
		super();
		this.field = field;
		this.value = value;
		this.equality = equality;
	}
	public FilterDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "FilterDto [field=" + field + ", value=" + value + ", equality=" + equality + "]";
	}
	
	

	 

	 
}
