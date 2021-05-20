package com.cg.ofr.service;

//Add test for exceptions also

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.ofr.entities.Flat;
import com.cg.ofr.entities.FlatAddress;
import com.cg.ofr.entities.FlatBooking;
import com.cg.ofr.entities.Landlord;
import com.cg.ofr.entities.Tenant;
import com.cg.ofr.exception.FlatBookingNotFoundException;
import com.cg.ofr.exception.TenantNotFoundException;
import com.cg.ofr.repository.IFlatBookingRepository;



@SpringBootTest
public class FlatBookingServiceTest {
	
	@Autowired 
	private FlatBookingService service;
	
	@MockBean
	private IFlatBookingRepository repository;
	
	Optional<FlatBooking> flatbooking3;
	FlatBooking flatbooking1;
	FlatBooking flatbooking2;
	Optional<FlatBooking> flatbooking4;
	FlatAddress flatAddress = null;
	Flat flat = null;
	Tenant tenant = null;
	@BeforeEach		//Define flat list also for below test cases
	public void init() {
		LocalDate fromdate=LocalDate.of(2021,06, 20);
		LocalDate todate=LocalDate.of(2021,07, 19);
		
		flatbooking1 = new FlatBooking(1, null, null, fromdate,todate);
		flatbooking2 = new FlatBooking(2, null,null,fromdate , todate);
		flatbooking3 = Optional.of(new FlatBooking(3, null,null,fromdate , todate));
		
	}
	
	@Test
	public void testAddFlatBooking() {
		when(repository.save(flatbooking1)).thenReturn(flatbooking1);
		assertEquals(flatbooking1.getBookingNo(),service.addFlatBooking(flatbooking1).getBookingNo());
		assertEquals(flatbooking1.getFlat(),service.addFlatBooking(flatbooking1).getFlat());
		assertEquals(flatbooking1.getTenantId(),service.addFlatBooking(flatbooking1).getTenantId());
		assertEquals(flatbooking1.getBookingFromDate(),service.addFlatBooking(flatbooking1).getBookingFromDate());
		assertEquals(flatbooking1.getBookingToDate(),service.addFlatBooking(flatbooking1).getBookingToDate());
	}
	
	@Test
	public void testUpdateFlatBooking(){
		when(repository.findById(flatbooking3.get().getBookingNo())).thenReturn(flatbooking3);
		when(repository.save(flatbooking3.get())).thenReturn(flatbooking3.get());
		assertEquals(flatbooking3.get().getBookingNo(),service.updateFlatBooking(flatbooking3.get(),flatbooking3.get().getBookingNo()).getBookingNo());
		assertEquals(flatbooking3.get().getFlat(),service.updateFlatBooking(flatbooking3.get(),flatbooking3.get().getBookingNo()).getFlat());
		assertEquals(flatbooking3.get().getTenantId(),service.updateFlatBooking(flatbooking3.get(),flatbooking3.get().getBookingNo()).getTenantId());
		assertEquals(flatbooking3.get().getBookingFromDate(),service.updateFlatBooking(flatbooking3.get(),flatbooking3.get().getBookingNo()).getBookingFromDate());
		assertEquals(flatbooking3.get().getBookingToDate(),service.updateFlatBooking(flatbooking3.get(),flatbooking3.get().getBookingNo()).getBookingToDate());
	}
	
	@Test
	public void testDeleteFlatBooking() {
		when(repository.findById(flatbooking3.get().getBookingNo())).thenReturn(flatbooking3);
		service.deleteFlatBooking(flatbooking3.get().getBookingNo());
		verify(repository, times(1)).delete(flatbooking3.get());
	}
	
	@Test
	public void testViewFlatBooking(){
		when(repository.findById(flatbooking3.get().getBookingNo())).thenReturn(flatbooking3);
		assertEquals(flatbooking3.get().getBookingNo(),service.viewFlatBooking(flatbooking3.get().getBookingNo()).getBookingNo());
		assertEquals(flatbooking3.get().getFlat(),service.viewFlatBooking(flatbooking3.get().getBookingNo()).getFlat());
		assertEquals(flatbooking3.get().getTenantId(),service.viewFlatBooking(flatbooking3.get().getBookingNo()).getTenantId());
		assertEquals(flatbooking3.get().getBookingFromDate(),service.viewFlatBooking(flatbooking3.get().getBookingNo()).getBookingFromDate());
		assertEquals(flatbooking3.get().getBookingToDate(),service.viewFlatBooking(flatbooking3.get().getBookingNo()).getBookingToDate());
	}
	
	@Test
	public void testViewAllFlatBooking() {
		List<FlatBooking> l = new ArrayList<FlatBooking>();
		l.add(flatbooking1);
		l.add(flatbooking2);
		when(repository.findAll()).thenReturn(l);
		assertEquals(l.size(), service.viewAllFlatBooking().size());
		assertArrayEquals(l.toArray(), service.viewAllFlatBooking().toArray());
	
	}
	
}
