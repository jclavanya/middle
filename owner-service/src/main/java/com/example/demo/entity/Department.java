package com.example.demo.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="Adddepartment")
public class Department  {


@Id
private String departmentID;
private String departmentName;
private String numberofemp ;



public String getDepartmentID() {
	return departmentID;
}

public void setDepartmentID(String departmentID) {
	this.departmentID = departmentID;
}

public String getDepartmentName() {
	return departmentName;
}

public void setDepartmentName(String departmentName) {
	this.departmentName = departmentName;
}



public String getNumberofemp() {
	return numberofemp;
}

public void setNumberofemp(String numberofemp) {
	this.numberofemp = numberofemp;
}

public Department()
{
	
}



public Department( String departmentName, String numberofemp ) {
	
	
	this.departmentName = departmentName;
	this.numberofemp=numberofemp;
}



}



