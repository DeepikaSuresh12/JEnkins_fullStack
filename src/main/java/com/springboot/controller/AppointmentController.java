package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.bean.Appointment;
import com.springboot.repo.AppointmentRepo;

@RestController
@CrossOrigin("*")
public class AppointmentController {

	
	@Autowired
	AppointmentRepo repo;
	
	@PostMapping("CreateAppointment")
	public String createAppointment(@RequestBody Appointment appointment) {
		
		System.out.println(appointment);
		String msg="";
		try {
			repo.save(appointment);
			msg="Inserted Successfully";
		} catch (Exception e) {
			msg="Failed to Insert";
			e.printStackTrace();
		}
		return msg;
	}
	
	@GetMapping("/GetAllAppointment")
	public List<Appointment> getAllAppointment(){
		return repo.findAll();
	}
	
	@GetMapping("/getIdList")
	public List<Appointment> getIdList(){
		return repo.getId();
	}
}
