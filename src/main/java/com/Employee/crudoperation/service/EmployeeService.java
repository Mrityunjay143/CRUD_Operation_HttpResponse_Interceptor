package com.Employee.crudoperation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Employee.crudoperation.entity.Employee;
import com.Employee.crudoperation.repository.EmployeeRepository;


@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	//add employees
	  public Employee saveEmployee(Employee employee) {
		  return  employeeRepository.save(employee);
	   }
	  //Get list of employees
	  public List<Employee> getEmployees(){
		  return employeeRepository.findAll();
	  }
	   
	  //FindById
	  public Employee getEmloyeeById(int id) {
		  return employeeRepository.findById(id).get();
	  }
	
	  public Employee getEmployeeByName(String firstName) {
		  return employeeRepository.findByfirstName(firstName);
	  }
	  
	  //DeletBY id
	  public String deleteEmployee(int id) {
		  employeeRepository.deleteById(id);
		  return "Employee Removed...!!" + id;
	  }
	  
	  // update
	  
	  public Employee updateEmployee(Employee employee) {
		  Employee existEmployee = employeeRepository.findById(employee.getId()).orElse(null);
		  existEmployee.setFirstName(employee.getFirstName());
		  existEmployee.setlastName(employee.getlastName());
		  existEmployee.setMobNo(employee.getMobNo());
		  existEmployee.setDepartment(employee.getDepartment());
		return employeeRepository.save(existEmployee);
		  
	  }	
	  
	  public boolean isEmployeeExist(Employee employee) {
			return getEmployeeByName(employee.getFirstName())!=null;
		}

}
