package com.cg.ofr.service;

import java.util.List;

import com.cg.ofr.entities.User;
import com.cg.ofr.exception.UserNotFoundException;

public interface IUserService {
	public User addUser(User user);
	public User updateUser(User user) throws UserNotFoundException;
	public User updatePassword(User user,String newpass) throws UserNotFoundException;
	//public User removeUser(User user) throws UserNotFoundException;
	public User viewUser(int id) throws UserNotFoundException;
	public List<User> viewAllUser();
	public boolean validateUser(String username,String password,String UserType) throws UserNotFoundException;
	/*************************************************************************************
	 * Method:                          	removeUser
	 *Description:                      	To remove the user details.
	     *@param User                       it will remove users based on user details.
		 *@returns User                  - 	it will return the user updated details.
		 *@throws UserNotFoundException  -  It is raised due to mismatch of user details. 
	 *Created By                         -  Rohit Kansara 
	 *Created Date                       -  18-05-2021                           	 
	 *************************************************************************************/
	Boolean removeUser(Integer id) throws UserNotFoundException;
}
