package com.cg.ofr.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ofr.entities.User;
import com.cg.ofr.service.ILoginService;
import com.cg.ofr.service.UserService;

import io.swagger.annotations.Api;

/*************************************************************************************
 * Author : Rohit Kansara
 * Version : 1.0
 * Date : 13
 * 13-05-2021
 * Description : This is Login Controller.
*************************************************************************************/

@RestController
@RequestMapping(value = "/login")
@CrossOrigin(origins="http://localhost:8080")
@Api(value = "login")

public class LoginController {

	@Autowired
	private ILoginService service;

    private static final Logger LOGGER = LogManager.getLogger(UserService.class);
	
	/************************************************************************************
	 * Method: login 
	 * Description: It is used to authenticate user
	 * @returns user It returns user with details
	 * @GetMapping: It is used to handle the HTTP GET requests matched with given URI expression.
	 * @PathVariable: User to get data from URL.
	 * Created By- Rohit Kansara
     *Created Date -  13-05-2021 
	 * 
	 ************************************************************************************/
    
    
	@GetMapping(value = "/authenticateUser/{username}/{password}")

	public ResponseEntity<String> login(@PathVariable String username, @PathVariable String password) {
		ResponseEntity<String> rentity;
		if (service.login(username,password)) {
			rentity = new ResponseEntity<String>("Login Successful.", HttpStatus.ACCEPTED);
		} else {
			rentity = new ResponseEntity<String>("Login Failed.", HttpStatus.UNAUTHORIZED);
		}
		return rentity;
	}
}
