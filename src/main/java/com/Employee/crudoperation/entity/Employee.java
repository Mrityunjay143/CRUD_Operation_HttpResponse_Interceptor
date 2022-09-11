package com.Employee.crudoperation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(  name = "Employee_Tb")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	
	private int id;

	private String firstName ;

	private String lastName;

	private int mobNo;
	
	
//	@Pattern(regexp = "^[a-zA-Z0-9]{6,12}$",
//	message = "username must be of 6 to 12 length with no special characters")
	private String emailId;

	private String department;

	public Employee() {

	}

	public Employee(int id, String firstName, String lastName, int mobNo, String department) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobNo = mobNo;
		this.department = department;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getlastName() {
		return lastName;
	}

	public void setlastName(String lastName) {
		this.lastName = lastName;
	}

	public int getMobNo() {
		return mobNo;
	}

	public void setMobNo(int mobNo) {
		this.mobNo = mobNo;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

}
