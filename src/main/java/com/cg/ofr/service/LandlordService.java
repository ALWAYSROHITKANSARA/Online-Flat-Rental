package com.cg.ofr.service;

/*
 * Author : HARSH VARDHAN PANCHOLI
 * Version : 1.0
 * Date : 19/May/2021
 * Description : Landlord Service Layer
*/

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofr.entities.Landlord;
import com.cg.ofr.exception.LandlordNotFoundException;
import com.cg.ofr.repository.ILandlordRepository;

@Service
public class LandlordService implements ILandlordService{
	
	@Autowired
	private ILandlordRepository repository;

	static final  Logger LOGGER = LogManager.getLogger(LandlordService.class);
	
	/*
	 * MethodName  : addLandlord
	 * Description : Method will add new Landlord
	 * Input Arguments : Landlord Object 
	 * Return Value : Landlord Object 
	 */
	
	@Override
	public Landlord addLandlord(Landlord landlord) {
		Landlord ld =landlord;
		validateLandlord(ld);
		LOGGER.info("Business method addLandlord executed");
		return repository.save(landlord);
	} 

	/*
	 * MethodName  : updateLandlord
	 * Description : Method will update existing Landlord details
	 * Input Arguments : Landlord Object, Landlord Id(Primary key) int 
	 * Return Value : Landlord Object 
	 * Exception : LandlordNotFoundException
	 */
	
	@Override
	public Landlord updateLandlord(Landlord landlord, int id) throws LandlordNotFoundException{
		LOGGER.info("Business method updateLandlord initiated");
		Landlord ld =landlord;
		validateLandlord(ld);
		LOGGER.info("Business method updateLandlord executed");
		return repository.findById(id)
                .map(x -> {
                    x.setLandlordAge(landlord.getLandlordAge());
                    x.setLandlordName(landlord.getLandlordName());
                    x.setFlatList(landlord.getFlatList());
                    return repository.save(x);
                }).get();
		
	}

	/*
	 * MethodName  : deleteLandlord
	 * Description : Method will delete existing Landlord details
	 * Input Arguments : Landlord Id(Primary key) int 
	 * Return Value : Landlord Object 
	 * Exception : LandlordNotFoundException
	 */
	@Override
	public Landlord deleteLandlord(int id) throws LandlordNotFoundException{
		LOGGER.info("Business method deleteLandlord initiated");
		Landlord value=repository.findById(id).orElseThrow(()->new LandlordNotFoundException("Landlord with id "+id+" does not exist."));
		LOGGER.info("Business method deleteLandlord executed");
		repository.delete(value);
		return value;
	}

	/*
	 * MethodName  : viewLandlord
	 * Description : Method will show Landlord details according to their existing landlord id.
	 * Input Arguments : Landlord Id(Primary key) int 
	 * Return Value : Landlord Object 
	 * Exception : LandlordNotFoundException
	 */
	
	@Override	
	public Landlord viewLandlord(int id) throws LandlordNotFoundException{
		LOGGER.info("Business method viewLandlord initiated");
		Landlord value=repository.findById(id).orElseThrow(()->new LandlordNotFoundException("Landlord with id "+id+" does not exist."));
		LOGGER.info("Business method viewLandlord executed");
		return value;
	}

	/*
	 * MethodName  : viewAllLandlord
	 * Description : Method will show list of Landlord details. 
	 * Return Value : List<Landlord> Object 
	 */
	
	@Override
	public List<Landlord> viewAllLandlord() {
		LOGGER.info("Business method viewAllLandlord executed");
		return repository.findAll();
	}
	
	/*
	 * MethodName  : validateLandlordName
	 * Description : Method will validate Landlord's name. 
	 * Return Value : Boolean 
	 * Exception : LandlordNotFoundException
	 */
	
	static boolean validateLandlordName(String landlordName) throws LandlordNotFoundException {
		LOGGER.info("Landlord name validation started.");
		if (landlordName == null) {
			throw new LandlordNotFoundException("Landlord name cannot be null");
		} 
		else if (!landlordName.matches("^[A-Za-z][A-Za-z\\s]*$")) {
			if(landlordName.matches("^[\\s][A-Za-z\\s]*$")) {
				throw new LandlordNotFoundException("Landlord name cannot start with whitespace.");
			}
			throw new LandlordNotFoundException("Landlord name can only have alphabets.");
		} 
		else if (landlordName.length() < 3) {
			throw new LandlordNotFoundException("Landlord name at least have three alphabets");
		}
		else if (landlordName.length() > 40) {
			throw new LandlordNotFoundException("Landlord name can have at most forty alphabets");
		}
		LOGGER.info("Landlord name validate sucessfully.");
		return true;

	}

	/*
	 * MethodName  : validateLandlordAge
	 * Description : Method will validate Landlord's age. 
	 * Return Value : Boolean 
	 * Exception : LandlordNotFoundException
	 */
	
	static boolean validateLandlordAge(int landlordAge) throws LandlordNotFoundException {
		LOGGER.info("Landlord name validation started.");
		if (landlordAge <1) {
			throw new LandlordNotFoundException("Age cannot be 0 or negative.");
		}
		else if (landlordAge >100) {
			throw new LandlordNotFoundException("Age cannot be greater than 100.");
		}
		else if (landlordAge < 18) {
			throw new LandlordNotFoundException("Your age must be greater than or equal to 18 years.");
		} 
		LOGGER.info("Landlord age validate sucessfully.");
		return true;
	}
	
	/*
	 * MethodName  : validateLandlord
	 * Description : Method will validate Landlord details. 
	 * Return Value : Boolean 
	 * Exception : LandlordNotFoundException
	 */
	
	static boolean validateLandlord(Landlord landlord)throws LandlordNotFoundException {
		LOGGER.info("Landlord "+landlord.getLandlordId()+" details validation started.");
		if (landlord.equals(null)) {
			throw new LandlordNotFoundException("Landlord details cannot be empty.");
		}
		else {
			validateLandlordAge(landlord.getLandlordAge());
			validateLandlordName(landlord.getLandlordName());
			LOGGER.info("Validation Sucessfully done.");
		}
		return true;
	}

}