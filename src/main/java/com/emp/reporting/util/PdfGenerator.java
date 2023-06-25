package com.emp.reporting.util;

import java.util.List;
import java.util.UUID;

import com.emp.reporting.models.Employee;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;

import java.util.List;
import com.emp.reporting.models.Employee;

@Component("pdf")

public class PdfGenerator implements ReportGenerator {

	@Override
	public void generateReport(List<Employee> employees) {
		
		try {
	            Document document = new Document();
	            String uniqueId = UUID.randomUUID().toString(); 
	            
	            String pdfFilePath = uniqueId + "_employees.pdf";
	            PdfWriter.getInstance(document, new FileOutputStream(pdfFilePath));
	            document.open();

	            if(employees.size()==0)
	    		{
	    		System.out.println("No Records");
	    		return ;
	    		}
	            else {for (Employee employee : employees) {
	                document.add(new Paragraph("Employee ID: " + employee.getId()));
	                document.add(new Paragraph("Name: " + employee.getName()));
	                document.add(new Paragraph("Date Field: " + employee.getDateField()));
	                document.add(new Paragraph("Salary: " + employee.getSalary()));
	                document.add(new Paragraph("\n"));
	            }
	            
	            }
	        	
	            document.close();
	        } catch (DocumentException e) {
	            e.printStackTrace();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }		
	}

	 

