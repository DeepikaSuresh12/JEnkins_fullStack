package com.springboot.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.bean.Doctor;

import com.springboot.repo.DoctorRepo;

@RestController
@CrossOrigin("*")
public class DoctorController {

	@Autowired
	DoctorRepo repo;
	
	@PostMapping("CreateDoctor")
	public String createDoctor(@RequestBody Doctor doctor) {
		String msg="";
		try {
			repo.save(doctor);
			msg="Inserted Successfully";
		} catch (Exception e) {
			msg="Failed to Insert";
		}
		return msg;
	}
	
	@GetMapping("GetAllDoctor")
	public ArrayList<Doctor> getAllDoctor(){
		return (ArrayList<Doctor>) repo.findAll();
	}
	
	
}
