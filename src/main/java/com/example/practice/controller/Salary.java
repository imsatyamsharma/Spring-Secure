package com.example.practice.controller;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
@Component
@Document(collection = "salarydetails")
public class Salary {
	@Id
	private String id;
	private int empid;

	private int salary;
	public int month;
	public int year;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date2) {
		this.date = date2;
	}

	public int getSalary() {
		return salary;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

}
