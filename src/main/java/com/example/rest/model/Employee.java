package com.example.rest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "emptab")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
	private Integer empId;

	@NonNull
	@Column(name = "ename")
	private String empName;

	@NonNull
	@Column(name = "esalary")
	private Double empSalary;

	@NonNull
	@Column(name = "edept")
	private String empDept;

	@Column(name = "ehra")
	private Double empHra;

	@Column(name = "eta")
	private Double empTa;

}
