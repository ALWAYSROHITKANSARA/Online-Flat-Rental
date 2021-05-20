package com.cg.ofr.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofr.entities.Tenant;
import com.cg.ofr.exception.TenantNotFoundException;
import com.cg.ofr.repository.ITenantRepository;
import java.util.Optional;

/*Description : This is Tenant Service Layer that provides services to Add New User, Update Existing User,
  				 Delete Existing User, View Existing User and View All Existing Users*/

@Service
public class TenantService implements ITenantService {
	
	 private static final Logger logger = LogManager.getLogger(TenantService.class);

	@Autowired
	private ITenantRepository tenantRepository;
	
	/*
	 * Description : This method Adds new Tenant
	 * Input Parameter : Tenant Object 
	 * Return Value : Tenant Object 
	 * Exception : TenantNotFoundException
	 */
	
	@Override
	public Tenant addTenant(Tenant tenant) {
		logger.info("Called addTenant() method of TenantService");
		return tenantRepository.save(tenant);
	}
	
	/*
	 * Description : This method Updates existing Tenant
	 * Input Parameter : Tenant Object, integer tenantId 
	 * Return Value : Tenant Object 
	 * Exception : TenantNotFoundException
	 */

	@Override
	public Tenant updateTenant(int tenantId, Tenant tenant) throws TenantNotFoundException {
		logger.info("Called updateTenant() method of TenantService");
		Tenant value = tenantRepository.findById(tenantId)
				.orElseThrow(() -> new TenantNotFoundException("Tenant with ID: " + tenantId + " does not exist."));
		value.setTenantName(tenant.getTenantName());
		value.setAge(tenant.getAge());
		return tenantRepository.save(value);
	}
	
	/*
	 * Description : This method Deletes existing Tenant
	 * Input Parameter : integer tenantId
	 * Return Value : Tenant Object 
	 * Exception : TenantNotFoundException
	 */

	@Override
	public void deleteTenant(int tenantId) throws TenantNotFoundException {
		logger.info("Called deleteTenant() method of TenantService");
		Tenant value = tenantRepository.findById(tenantId)
				.orElseThrow(() -> new TenantNotFoundException("Tenant with id " + tenantId + " does not exist."));
		tenantRepository.delete(value);
	}
	
	/*
	 * Description : This method Shows existing Tenant
	 * Input Parameter : integer tenantId
	 * Return Value : Tenant Object 
	 * Exception : TenantNotFoundException
	 */

	@Override
	public Tenant viewTenant(int tenantId) throws TenantNotFoundException {
		logger.info("Called viewTenant() method of TenantService");
		return tenantRepository.findById(tenantId).orElseThrow(
				() -> new TenantNotFoundException("Tenant With Given Id :" + tenantId + " Not Available!"));

	}
	
	/*
	 * Description : This method Shows all existing Tenants 
	 * Return Value : List<Tenant>
	 */

	@Override
	public List<Tenant> viewAllTenant() {
		logger.info("Called viewAllTenant() method of TenantService");
		return tenantRepository.findAll();
	}
	
	/*
	 * Description : This method validates the Tenant
	 * Return Value(boolean) : Shows True if the object is present, shows false if the object is not present.
	 */

	@Override
	public boolean validateTenant(int tenantId) throws TenantNotFoundException {
		logger.info("Called validateTenant() method of TenantService");
		boolean flag = false;

		Optional<Tenant> tenant = tenantRepository.findById(tenantId);

		if (tenant == null)
			throw new TenantNotFoundException("Please check Tenant Id");
		else if (tenant.isPresent()) {
			flag = true;
		}

		else
			throw new TenantNotFoundException("Please check Tenant ID");

		return flag;
	}

}
