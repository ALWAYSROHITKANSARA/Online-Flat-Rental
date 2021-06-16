package com.cg.ofr.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofr.entities.User;
import com.cg.ofr.exception.UserAlreadyExistsException;
import com.cg.ofr.exception.UserNotFoundException;
import com.cg.ofr.repository.IUserRepository;

/*************************************************************************************
 * Author : Rohit Kansara 
 * Version : 1.0
 * Date : 13-05-2021
 * Description : It is a user service class that provides the services to view user,view all users, validate user,add a user,
 *          	 remove a user, update the user, and update the password.
*************************************************************************************/


@Service
public class UserService implements IUserService {

	private static final Logger LOGGER = LogManager.getLogger(UserService.class);

	@Autowired
	private IUserRepository repo;

	/*************************************************************************************
	 * Method:                          	 -	addUser
     *Description:                        	 -	it is used to add the user details
	     *@param User                        -	it is User's reference variable.
		 *@returns User                  	 - 	it will return the user details
		 *@throws UserAlreadyExistsException -  It is raised due if username is already exists in database. 
     *Created By                         	 -  Rohit Kansara 
     *Created Date                        	 -  13-05-2021                           	 
	 *************************************************************************************/
	
	@Override
	public User addUser(User user) throws UserAlreadyExistsException {
		LOGGER.info("addUser() service is initiated");

		Optional<User> existUser = repo.findByUserName(user.getUserName());
		if (existUser.isPresent())
			throw new UserAlreadyExistsException("User Name already exists, Try anouther name");
		else
			validateaddUser(user);
		
		LOGGER.info("addUser() service has executed");
		return repo.save(user);
	}

	/*************************************************************************************
	 * Method:                          	updateUser
     *Description:                      	To update the user details.
	     *@param User                       it is User's reference variable.
		 *@returns User                  - 	it will return the user updated details.
		 *@throws UserNotFoundException  -  It is raised due to mismatch of user details. 
     *Created By                         -  Rohit Kansara 
     *Created Date                       -  15-05-2021                           	 
	 *************************************************************************************/
	
	@Override
	public User updateUser(User user) throws UserNotFoundException {
		LOGGER.info("updateUser() service is initiated");

		if (repo.existsById(user.getUserId())) {
			LOGGER.info("updateUser() service has executed");
			return repo.save(user);
		} else {
			throw new UserNotFoundException(user.getUserId() + " User not found");
		}
	}

	/*************************************************************************************
	 * Method:                          	updatePassword
     *Description:                      	To update the user password details.
	     *@param User                       it is User's reference variable.
	     *@param newpass					it is user's new password provided to change
		 *@returns User                  - 	it will return the user updated password details.
		 *@throws UserNotFoundException  -  It is raised due to mismatch of user details. 
     *Created By                         -  Rohit Kansara 
     *Created Date                       -  17-05-2021                           	 
	 *************************************************************************************/
	
	@Override
	public User updatePassword(User user, String newpass) throws UserNotFoundException {
		LOGGER.info("updatePassword() service is initiated");
		if (repo.existsById(user.getUserId())) {
			repo.findByUserName(user.getUserName()).map(x -> { x.setPassword(newpass);
			
			 return repo.save(x); 
			 });
			} 
		else {
				throw new UserNotFoundException("User not found...");
			}
		LOGGER.info("updatePassword() service has executed");
		return user;

	}

	/*************************************************************************************
	 * Method:                          	removeUser
     *Description:                      	To remove the user details.
	     *@param User                       it will remove users based on user details.
		 *@returns User                  - 	it will return the user updated details.
		 *@throws UserNotFoundException  -  It is raised due to mismatch of user details. 
     *Created By                         -  Rohit Kansara 
     *Created Date                       -  18-05-2021                           	 
	 *************************************************************************************/
	
	
	@Override
	
	public Boolean removeUser(Integer id) throws UserNotFoundException {
		LOGGER.info("removeUser() service is initiated");
		Optional<User> user = repo.findById(id);
		if (repo.existsById(id)) {
			repo.deleteById(id);
			LOGGER.info("removeUser() service is executed");
			return true;
		} else {
			throw new UserNotFoundException( " user does not exist.");
		}
	}

	/*************************************************************************************
	 * Method:                          	viewUser
     *Description:                      	To display the user by Id.
	     *@param id:                        id of the user.
		 *@returns User                  - 	if user with Id presents it returns user else throws UserNotFoundException
		 *@throws UserNotFoundException  -  It is raised due to invalid  UserId 
     *Created By                         -  Rohit Kansara 
     *Created Date                       -  18-05-2021                           	 
	 *************************************************************************************/	
	
	
	@Override
	public User viewUser(int id) throws UserNotFoundException {
		LOGGER.info("viewUser() service is initiated");
		return repo.findById(id)
				.orElseThrow(() -> new UserNotFoundException("User with id " + id + " does not exist."));
	}

