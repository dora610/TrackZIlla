package com.karurisuro.springBootMvc.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.karurisuro.springBootMvc.entity.Application;
import com.karurisuro.springBootMvc.exception.ApplicationNotFoundException;
import com.karurisuro.springBootMvc.service.ApplicationService;

@RestController
@RequestMapping("/tza")
public class TzaRestController {
	@Autowired
	private ApplicationService applicationService;
	
	@GetMapping("/applications")
	public ResponseEntity<List<Application>> getAllApplications(){
		return ResponseEntity.ok(applicationService.listApplication());
	}
	
	@GetMapping("/application/{id}")
	public ResponseEntity<Application> getApplication(@PathVariable(name = "id") Long appId){
//		return ResponseEntity.ok(applicationService.fetchApplication(appId));
		try {
			return ResponseEntity.ok(applicationService.fetchApplication(appId));
		} catch (ApplicationNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Application not found!!");
		}
		
	}

}
