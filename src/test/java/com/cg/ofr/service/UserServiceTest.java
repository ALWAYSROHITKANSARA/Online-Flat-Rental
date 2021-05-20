package com.cg.ofr.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.ofr.entities.User;
import com.cg.ofr.exception.UserAlreadyExistsException;
import com.cg.ofr.exception.UserNotFoundException;
import com.cg.ofr.repository.IUserRepository;

@SpringBootTest
public class UserServiceTest {

	@Autowired
	private UserService service;

	@MockBean
	private IUserRepository repo;

	private static final Logger logger = LogManager.getLogger(UserService.class);

	User u1;
	User u2;
	User u3;
	User u4;
	User u5;
	Optional<User> u;

	@BeforeEach
	public void init() {
		u1 = new User(1, "Rohit", "Rohit@1234", "tenant");
		u2 = new User(2, "Aadi", "5696", "tenant");
		u3 = new User(3, "Shyam", "7589", "landlord");
		u4 = new User(4, "Seema", "5632", "admin");

		u5 = new User(5, "Aadi Kumar", "Aadi@1233", "tenant");

		u = Optional.of(u1);

	}

	@Test
	public void testAddUser() {
		when(repo.save(u1)).thenReturn(u1);
		assertEquals(u1.getUserId(), service.addUser(u1).getUserId());
		assertEquals(u1.getUserName(), service.addUser(u1).getUserName());
		assertEquals(u1.getPassword(), service.addUser(u1).getPassword());
		assertEquals(u1.getUserType(), service.addUser(u1).getUserType());

	}

	@Test
	public void testAddUser1() throws UserAlreadyExistsException {
		when(repo.findByUserName(u1.getUserName())).thenReturn(u);
		try {
			service.addUser(u1);
		} catch (UserAlreadyExistsException exception) {
			assertEquals("User Name already exists, Try anouther name", exception.getMessage());
		}
	}


	@Test
	public void testUpdateUser() {
		when(repo.existsById(u2.getUserId())).thenReturn(true);
		when(repo.save(u2)).thenReturn(u2);
		assertEquals(u2.getUserId(), service.updateUser(u2).getUserId());
		assertEquals(u2.getUserName(), service.updateUser(u2).getUserName());
		assertEquals(u2.getPassword(), service.updateUser(u2).getPassword());
		assertEquals(u2.getUserType(), service.updateUser(u2).getUserType());
	}

	@Test
	public void testRemoveUser() {
		when(repo.existsById(u1.getUserId())).thenReturn(true);
		service.removeUser(u1);
		verify(repo, times(1)).delete(u1);
	}

	@Test
	public void testViewUserById() {
		when(repo.save(u.get())).thenReturn(u.get());
		when(repo.findById(u.get().getUserId())).thenReturn(u);
		assertEquals(u.get().getUserName(), service.viewUser(1).getUserName());
	}

	@Test
	public void testViewAllUser() {

		List<User> allUsers = new ArrayList<>();
		allUsers.add(u1);
		allUsers.add(u2);
		allUsers.add(u3);
		allUsers.add(u4);

		when(repo.findAll()).thenReturn(allUsers);
		assertEquals(4, service.viewAllUser().size());

	}

}
