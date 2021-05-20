package com.cg.ofr.service;

//Add test for exceptions also

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import com.cg.ofr.entities.Flat;
import com.cg.ofr.entities.FlatAddress;
import com.cg.ofr.entities.Landlord;
import com.cg.ofr.exception.LandlordNotFoundException;
import com.cg.ofr.repository.ILandlordRepository;


@SpringBootTest
public class LandlordServiceTest {
	
	@Autowired 
	private LandlordService service;
	
	@MockBean
	private ILandlordRepository repository;
	
	private static final Logger LOGGER = LogManager.getLogger(LandlordServiceTest.class);
	
	private Optional<Landlord> landlord3;
	private Landlord landlord1 ,landlord2;
	private Flat flat1, flat2, flat3;
	private FlatAddress add1, add2, add3;
	
	@BeforeAll
	public static void initBefore() {
		LOGGER.info("Landlord module testing initialized");
	}
	
	@BeforeEach		//Define flat list also for below test cases
	public void init() {
		add1= new FlatAddress(10,"jaipurroad", "jaipur", "rajasthan", 302000, "India");
		add2= new FlatAddress(11,"ajmerrroad", "ajmer", "rajasthan", 303015, "India");
		add3= new FlatAddress(12,"kotaroad", "kota", "rajasthan", 306605, "India");
		flat1= new Flat(100, 1000.0f, add1, "Yes");
		flat2= new Flat(101, 550.0f, add2, "No");
		flat3= new Flat(102, 1690.0f, add3, "Yes");
		List<Flat> flat_list1 = new ArrayList<Flat>();
		flat_list1.add(flat1);
		flat_list1.add(flat2);
		List<Flat> flat_list2 = new ArrayList<Flat>();
		flat_list2.add(flat3);
		landlord1 = new Landlord(1, "Harsh", 23, flat_list1);
		landlord2 = new Landlord(2, "Amol", 100, flat_list1);
		landlord3 = Optional.of(new Landlord(3, "Rohit", 24, flat_list2));
	}
	
	@Test
	public void testAddLandlord1() {
		when(repository.save(landlord1)).thenReturn(landlord1);
		assertEquals(landlord1.getLandlordAge(),service.addLandlord(landlord1).getLandlordAge());
		assertEquals(landlord1.getLandlordId(),service.addLandlord(landlord1).getLandlordId());
		assertEquals(landlord1.getLandlordName(),service.addLandlord(landlord1).getLandlordName());
		assertEquals(landlord1.getFlatList(),service.addLandlord(landlord1).getFlatList());
	}
	
	@Test
	public void testAddLandlord2() {
		when(repository.save(landlord1)).thenReturn(landlord1);
		assertNotNull(service.addLandlord(landlord1));
	}
	
	
	@Test
	public void testUpdateLandlord(){
		when(repository.findById(landlord3.get().getLandlordId())).thenReturn(landlord3);
		when(repository.save(landlord3.get())).thenReturn(landlord3.get());
		assertEquals(landlord3.get().getLandlordAge(),service.updateLandlord(landlord3.get(),landlord3.get().getLandlordId()).getLandlordAge());
		assertEquals(landlord3.get().getLandlordName(),service.updateLandlord(landlord3.get(),landlord3.get().getLandlordId()).getLandlordName());
		assertEquals(landlord3.get().getFlatList(),service.updateLandlord(landlord3.get(),landlord3.get().getLandlordId()).getFlatList());
	}
	
	@Test
	public void testDeleteLandlord1() {
		when(repository.findById(landlord3.get().getLandlordId())).thenReturn(landlord3);
		service.deleteLandlord(landlord3.get().getLandlordId());
		verify(repository, times(1)).delete(landlord3.get());
	}
	
	@Test
	public void testDeleteLandlord2() {
		assertThrows(LandlordNotFoundException.class, new Executable() {
            
            @Override
            public void execute() throws Throwable {
            	service.deleteLandlord(10);
            }
        });
	}
	
	@Test
	public void testViewLandlord(){
		when(repository.findById(landlord3.get().getLandlordId())).thenReturn(landlord3);
		assertEquals(landlord3.get().getLandlordAge(),service.viewLandlord(landlord3.get().getLandlordId()).getLandlordAge());
		assertEquals(landlord3.get().getLandlordId(),service.viewLandlord(landlord3.get().getLandlordId()).getLandlordId());
		assertEquals(landlord3.get().getLandlordName(),service.viewLandlord(landlord3.get().getLandlordId()).getLandlordName());
		assertEquals(landlord3.get().getFlatList(),service.viewLandlord(landlord3.get().getLandlordId()).getFlatList());
	}
	
	@Test
	public void testViewAllLandlord() {
		List<Landlord> l = new ArrayList<Landlord>();
		l.add(landlord1);
		l.add(landlord2);
		when(repository.findAll()).thenReturn(l);
		assertEquals(l.size(), service.viewAllLandlord().size());
		assertArrayEquals(l.toArray(), service.viewAllLandlord().toArray());
	
	}
	
	@AfterAll
	public static void end() {
		LOGGER.info("Landlord testing module ended.");
	}

}
