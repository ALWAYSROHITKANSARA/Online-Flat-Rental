package com.cg.ofr.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cg.ofr.entities.Landlord;
import com.cg.ofr.service.LandlordService;

/*
 * Author : HARSH VARDHAN PANCHOLI
 * Version : 1.0
 * Date : 19/May/2021
 * Description : Landlord Controller Layer
*/


@RestController
@RequestMapping(value="/landlordCtrl")
@CrossOrigin(origins="http://localhost:3000")

public class LandlordController {

	@Autowired
	private LandlordService service;
	static final  Logger LOGGER = LogManager.getLogger(LandlordController.class);
	
	/************************************************************************************
	 * Method: addLanlord
	 * Description: It is used to add landlord into landlord table
	 * returns Landlord :It returns landlord with details
	 * @PostMapping: It is used to handle the HTTP POST requests.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 ************************************************************************************/
	
	
	@PostMapping(value="/addLandlord")
	public ResponseEntity<String> addLandlord(@RequestBody Landlord landlord){
		LOGGER.info("----addLandlord() method initialized");
		Landlord value = service.addLandlord(landlord);
		ResponseEntity<String> retvalue = new ResponseEntity<String>("Landlord with ID: "+value.getLandlordId()+" sucessfully created.",HttpStatus.CREATED);
		LOGGER.info(value.getLandlordName()+" Landlord added sucessfully");
		return retvalue;
	}
	
	/************************************************************************************
	 * Method: updateLandlord
	 * Description: It is used to update landlord into landlord table using Landlord id
	 * returns Landlord :It returns landlord with details
	 * @PutMapping: It is used to handle the HTTP PUT requests.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * @PathVariable:To read path variable data.
	 ************************************************************************************/
	
	@PutMapping(value= "/updateLandlord/{id}")
	public ResponseEntity<String> updateLandlord(@RequestBody Landlord landlord, @PathVariable int id){
		LOGGER.info("----updateLandlord() method initialized");
		Landlord value = service.updateLandlord(landlord, id);
		ResponseEntity<String> retvalue = new ResponseEntity<String>("Landlord with ID: "+value.getLandlordId()+" sucessfully updated.",HttpStatus.ACCEPTED);
		LOGGER.info(value.getLandlordName()+" Landlord updated sucessfully");
		return retvalue;
	}
	
	/************************************************************************************
	 * Method: deleteLandlord
	 * Description: It is used to Delete landlord into landlord table using Landlord id
	 * returns landlord: It returns landlord with details
	 * @DeleteMapping: It is used to handle the HTTP DELETE requests.
	 * @PathVariable:To read path variable data.
	 ************************************************************************************/
	
	@DeleteMapping(value = "/deleteLandlord/{id}")
	public ResponseEntity<Landlord> deleteLandlord(@PathVariable Integer id){
		LOGGER.info("----deleteLandlord() method initialized");
		ResponseEntity<Landlord> retvalue = new ResponseEntity<Landlord>(service.deleteLandlord(id),HttpStatus.OK);
		LOGGER.info("Landlord with id: "+id+" deleted sucessfully");
		return retvalue;
	}
	
	/************************************************************************************
	 * Method: viewLandlord
	 * Description: It is used to view landlord into landlord table
	 * returns landlord: It returns landlord with details
	 * @GetMapping: It is used to handle the HTTP GET requests.
	 * @PathVariable:To read path variable data.
	 ************************************************************************************/
	
	@GetMapping(value = "/viewLandlordByID/{id}")
	public ResponseEntity<Landlord> viewLandlord(@PathVariable Integer id) {
		LOGGER.info("----viewLandlordByID() method initialized");
		Landlord value = service.viewLandlord(id);
		ResponseEntity<Landlord> retvalue = new ResponseEntity<Landlord>(value, HttpStatus.OK);
		LOGGER.info(value.getLandlordName()+" Landlord details displayed sucessfully");
		return retvalue;
	}
	
	/************************************************************************************
	 * Method: viewAlllandlord
	 * Description: It is used to view all landlord details present landlord table
	 * returns list<landlord>:It returns list of landlord with details
	 * @GetMapping: It is used to handle the HTTP GET requests.
	 ************************************************************************************/
	
	@GetMapping(value = "/viewAllLandlord")
	public ResponseEntity<List<Landlord>> viewAllLandlord() {
		LOGGER.info("----viewAllLandlord() method initialized");
		List<Landlord> list = service.viewAllLandlord();
		ResponseEntity<List<Landlord>> retvalue = new ResponseEntity<List<Landlord>>(list, HttpStatus.OK);
		LOGGER.info("List of landlords displayed sucessfully");
		return retvalue;
		
	}
}
