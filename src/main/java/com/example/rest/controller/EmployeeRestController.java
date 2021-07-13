package com.example.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.custom.exception.EmployeeNotFoundExcetion;
import com.example.rest.model.Employee;
import com.example.rest.service.IEmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {

	@Autowired
	IEmployeeService service;

	// 1. Get all Employees
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> allEmployees = service.getAllEmployees();
		return new ResponseEntity<>(allEmployees, HttpStatus.OK);
	}

	// 2. Get one Employee
	@GetMapping("/one/{id}")
	public ResponseEntity<?> getOneEmployee(@PathVariable Integer id) {
		
		// <?> Generic Wild card char -- indicates data type for Generic is decided 
		// based on execution flow at runtime.
		ResponseEntity<?> response = null;
		try {
			Employee employee = service.getEmployeeById(id);
			response = new ResponseEntity<>(employee, HttpStatus.OK);  // 200
		}catch (EmployeeNotFoundExcetion enfe) {
			throw enfe;
		}
		return response;
	}

	// 3. Create one Employee
	@PostMapping("/save")
	public ResponseEntity<String> createEmployee(@RequestBody Employee e) {
		Integer empId = service.saveEmployee(e);
		return new ResponseEntity<>("Employee created with following id: " + empId, HttpStatus.OK);
	}
	
	// 4. Update one Employee
	@PutMapping("/update")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee e){
		ResponseEntity<String>  response = null;
		try {
			service.updateEmploee(e);
			response = new ResponseEntity<>("Employee update with following id: "+e.getEmpId(), HttpStatus.OK);
		}catch(EmployeeNotFoundExcetion enfe) {
			throw enfe;
		}
		return response;
	}
	
	// 5. delete employee by using id
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Integer id){
		ResponseEntity<String> response = null;
		service.deleteEmployee(id);
		response = new ResponseEntity<>("Employee delete with following id: "+ id,HttpStatus.OK);
		return response;
	}
}
