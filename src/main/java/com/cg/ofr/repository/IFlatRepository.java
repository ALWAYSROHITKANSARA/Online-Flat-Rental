package com.cg.ofr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ofr.entities.Flat;

/*
 * Author : Amol Ajay Gokhale
 * Version : 1.0
 * Date : 13-05-2021
 * Description : This is Landlord Repository.
*/

@Repository
public interface IFlatRepository extends JpaRepository<Flat, Integer> {

}