	/**************************************************************************************
	 * Method:                          	viewAllUser
     *Description:                      	To display all the users by Id.
		 *@returns List<User>         - 	it displays all the user details
     *Created By                         -  Rohit Kansara 
     *Created Date                       -  19-05-2021                           	 
	 **************************************************************************************/
	
	
	@Override
	public List<User> viewAllUser() {
		LOGGER.info("viewAllUser() service is executed");
		return repo.findAll();
	}
	
	/*************************************************************************************
	 * Method:                          	validateUser
     *Description:                      	To check the user name and password is matching or not.
	     *@param username:                  user name for validating user.
	     *@param password:                  password for validating user.
		 *@returns Boolean               - 	it will check the user details matching successfully or not.
		 *@throws UserNotFoundException  -  It is raised due to mismatch of user details. 
     *Created By                         -  Rohit Kansara 
     *Created Date                       -  19-05-2021                           	 
	 *************************************************************************************/	
	

	@Override
	public boolean validateUser(String username, String password,String userType) throws UserNotFoundException {
		LOGGER.info("validateUser() service is initiated");
		boolean flag = false;

		Optional<User> user = repo.findByUserName(username);

		if (user == null)
			throw new UserNotFoundException("Please check User Name");

		else if (password.equals(user.get().getPassword()) && userType.equals(user.get().getUserType()))
			flag = true;
		else
			throw new UserNotFoundException("Please check password");
		LOGGER.info("validateUser() service has executed");
		return flag;
	}
	
	/*************************************************************************************
	 * Method:                          	checkValidUser
     *Description:                      	this method is create to check for login page's authentication.
	     *@param username:                  user name for validating user.
	     *@param password:                  password for validating user.
		 *@returns boolean                  - 	it will check the user details matching successfully or not. 
     *Created By                         -  Rohit Kansara 
     *Created Date                       -  15-05-2021                           	 
	 *************************************************************************************/
	
	public boolean checkValidUser(String username, String password, String userType) {
		LOGGER.info("checkValidUser() Method has initiated");
		boolean flag = false;
		Optional<User> user = repo.findByUserName(username);
		if(user.isPresent()) {
			flag = validateUser(user.get().getUserName(),password,userType);
			LOGGER.info("checkValidUser() service has executed");
			return flag;
		}
		else {
			return flag;
		}
	}
	
	
	
	/*
	 ***************************** Validation part*****************************
	 */
	
	
	/*************************************************************************************
	 * Method:                          	validateUsername
     *Description:                      	To check the user name is in given format or not.
	     *@param username:                  user name for adding user.
		 *@returns boolean               - 	it will check the user name is in valid format or not
		 *@throws UserNotFoundException  -  It is raised due to mismatch of user details. 
     *Created By                         -  Rohit Kansara 
     *Created Date                       -  13-05-2021                           	 
	 *************************************************************************************/
	public static boolean validateUsername(String userName) throws UserNotFoundException{  		
		LOGGER.info("validateUsername() Method has initiated");
		boolean flag = false;
		if(userName == null) {
			throw new UserNotFoundException("User Name cannot be empty");
			}
		else if(!userName.matches("^[a-zA-Z]+$")) {
			throw new UserNotFoundException(usernameformat);
			}
		else if(userName.length()<3 || userName.length()>30) {
			throw new UserNotFoundException("User Name length must be in range 3 to 30");
		}
		else {
			flag = true;
		}
		LOGGER.info("validateUsername() service has executed");
		return flag;
    }	
	
	
	/*************************************************************************************
	 * Method:                          	validateUserType
     *Description:                      	To check the user type is in given format or not.
	     *@param userType:                  user type for adding user.
		 *@returns boolean               - 	it will check the user type is in valid or not
		 *@throws UserNotFoundException  -  It is raised due to mismatch of user details. 
     *Created By                         -  Rohit Kansara 
     *Created Date                       -  13-05-2021                           	 
	 *************************************************************************************/
	
	
	public static boolean validateUserType(String userType) throws UserNotFoundException
	{
		LOGGER.info("validateUserType() Method has initiated");
		boolean flag = false;
		if(userType == null) {
			throw new UserNotFoundException("User Type cannot be blank");
			}
		else if (!userType.matches("^[A-Za-z]+$")) {
			throw new UserNotFoundException("User Type cannot contain numbers or special characters");
			}
		else if (!(userType.equals("tenant") || userType.equals("landlord") || userType.equals("admin")
				|| userType.equals("Tenant") || userType.equals("Landlord") || userType.equals("Admin")
				|| userType.equals("TENANT") || userType.equals("LANDLORD") || userType.equals("ADMIN"))) {
			throw new UserNotFoundException("User Type can only be Admin or Tenant or Landlord");
		}
		else {
			flag = true;
		}
		LOGGER.info("validateUserType() service has executed");

		return flag;
	}
	
	
	/*************************************************************************************
	 * Method:                          	validatePassword
     *Description:                      	To check the password is following regex pattern or not.
	     *@param password:                  password for adding user.
		 *@returns boolean               - 	it will check the password is in valid or not
		 *@throws UserNotFoundException  -  It is raised due to mismatch of password. 
     *Created By                         -  Rohit Kansara 
     *Created Date                       -  13-05-2021                           	 
	 *************************************************************************************/
	
