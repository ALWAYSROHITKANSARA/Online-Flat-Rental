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
		value.setFlatCost(flat.getFlatCost());
		value.setFlatAvailability(flat.getFlatAvailability());
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

	

	
}
