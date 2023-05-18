package com.attendance.manager.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.attendance.manager.entities.Employee;
import com.attendance.manager.services.EmpService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmpService empService;

	@PostMapping("/saveEmployee")
	public Employee saveEmployee(@RequestBody Employee employee) {
		
		log.info("saveEmployee EmployeeController method running");
		return empService.saveEmplyee(employee);
	}
	
	@GetMapping("/getAllEmployee")
	public List<Employee> getAllEmployee() {
		log.info("getAllEmployee EmployeeController method running");
		return empService.getAllEmployee();
	}
	
	@PutMapping("/updateEmployee/{id}")
	public Employee updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {
		log.info("updateEmployee EmployeeController method running  ", id);
			return empService.updateEmployee(id, employee);
		}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public void deleteEmployee(@PathVariable("id") int id) {
		log.info("deleteEmployee EmployeeController method running  ", id);
		empService.deleteEmployee(id);
	}
	
	@GetMapping("/getEmployeeByName/{name}")
	public List<Employee> getEmployeeByName(@PathVariable("name") String name){
		log.info("getEmployeeByName EmployeeController method running  ", name);
		return empService.findByEmployeeName(name);
	}
	
	@GetMapping("/getEmployeeStartingName/{name}")
	public List<Employee> getEmployeeNameStartingWith(@PathVariable("name") String startingName){
		log.info("getEmployeeStartingName EmployeeController method running  ", startingName);
		return empService.findByEmployeeNameStartingWith(startingName);
	}

}
