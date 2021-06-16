package com.cg.ofr.controller;

import java.util.List;

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

import com.cg.ofr.entities.FlatBooking;
import com.cg.ofr.service.FlatBookingService;

/* This is FlatBooking Controller
 * Author: Amol Gokhale
 * Version : 1.0
 * Date : 19/May/2021
 */


@RestController
@RequestMapping(value="/FlatBookingCtrl")
@CrossOrigin(origins="http://localhost:3000")

public class FlatBookingController {
	final static Logger logger=LogManager.getLogger(FlatBookingController.class);
	@Autowired
	private FlatBookingService service;
	/************************************************************************************
	 * Method: addFlatBooking
	 * Description: It is used to add flatBooking into flat_booking table
	 * returns flatBooking :It returns flatBooking with details
	 * @PostMapping: It is used to handle the HTTP POST requests.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 ************************************************************************************/
	
	@PostMapping(value="/addFlatBooking")
	public ResponseEntity<String> addFlatBooking(@RequestBody FlatBooking flatbooking){
		FlatBooking value = service.addFlatBooking(flatbooking);
		ResponseEntity<String> retvalue = new ResponseEntity<>("FlatBooking with Booking No: "+value.getBookingNo()+" sucessfully created.",HttpStatus.CREATED);
		logger.info("addFlatBooking() has executed");
		return retvalue;
	}
	/************************************************************************************
	 * Method: updateFlatBooking
	 * Description: It is used to update flatBooking into flat_booking table
	 * returns flatBooking: It returns flatBooking with details
	 * @PutMapping: It is used to handle the HTTP PUT requests.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * @PathVariable:To read path variable data.
	 ************************************************************************************/
	@PutMapping(value= "/updateFlatBooking/{id}")
	public ResponseEntity<String> updateFlatBooking(@RequestBody FlatBooking flatbooking,@PathVariable Integer id){
		FlatBooking value = service.updateFlatBooking(flatbooking,id);
		ResponseEntity<String> retvalue = new ResponseEntity<String>("FlatBooking with Booking No: "+value.getBookingNo()+" sucessfully updated.",HttpStatus.ACCEPTED);
		logger.info("updateFlatBooking() has executed");
		return retvalue;
	}
	/************************************************************************************
	 * Method: deleteFlatBooking
	 * Description: It is used to Delete flatBooking into flat_booking table
	 * returns flatBooking: It returns FlatBooking with details
	 * @DeleteMapping: It is used to handle the HTTP DELETE requests.
	 * @PathVariable:To read path variable data.
	 ************************************************************************************/
	@DeleteMapping(value = "/deleteFlatBooking/{id}")
	public ResponseEntity<String> deleteFlatBooking(@PathVariable Integer id){
		service.deleteFlatBooking(id);
		ResponseEntity<String> retvalue = new ResponseEntity<String>("FlatBooking with Booking No: "+id+" sucessfully deleted.",HttpStatus.OK);
		logger.info("deleteFlatBooking() has executed");
		return retvalue;
	}
	/************************************************************************************
	 * Method: viewFlatBooking
	 * Description: It is used to view FlatBooking into flat_booking table
	 * returns flatBooking: It returns flatBooking with details
	 * @GetMapping: It is used to handle the HTTP GET requests.
	 * @PathVariable:To read path variable data.
	 ************************************************************************************/
	@GetMapping(value = "/viewFlatBookingByID/{id}")
	public ResponseEntity<FlatBooking> viewFlatBooking(@PathVariable Integer id) {
		FlatBooking value = service.viewFlatBooking(id);
		ResponseEntity<FlatBooking> retvalue = new ResponseEntity<FlatBooking>(value, HttpStatus.OK);
		logger.info("viewFlatBooking() has executed");
		return retvalue;
	}
	/************************************************************************************
	 * Method: viewAllFlatBookings
	 * Description: It is used to view all FlatBooking details present flat_booking table
	 * returns List<flatBooking> :It returns list of flatBooking with details
	 * @GetMapping: It is used to handle the HTTP GET requests.
	 ************************************************************************************/
	@GetMapping(value = "/viewAllFlatBooking")
	public ResponseEntity<List<FlatBooking>> viewAllFlatBooking() {
		List<FlatBooking> list = service.viewAllFlatBooking();
		ResponseEntity<List<FlatBooking>> retvalue = new ResponseEntity<List<FlatBooking>>(list, HttpStatus.OK);
		logger.info("view-all-flatBooking URL is opened");
		logger.info("getAllFlatBooking() is initiated");
		logger.info("getAllFlatBooking() has executed");
		return retvalue;
		
	}
}
