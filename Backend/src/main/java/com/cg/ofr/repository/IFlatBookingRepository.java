package com.cg.ofr.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ofr.entities.FlatBooking;
import com.cg.ofr.exception.FlatBookingNotFoundException;

/*
 * Author : Kanagarla Akhil
 * Version : 1.0
 * Date : 13-05-2021
 * Description : This is Landlord Repository.
*/

@Repository
public interface IFlatBookingRepository extends JpaRepository<FlatBooking, Integer>{
	

}
