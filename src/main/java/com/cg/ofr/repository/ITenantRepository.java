package com.cg.ofr.repository;

import org.springframework.stereotype.Repository;
import com.cg.ofr.entities.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * Author : Dhanireddy Yathin Vamsi Eswar Reddy
 * Version : 1.0
 * Date : 13-05-2021
 * Description : This is Tenant Repository.
*/

@Repository
public interface ITenantRepository extends JpaRepository<Tenant, Integer> {

	}
	
