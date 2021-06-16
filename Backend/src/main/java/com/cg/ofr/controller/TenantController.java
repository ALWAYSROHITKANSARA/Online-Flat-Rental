package com.cg.ofr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ofr.entities.Tenant;
import com.cg.ofr.service.TenantService;

import java.util.List;

	//Description : This is Tenant Controller.

@RestController
@RequestMapping("/tenant")
@CrossOrigin(origins="http://localhost:3000")

public class TenantController {

	@Autowired
	private TenantService tenantService;
	
	/* ********************************************************************************************************
	 *  Method: addTenant
	 *  Description: It is used to add tenant details into tenant table
	 *  @param tenant: Tenant Object
	 *  @returns tenant It returns ResponseEntity with Tenant Object
	 *  @PostMapping: It is used to handle the HTTP POST requests matched with given URI expression.
	 *  @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 *  @exception: TenantNotFoundException
	 *  *******************************************************************************************************/

	@PostMapping(value = "/addTenant")
	public ResponseEntity<Tenant> addTenant(@RequestBody Tenant tenant) {
		return new ResponseEntity<>(tenantService.addTenant(tenant), HttpStatus.CREATED);

	}
	
	/* ***********************************************************************************************************
	 * Method: deleteTenant
	 * Description: It is used to remove tenant from tenant table
	 * @param id: integer tenantId
	 * @DeleteMapping: It is used to handle the HTTP DELETE requests matched with given URI expression.
	 * @PathVariable: integer id
	 * @exception: TenantNotFoundException
	 * ***********************************************************************************************************/
	
	@DeleteMapping(value = "/deletetenant/{tenantId}")
	public ResponseEntity<String> deleteTenant(@PathVariable int tenantId) {
		tenantService.deleteTenant(tenantId);
		ResponseEntity<String> retvalue = new ResponseEntity<String>(
				"Tenant with ID: " + tenantId + " successfully deleted.", HttpStatus.OK);
		return retvalue;
	}
	
	/* ***************************************************************************************************************
	 * Method: upadateTenant 
	 * Description: It is used to update tenant into tenant table
	 * @param tenant: Tenant Object, integer tenantID
	 * @PutMapping: It is used to handle the HTTP PUT requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * @exception: TenantNotFoundException
	 * ***************************************************************************************************************/
	
	@PutMapping(value = "/updateTenant/{tenantId}")
	public ResponseEntity<String> updateTenant(@PathVariable int tenantId, @RequestBody Tenant tenant) {
		Tenant value = tenantService.updateTenant(tenantId, tenant);
		ResponseEntity<String> retvalue = new ResponseEntity<String>(
				"Tenant with ID: " + value.getTenantId() + " successfully updated.", HttpStatus.ACCEPTED);
		return retvalue;
	}
	
	/* ****************************************************************************************************************
	 * Method: viewAlltenants
	 * Description: It is used to view all tenant details present in tenant table
	 * @returns tenant It returns all List<Tenant> Object with details
	 * @GetMapping: It is used to handle the HTTP GET requests matched with given URI expression.
	 * ****************************************************************************************************************/

	@GetMapping("/viewAllTenant")
	public ResponseEntity<List<Tenant>> viewAllTenant() {
		List<Tenant> allTenant = tenantService.viewAllTenant();
		ResponseEntity<List<Tenant>> entity = new ResponseEntity<List<Tenant>>(allTenant, HttpStatus.OK);
		return entity;
	}
	
	/* ******************************************************************************************************
	 * Method: viewTenant
	 * Description: It is used to view tenant from tenant table
	 * @param tenant: integer id
	 * @GetMapping: It is used to handle the HTTP GET requests matched with given URI expression.
	 * @PathVariable: integer tenantId
	 * @exception: TenantNotFoundException
	 * ******************************************************************************************************/
	
	@GetMapping("/tenant/{tenantId}")
	public ResponseEntity<Tenant> viewTenant(@PathVariable Integer tenantId) {
		Tenant value = tenantService.viewTenant(tenantId);
		ResponseEntity<Tenant> retvalue = new ResponseEntity<Tenant>( value,HttpStatus.OK);
		return retvalue;
	}
	
	/* ******************************************************************************************************
	 * Method: validateTenant
	 * Description: It is used to validate tenant from tenant table
	 * @PathVariable: integer tenantId
	 * @PatchMapping: It is used to handle the HTTP GET requests matched with given URI expression.
	 * @exception: TenantNotFoundException
	 * ******************************************************************************************************/

	@PatchMapping(value = "/validateTenant/{tenantId}")
	public ResponseEntity<String> validateTenant(@PathVariable int tenantId) {
		if (!tenantService.validateTenant(tenantId)) {
			ResponseEntity<String> retvalue = new ResponseEntity<String>("Tenant ID Not Matched.",
					HttpStatus.NOT_FOUND);
			return retvalue;
		} else {
			ResponseEntity<String> retvalue = new ResponseEntity<String>("Tenant ID Matched.", HttpStatus.ACCEPTED);
			return retvalue;
		}
	}
}
