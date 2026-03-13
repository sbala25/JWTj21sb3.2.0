package com.example.JWTj21sb320.controller;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import com.example.JWTj21sb320.model.Employee;

@RestController
public class EmployeeController {
	private List<Employee> students = new ArrayList<>(
			List.of(new Employee(1, "Saikat Bala", "abc@gmail.com"), new Employee(2, "Pitchai S", "xyz@gmail.com")));

	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return students;
	}

	@GetMapping("/employeesbyName")
	public String getEmployeesByName(@RequestParam("name") String name) {
		return name;
	}

	@GetMapping("/employeesbyId")
	public Integer getEmployeesById(@RequestParam("id") Integer id) {
		return id;
	}

	@PostMapping("/employees")
	public Employee employees(@Valid @RequestBody Employee employee) {
		return employee;
	}
}
