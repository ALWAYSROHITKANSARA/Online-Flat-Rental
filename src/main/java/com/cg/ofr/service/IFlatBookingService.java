package com.cg.ofr.service;

import java.util.List;

import com.cg.ofr.entities.Flat;
import com.cg.ofr.entities.FlatBooking;
import com.cg.ofr.exception.FlatBookingNotFoundException;

public interface IFlatBookingService {
	public FlatBooking addFlatBooking(FlatBooking flat) ;
	public FlatBooking updateFlatBooking(FlatBooking flat,int id) throws FlatBookingNotFoundException;
	public void deleteFlatBooking(int id) throws FlatBookingNotFoundException;
	public FlatBooking viewFlatBooking(int id) throws FlatBookingNotFoundException;
	public List<FlatBooking> viewAllFlatBooking();
}
