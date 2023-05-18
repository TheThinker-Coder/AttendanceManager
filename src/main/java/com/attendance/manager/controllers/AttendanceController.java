package com.attendance.manager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.attendance.manager.entities.Attendance;
import com.attendance.manager.services.AttService;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

	@Autowired
	private AttService attService;

	@PostMapping("/saveAttendance")
	public Attendance saveAttendance(@RequestBody Attendance attendance) {
		System.out.println("getEmployee  "+attendance.getEmployee());
		return attService.saveAttendance(attendance);
	}

	@GetMapping("/getAttendance")
	public List<Attendance> getAllAttendance() {
		return attService.getAllAttendance();
	}

	@PutMapping("/updateAttendance/{id}")
	public Attendance updateAttendance(@PathVariable("id") int id, @RequestBody Attendance attendance) {
		return attService.updateAttendance(id, attendance);
	}

	@DeleteMapping("/deleteAttendance/{id}")
	public void deleteAttendance(@PathVariable("id") int id) {
		attService.deleteAttendance(id);
	}

}
