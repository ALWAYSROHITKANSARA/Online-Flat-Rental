package com.cg.ofr.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ofr.entities.User;
import com.cg.ofr.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;

/*************************************************************************************
 * Author : Rohit Kansara
 * Version : 1.0
 * Date : 13
 * 13-05-2021
 * Description : This is User Controller.
*************************************************************************************/

@RestController
@RequestMapping(value="/user")
@CrossOrigin(origins="http://localhost:8080")
@Api(value="users")
public class UserController {
	
    private static final Logger LOGGER = LogManager.getLogger(UserService.class);


	@Autowired
	private UserService service;
	
	/************************************************************************************
	 * Method: addUser 
	 * Description: It is used to add user into users table
	 * @param user: user's reference variable.
	 * @returns user It returns user with details
	 * @PostMapping: It is used to handle the HTTP POST requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * Created By- Rohit Kansara
     * Created Date -  13-05-2021 
	 * 
	 ************************************************************************************/
	
	@PostMapping(value="/addUser")
	public ResponseEntity<String> addUser(@RequestBody User user){
		LOGGER.info("add-user URL is opened");
		LOGGER.info("addUser() is initiated");
		
		User usr = service.addUser(user);
		ResponseEntity<String> rentity = new ResponseEntity<String>("User with ID: "+usr.getUserId()+" Created Successfully.",HttpStatus.CREATED);
		LOGGER.info("addUser() has executed");
		return rentity;
	}

	/************************************************************************************
	 * Method: updateUser 
	 * Description: It is used to update user into users table
	 * @param user: user's reference variable.
	 * @returns user It returns user with details
	 * @PutMapping: It is used to handle the HTTP PUT requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * Created By- Rohit Kansara
     *Created Date -  15-05-2021 
	 * 
	 ************************************************************************************/
	
	@PutMapping(value= "/updateUser")
	public ResponseEntity<String> updateUser(@RequestBody User user){
		LOGGER.info("update-user URL is opened");
		LOGGER.info("updateUser() is initiated");
		
		User usr = service.updateUser(user);
		ResponseEntity<String> retvalue = new ResponseEntity<String>("User with ID: "+usr.getUserId()+" sucessfully updated.",HttpStatus.ACCEPTED);
		LOGGER.info("updateUser() has executed");
		return retvalue;
	}
	
	/************************************************************************************
	 * Method: updatePassword 
	 * Description: It is used to update password into users table
	 * @param user: user's reference variable, String newpass
	 * @returns user It returns user with details
	 * @PatchMapping: It is used to handle the HTTP PATCH request which is used to change in single entry in database.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * Created By- Rohit Kansara
     *Created Date -  17-05-2021 
	 * 
	 ************************************************************************************/
	
	@PatchMapping(value= "/updatePassword/{newpass}")
	public ResponseEntity<String> updatePassword(@RequestBody User user,@PathVariable String newpass){
		User usr = service.updatePassword(user, newpass);
		ResponseEntity<String> retvalue = new ResponseEntity<String>("User with ID's password is: "+usr.getUserId()+" sucessfully updated.",HttpStatus.ACCEPTED);
		return retvalue;
	}
	
	/************************************************************************************
	 * Method: removeUser 
	 * Description: It is used to remove user from users table
	 * @param user: user's reference variable
	 * @returns user It returns user with details
	 * @DeleteMapping: It is used to handle the HTTP DELETE requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * Created By- Rohit Kansara
     *Created Date -  18-05-2021 
	 * 
	 ************************************************************************************/

	@DeleteMapping(value = "/removeUser")
	public ResponseEntity<String> removeUser(@RequestBody User user){
		User value = service.removeUser(user);
		ResponseEntity<String> retvalue = new ResponseEntity<String>("User with ID: "+value.getUserId()+" sucessfully deleted.",HttpStatus.OK);

		return retvalue;

	}
	
	
	/************************************************************************************
	 * Method: viewUserById 
	 * Description: It is used to view user by id from users table
	 * @param user: int id
	 * @returns user It returns user with details
	 * @GetMapping: It is used to handle the HTTP GET requests matched with given URI expression.
	 * Created By- Rohit Kansara
     *Created Date -  18-05-2021 
	 * 
	 ************************************************************************************/
	
	@GetMapping(value = "/viewUserByID/{id}")
	
	public ResponseEntity<User> viewUser(@PathVariable Integer id) {
		User value = service.viewUser(id);
		ResponseEntity<User> retvalue = new ResponseEntity<User>(value, HttpStatus.OK);
		return retvalue;
	}
	
	/************************************************************************************
	 * Method: getAllUsers 
	 * Description: It is used to view all users in users table
	 * @returns user It returns user with details
	 * @GetMapping: It is used to handle the HTTP GET requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * Created By- Rohit Kansara
     *Created Date -  19-05-2021 
	 * 
	 ************************************************************************************/
	
	@GetMapping(value = "/viewAllUser")
	public ResponseEntity<List<User>> viewAllUser() {
		List<User> list = service.viewAllUser();
		ResponseEntity<List<User>> retvalue = new ResponseEntity<List<User>>(list, HttpStatus.OK);
		return retvalue;
	}
	
	/************************************************************************************
	 * Method: validateUser 
	 * Description: It is used to validate user in users table
	 * @param user: String userName, String password
	 * @returns user It returns user with details
	 * @PatchMapping: It is used to handle the HTTP PATCH requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * Created By- Rohit Kansara
     *Created Date -  19-05-2021 
	 * 
	 ************************************************************************************/
	
	@PatchMapping(value="/validateUser/{userName}/{password}")
	public ResponseEntity<String> validateUser(@PathVariable String userName ,@PathVariable String password){
		if(!service.validateUser(userName,password)) {
			ResponseEntity<String> retvalue = new ResponseEntity<String>("User and Password Not Matched.",HttpStatus.UNAUTHORIZED);
			return retvalue;
		}
		else {
			ResponseEntity<String> retvalue = new ResponseEntity<String>("User and Password Matched.",HttpStatus.ACCEPTED);
			return retvalue;
		}
	}
	
	
}
