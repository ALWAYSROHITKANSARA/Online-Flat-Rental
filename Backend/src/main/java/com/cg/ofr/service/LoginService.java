package com.cg.ofr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofr.entities.User;
import com.cg.ofr.exception.LoginException;
import com.cg.ofr.exception.UserAlreadyExistsException;
import com.cg.ofr.exception.UserNotFoundException;


/*************************************************************************************
 * Author : Rohit Kansara 
 * Version : 1.0
 * Date : 15-05-2021
 * Description : It is a Login service class that provides the authentication to valid user.
*************************************************************************************/

@Service
public class LoginService implements ILoginService {

	@Autowired
	UserService service;

	/*************************************************************************************
	 * Method:                          	 -	login
     *Description:                        	 -	it is used to add the user details
	     *@param username                    -	user name provided by user.
	     *@param password					 -	password provide by user.
		 *@returns boolean                  	 - 	it will return the user details
		 *@throws UserNotFoundException		 -  It is raised due if username is not available in database.
		 *@throws LoginException			 -  It is raised due if username and password is not matched.
     *Created By                         	 -  Rohit Kansara 
     *Created Date                        	 -  15-05-2021                           	 
	 *************************************************************************************/
	
	@Override
	public boolean login(String username, String password, String userType) throws LoginException, UserNotFoundException {
		boolean flag = false;

		if (username == null) {
			flag = false;
		}
		if (!service.checkValidUser(username,password,userType)) {
			flag = false;
		} else {
			flag = true;
		}
		return flag;
	}

}
