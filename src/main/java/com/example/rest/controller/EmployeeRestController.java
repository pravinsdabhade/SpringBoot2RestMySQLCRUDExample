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
import com.example.rest.model.Message;
import com.example.rest.service.IEmployeeService;

import springfox.documentation.annotations.ApiIgnore;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "*")
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
	public ResponseEntity<Message> createEmployee(@RequestBody Employee e) {
		ResponseEntity<Message> resMsg= null;
		try {
			Integer empId = service.saveEmployee(e);
			resMsg = new ResponseEntity<>(new Message("Employee created with following id: ",+empId+" -Saved"),HttpStatus.OK);
		}catch (Exception ex) {
			resMsg = new ResponseEntity<>(new Message("Fail","Unable to Save"),HttpStatus.INTERNAL_SERVER_ERROR);
			ex.printStackTrace();
		}
		return resMsg;
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
	@ApiIgnore
	public ResponseEntity<String> deleteEmployee(@PathVariable Integer id){
		ResponseEntity<String> response = null;
		service.deleteEmployee(id);
		response = new ResponseEntity<>("Employee delete with following id: "+ id,HttpStatus.OK);
		return response;
	}
}
