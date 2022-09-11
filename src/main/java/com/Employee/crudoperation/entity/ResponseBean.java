package com.Employee.crudoperation.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
public class ResponseBean {

	private String status;
	private String message;
	private List<Employee> employees;
	private Employee employee;

	public ResponseBean() {

	}

	public ResponseBean(String status, String message, List<Employee> employees, Employee employee) {
		super();
		this.status = status;
		this.message = message;
		this.employees = employees;
		this.employee = employee;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	public Employee getEmployee(Employee employee) {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}