package com.cg.ofr.service;

import java.util.List;

import com.cg.ofr.entities.User;
import com.cg.ofr.exception.UserNotFoundException;

public interface IUserService {
	public User addUser(User user);
	public User updateUser(User user) throws UserNotFoundException;
	public User updatePassword(User user,String newpass) throws UserNotFoundException;
	public User removeUser(User user) throws UserNotFoundException;
	public User viewUser(int id) throws UserNotFoundException;
	public List<User> viewAllUser();
	public boolean validateUser(String username,String password) throws UserNotFoundException;
}
