package com.example.rest.util;

import org.springframework.stereotype.Component;

import com.example.rest.model.Employee;

@Component
public class EmployeeUtil {

	public void calcuateData(Employee e) {
		Double empSalary = e.getEmpSalary();
		Double empHra = empSalary * 20 / 100.0;
		Double empta = empSalary * 10 / 100.0;

		e.setEmpHra(empHra);
		e.setEmpTa(empta);
	}
}
