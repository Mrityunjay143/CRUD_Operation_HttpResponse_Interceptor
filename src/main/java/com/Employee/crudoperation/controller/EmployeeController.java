package com.Employee.crudoperation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Caching;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Employee.crudoperation.entity.Employee;
import com.Employee.crudoperation.entity.ResponseBean;
import com.Employee.crudoperation.service.EmployeeService;

@RestController
@EnableCaching
@Component
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/")
	public String Employee() {
		return "CRUD Operation API..!";

	}

//  //post operation
//	@PostMapping("/addEmployee")
//	@ResponseStatus(HttpStatus.CREATED)
//	public Employee addEmployee(@RequestBody Employee employee) {
//		return employeeService.saveEmployee(employee);
//	}

	ResponseBean response = new ResponseBean();

	/*--------------------Creating the Data------------------------------*/
	@PostMapping("/addEmployee")
	public ResponseBean addEmployee(@RequestBody Employee employee) {
		System.out.println("Creating Employee " + employee.getFirstName());

		if (employeeService.isEmployeeExist(employee)) {
			System.out.println("A User with name " + employee.getFirstName() + " already exist");
			response.setStatus(HttpStatus.CONFLICT.toString());
			response.setMessage("Employee is already exist..!");
			return response;
		}
		employeeService.saveEmployee(employee);

		response.setStatus(HttpStatus.CREATED.toString());
		response.setMessage("Employee is added succesfully");
		return response;

	}

//	@GetMapping("/Employees")
//	public List<Employee> findAllEmployees(){
//		return employeeService.getEmployees();
//	
//	}
	/*--------------------Retrieving the Data------------------------------*/
	@GetMapping("/Employees")
	@Caching
	public ResponseBean findAllEmployees() {
		List<Employee> employee = employeeService.getEmployees();
		if (employee.isEmpty()) {
//			return new ResponseEntity<List<Employee>>(employees, HttpStatus.NO_CONTENT);
			response.setStatus(HttpStatus.NO_CONTENT.toString());
			response.setMessage("List is Empty");
			response.setEmployees(null);
			return response;
		}
//		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
		response.setStatus(HttpStatus.OK.toString());
		response.setMessage("Successfully all the data is retrived...!");
		response.setEmployees(employee);
		return response;
	}

	// Get EmployeesById
	@GetMapping("/Employee/{id}")
	public ResponseBean findById(@PathVariable int id) {

		System.out.println("Fetching Employee By Id: " + id);
		Employee employee = employeeService.getEmloyeeById(id);

		if (employee == null) {
			System.out.println("Employee with Id {} not found..: " + id);
			response.setStatus(HttpStatus.NOT_FOUND.toString());
			response.setMessage("Employee is Not Exist..!");
			response.setEmployee(null);
			return response;

		}
		response.setStatus(HttpStatus.FOUND.toString());
		response.setMessage("Employee " + id + " Fetched Successfully");
		response.setEmployee(employee);
		return response;

//		return employeeService.getEmloyeeById(id);
	}

	@PutMapping("/update")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);
	}

	@DeleteMapping("/Employee/delete/{id}")
	public String deleteEmployee(@PathVariable int id) {
		return employeeService.deleteEmployee(id);
	}

	// Get EmployeeByNmae

//	@GetMapping("/Employee/{firstName}")
////	@RequestMapping(value = "Employee/{name}", method = RequestMethod.GET)
//	public Employee findByfirstName(@PathVariable String firstName) {
//		return employeeService.getEmployeeByName(firstName);
//	}

}