	/*
	 * regex = “^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,15}$”
		
		^                 # start-of-string
		(?=.*[0-9])       # a digit must occur at least once
		(?=.*[a-z])       # a lower case letter must occur at least once
		(?=.*[A-Z])       # an upper case letter must occur at least once
		(?=.*[@#$%^&+=])  # a special character must occur at least once
		(?=\S+$)          # no whitespace allowed in the entire string
		.{8,15}           # anything, at least eight places though
		$                 # end-of-string
	 */	
	
	public static boolean validatePassword(String password) throws UserNotFoundException
    {  
		LOGGER.info("validatePassword() Method has initiated");

		boolean flag = false;
		if(password == null) {
			throw new UserNotFoundException("Password cannot be empty");
		}
		else if(!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,15}$")) {
			throw new UserNotFoundException(passformat);
		}
		else {
			flag = true;
		}
		LOGGER.info("validatePassword() service has executed");

		return flag;
    }
	
	/*************************************************************************************
	 * Method:                          	validateaddUser
     *Description:                      	To check the user details is in proper format or not while creating new user.
	     *@param user:                 		user type for adding user.
		 *@returns boolean               - 	it will check the user is in valid or not
		 *@throws UserNotFoundException  -  It is raised due to mismatch of user details. 
     *Created By                         -  Rohit Kansara 
     *Created Date                       -  13-05-2021                           	 
	 *************************************************************************************/
	
	
	public static boolean validateaddUser(User user) throws UserNotFoundException {
		LOGGER.info("validateaddUser() Method has initiated");

		boolean flag = false;
		if(user == null) {
			throw new UserNotFoundException("User details cannot be blank");
		}
		else {
			validateUsername(user.getUserName());
			validatePassword(user.getPassword());
			validateUserType(user.getUserType());
			flag = true;
		}
		LOGGER.info("validatePassword() service has executed");
		return flag;
		
	}
	
	/*************************************************************************************
	 * String:                          	passformat
     *Description:                      	String which is displayed if password format is not followed.
     *Created By                         -  Rohit Kansara 
     *Created Date                       -  13-05-2021                           	 
	 *************************************************************************************/
	
	
	
	static String passformat ="Format for password is Wrong\r\n"
			+ "\r\n"
			+ "Please Enter Password Again\r\n"
			+ "\r\n"
			+ "Password cannot be empty\\r\\n"
			+ "Password must contain at least one digit [0-9].\r\n"
			+ "Password must contain at least one lowercase Latin character [a-z].\r\n"
			+ "Password must contain at least one uppercase Latin character [A-Z].\r\n"
			+ "Password must contain at least one special character like ! $ @ % ^ # & + = ( ).\r\n"
			+ "Password must contain a length of at least 8 characters and a maximum of 20 characters."
			+ ""  ;

	/*************************************************************************************
	 * String:                          	usernameformat
     *Description:                      	String which is displayed if username format is not followed.
     *Created By                         -  Rohit Kansara 
     *Created Date                       -  13-05-2021                           	 
	 *************************************************************************************/
	
	static String usernameformat ="Format For UserName is Wrong\r\n"
			+ "\r\n"
			+ "Please Enter Again :\r\n"
			+ "____________________________________________________________\r\n"
			+ "\r\n"
			+ "Valid Format for UserName:\r\n"
			+ "\r\n"
			+ "The first character of the username must be an alphabetic character, i.e., either lowercase character\r\n"
			+ "[a – z] or uppercase character [A – Z].\r\n"
			+ "User Name length should be in range 3 to 30."
			+ "\r\n";



}
