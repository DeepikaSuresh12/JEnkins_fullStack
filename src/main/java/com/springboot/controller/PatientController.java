package com.springboot.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.bean.Patient;
import com.springboot.repo.PatientRepo;

@RestController
@CrossOrigin("*")
public class PatientController {
	
	@Autowired
	PatientRepo repo;
	
	@PostMapping("CreatePatient")
	public String createPatient(@RequestBody Patient patient) {
		String msg="";
		try {
			repo.save(patient);
			msg="Inserted Successfully";
		} catch (Exception e) {
			msg="Failed to Insert";
		}
		return msg;
	}
	
	@GetMapping("GetAllPatient")
	public ArrayList<Patient> getAllPatient(){
		return (ArrayList<Patient>) repo.findAll();
	}
}
