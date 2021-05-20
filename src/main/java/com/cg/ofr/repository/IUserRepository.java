package com.cg.ofr.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.ofr.entities.User;

/*
 * Author : Rohit Kansara
 * Version : 1.0
 * Date : 13-05-2021
 * Description : This is User Repository.
*/

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByUserName(String username);
	
	@Query("select u from User u where u.userId = ?1 and u.userName = ?2" )
	Optional<User> findByIdAndName(int id, String username);
}
