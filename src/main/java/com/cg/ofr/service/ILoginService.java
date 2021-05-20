package com.cg.ofr.service;

import com.cg.ofr.entities.User;
import com.cg.ofr.exception.LoginException;
import com.cg.ofr.exception.UserNotFoundException;

public interface ILoginService  {

	public boolean login(String username, String password)throws LoginException, UserNotFoundException;

	//public boolean login(User user) throws LoginException, UserNotFoundException;
}
