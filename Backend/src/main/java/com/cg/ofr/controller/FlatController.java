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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ofr.entities.Flat;
import com.cg.ofr.exception.FlatNotFoundException;
import com.cg.ofr.service.FlatService;

//Description : This is Flat Controller


@RestController    /*Spring RestController takes care of mapping request data 
                    * to the defined request handler method
                    */   
@RequestMapping(value = "/flat",method = RequestMethod.GET)
@CrossOrigin(origins="http://localhost:3000")



public class FlatController {
	private static final Logger logger = LogManager.getLogger(FlatController.class);
	@Autowired
	FlatService flatService;

	/************************************************************************************
	 * Method: addFlat
	 * Description: It is used to add flat into flat table
	 * @param flat: Flat reference variable.
	 * @returns flat :It returns flat table with details
	 * @PostMapping: It is used to handle the HTTP POST requests matched.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * 
	 ************************************************************************************/
	
	@PostMapping(value = "/addflat")
	public ResponseEntity<Flat> addFlat(@RequestBody Flat flat) {
		logger.info("----addFlat() method initialized");

		return new ResponseEntity<>(flatService.addFlat(flat), HttpStatus.CREATED);
	}

	/************************************************************************************
	 * Method: deleteFlat
	 * Description: It is used to delete flat from flat table
	 * @param flat: Flat reference variable.
	 * @returns flat :It returns flat table with details
	 * @DeleteMapping: It is used to handle the HTTP DELETE requests matched.
	 *  
	 ************************************************************************************/
	@DeleteMapping(value = "/removeflat/{flatId}")
	public ResponseEntity<String> deleteFlat(@PathVariable Integer flatId){
		logger.info("----removeLandlord() method initialized");
        flatService.deleteFlat(flatId);
        ResponseEntity<String> retvalue = new ResponseEntity<String>("Flat with ID: "+flatId+" successfully deleted.",HttpStatus.OK);
        logger.info("Landlord with id: "+flatId+" deleted successfully");
        return retvalue;
    }

	/************************************************************************************
	 * Method: getAllFlats
	 * Description: It is used to get all flats from flat table
	 * @param flat: Flat reference variable.
	 * @returns flat :It returns flat table with details
	 * @GetMapping: It is used to handle the HTTP GET requests matched.
	 *  
	 ************************************************************************************/
	
	@GetMapping(value = "/getallflats")
	public ResponseEntity<List<Flat>> getAllFlats() {
		logger.info("----getAllFlats() method initialized");
		List<Flat> allFlats = flatService.getAllFlats();
		ResponseEntity<List<Flat>> entity = new ResponseEntity<List<Flat>>(allFlats, HttpStatus.OK);
		return entity;
	}
	
	/************************************************************************************
	 * Method: updateFlat
	 * Description: It is used to update flat which is already there in flat table
	 * @param flat: Flat reference variable.
	 * @returns flat :It returns flat table with details
	 * @PutMapping: It is used to handle the HTTP PUT requests matched.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * 
	 ************************************************************************************/

	@PutMapping(value = "/updateflat/{flatId}")
	public ResponseEntity<String> updateFlat(@RequestBody Flat flat, @PathVariable Integer flatId){
		logger.info("----updateFlat() method initialized");
		Flat value = flatService.updateFlat(flatId, flat);
		ResponseEntity<String> retvalue = new ResponseEntity<String>("Landlord with ID: "+value.getFlatId()+" successfully updated.",HttpStatus.ACCEPTED);
		logger.info(value.getFlatId()+" Flat updated successfully");
		return retvalue;
	}

	/************************************************************************************
	 * Method: viewFlatById
	 * Description: It is used to view flat mapped with that Id in flat table
	 * @param flat: Flat reference variable.
	 * @returns flat :It returns flat table with details
	 * @GetMapping: It is used to handle the HTTP GET requests matched.
	 * 
	 ************************************************************************************/
	
	@GetMapping(value = "/viewflatbyid/{flatId}")
	public ResponseEntity<Flat> viewFlatById(@PathVariable("flatId") Integer id) throws FlatNotFoundException {
		logger.info("----viewFlatbyId() method initialized");
		return new ResponseEntity<Flat>(flatService.viewFlatById(id), HttpStatus.OK);
	}
}
