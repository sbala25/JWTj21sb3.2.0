package com.example.JWTj21sb320.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.JWTj21sb320.model.Employee;

@RestController
public class EmployeeController {
	private List<Employee> students = new ArrayList<>(
			List.of(new Employee(1, "Saikat Bala", "abc@gmail.com"), new Employee(2, "Pitchai S", "xyz@gmail.com")));

	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return students;
	}
}
