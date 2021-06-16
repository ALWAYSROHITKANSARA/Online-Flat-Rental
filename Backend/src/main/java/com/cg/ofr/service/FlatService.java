package com.cg.ofr.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofr.entities.Flat;
import com.cg.ofr.exception.FlatNotFoundException;
import com.cg.ofr.repository.IFlatRepository;



  //Description : This is Flat Service Layer


@Service
public class FlatService implements IFlatService{
	 private static final Logger logger = LogManager.getLogger(FlatService.class);
	@Autowired
	private IFlatRepository flatRepository;

	//Description : This method Adds new Flat : Input Parameter 
	@Override
	public Flat addFlat(Flat flat) {
		logger.info("Business method addFlat initiated");
		//validateFlat(flat);
		Flat fl=flatRepository.save(flat);
		logger.info("Business method addFlat executed");
		return fl;
	}
	
	/*
	 * Description : This method Updates existing Flat :Input Parameter 
	 *               Throws Exception if the flat is not found as FlatNotFoundException	
	 */

	@Override	
	public Flat updateFlat(Integer id , Flat flat) throws FlatNotFoundException{
		logger.info("Business method updateFlat initiated");
		Flat value=flatRepository.findById(id).orElseThrow(()->new FlatNotFoundException("Flat with id "+id+" does not exist."));
		validateFlat(flat);
		value.setFlatCost(flat.getFlatCost());
		value.setFlatAvailability(flat.getFlatAvailability());
		value.setFlatAddress(flat.getFlatAddress());
		logger.info("Business method updateFlat executed");
		return flatRepository.save(value);
	}
	
	/*
	 * Description : This method Deletes existing Flat :Input Parameter 
	 *               Throws Exception if the flat is not found as FlatNotFoundException
	 */	

	@Override	
	public void deleteFlat(Integer id) throws FlatNotFoundException{
		logger.info("Business method deleteFlat initiated");
		Flat value=flatRepository.findById(id).orElseThrow(()->new FlatNotFoundException("Flat with id "+id+" does not exist."));
		logger.info("Business method deleteFlat executed");
		flatRepository.delete(value);
	}
	
	/*
	 * Description : This method shows existing flat by taking ID :Input Parameter as FlatId 
	 *               Throws Exception if the flat is not found as FlatNotFoundException
	 */	

	@Override
	public Flat viewFlatById(Integer id) throws FlatNotFoundException {
		logger.info("Business method viewFlatById initiated");
		return flatRepository.findById(id).orElseThrow(()->new FlatNotFoundException("Flat With Given Id :"+id+" Not Available!"));
	}
	
	/*
	 * Description : This method Displays all Flats :Input Parameter 
	 */	

	
	@Override
	public List<Flat> getAllFlats() {
		logger.info("Business method getAllFlats initiated");
		return flatRepository.findAll();
	}

	
	public static boolean validateFlat(Flat flat) throws FlatNotFoundException {
		logger.info("validateFlat() is initiated");
		boolean flag = false;
		if (flat == null) {
			logger.error("Flat details cannot be blank");
			throw new FlatNotFoundException("Flat details cannot be blank");
		} else {
			validateFlatHouseNo(flat.getFlatAddress().getHouseNo());
			validateFlatStreet(flat.getFlatAddress().getStreet());
			validateFlatCity(flat.getFlatAddress().getCity());
			validateFlatState(flat.getFlatAddress().getState());
			validateFlatCountry(flat.getFlatAddress().getCountry());
			validateFlatPin(flat.getFlatAddress().getPin());
			validateFlatCost(flat.getFlatCost());
			validateFlatAvailability(flat.getFlatAvailability());
			flag = true;
			logger.info("validation Successful");
		}
		logger.info("validateCost() has executed");
		return flag;
	}

	public static boolean validateFlatCost(float cost) throws FlatNotFoundException {
		logger.info("validateFlatCost() is initiated");
		boolean flag = false;
		if (cost > 0f) {
			flag = true;
			logger.info("validation Successful");
		} else {
			logger.error("Cost cannot be 0 or a negative number");
			throw new FlatNotFoundException("Cost cannot be 0 or a negative number");
		}
		logger.info("validateFlatCost() has executed");
		return flag;
	}

	public static boolean validateFlatAvailability(String availability) throws FlatNotFoundException {
		logger.info("validateFlatAvailability() is initiated");
		boolean flag = false;
		if ((availability.isBlank()))
			throw new FlatNotFoundException("Availability cannot be empty");
		if (availability.equals("YES") || availability.equals("Yes") || availability.equals("NO")
				|| availability.equals("No") || availability.equals("no") || availability.equals("n")
				|| availability.equals("N") || availability.equals("yes") || availability.equals("y")
				|| availability.equals("Y") ||availability.equals("default")){
			{
				flag = true;
				logger.info("validationSuccessful");
			}
		} else {
			logger.error("Availabilty can only be [YES | NO | Yes | No | Y | N | y | n]");
			throw new FlatNotFoundException("Availabilty can only be [YES | NO | Yes | No | Y | N | y | n]");
		}
		logger.info("validateFlatAvailability() has executed");
		return flag;
	}

	public static boolean validateFlatHouseNo(int houseNo) throws FlatNotFoundException {
		logger.info("validateFlatHouseNo() is initiated");
		boolean flag = false;
		if (!(Long.toString(houseNo).isEmpty()) && houseNo > 0) {
			flag = true;
			logger.info("validation Successful");
		} else {
			logger.error("HouseNo  cannot be empty or 0 or a negative number");
			throw new FlatNotFoundException("HouseNo cannot be empty or 0 or a negative number");
		}
		logger.info("validateFlatHouseNo() has executed");
		return flag;
	}

	public static boolean validateFlatStreet(String street) throws FlatNotFoundException {
		logger.info("validateFlatStreet() is initialised");
		boolean flag = false;
		if ((street.isEmpty())) {
			logger.error("Street name cannot be empty");
			throw new FlatNotFoundException("Street name cannot be empty");
		} else if (!street.matches("^[a-zA-Z0-9 ]+$")) {
			logger.error("Street cannot contain Special Characters");
			throw new FlatNotFoundException("Street cannot contain Special Characters");
		} else {
			flag = true;
			logger.info("validation Successful");
		}
		logger.info("validateFlatStreet() has executed");
		return flag;
	}

	public static boolean validateFlatCity(String city) throws FlatNotFoundException {
		logger.info("validateFlatCity() is initialised");
		boolean flag = false;
		if ((city.isEmpty())) {
			logger.error("City name cannot be empty");
			throw new FlatNotFoundException("City name cannot be empty");
		} else if (!city.matches("^[a-zA-Z ]+$")) {
			logger.error("City cannot contain Numbers or Special Characters");
			throw new FlatNotFoundException("City cannot contain Numbers or Special Characters");
		} else {
			flag = true;
			logger.info("validation Successful");
		}
		logger.info("validateFlatCity() has executed");
		return flag;
	}

	public static boolean validateFlatState(String state) throws FlatNotFoundException {
		logger.info("validateFlatState() is initialised");
		boolean flag = false;
		if ((state.isEmpty())) {
			logger.error("State name cannot be empty");
			throw new FlatNotFoundException("State name cannot be empty");
		} else if (!state.matches("^[a-zA-Z ]+$")) {
			logger.error("State cannot contain Numbers or Special Characters");
			throw new FlatNotFoundException("State cannot contain Numbers or Special Characters");
		} else {
			flag = true;
			logger.info("validation Successful");
		}
		logger.info("validateFlatState() has executed");
		return flag;
	}

	public static boolean validateFlatCountry(String country) throws FlatNotFoundException {
		logger.info("validateFlatCountry() is initiated");
		boolean flag = false;
		if (country.isEmpty()) {
			logger.error("Country name cannot be empty");
			throw new FlatNotFoundException("Country name cannot be empty");
		} else if (!country.matches("^[a-zA-Z ]+$")) {
			logger.error("Country cannot contain Numbers or Special Characters");
			throw new FlatNotFoundException("Country cannot contain Numbers or Special Characters");
		} else {
			flag = true;
			logger.info("validation Successful");
		}
		logger.info("validateFlatCountry() has executed");
		return flag;
	}

	public static boolean validateFlatPin(long pin) throws FlatNotFoundException {
		logger.info("validateFlatPin() is initiated");
		boolean flag = false;
		if (pin <= 0) {
			logger.error("PinCode cannot be 0 or negative");
			throw new FlatNotFoundException("PinCode cannot be 0 or negative");
		} else if (Long.toString(pin).length() != 6) {
			logger.error("PinCode should be length 6");
			throw new FlatNotFoundException("PinCode should be length 6");
		} else if (!Long.toString(pin).matches("^[0-9]+$")) {
			logger.error("PinCode cannot contain any Characters");
			throw new FlatNotFoundException("PinCode cannot contain any Characters");
		} else {
			flag = true;
			logger.info("validation Successful");
		}
		logger.info("validateFlatPin() has executed");
		return flag;
	}

	

	
}