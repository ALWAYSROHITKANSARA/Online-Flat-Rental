package com.cg.ofr.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.ofr.entities.Flat;
import com.cg.ofr.entities.FlatAddress;
import com.cg.ofr.exception.FlatNotFoundException;
import com.cg.ofr.repository.IFlatRepository;

@ExtendWith(MockitoExtension.class)
public class FlatTest {

	@InjectMocks
	private FlatService flatService;
	@Mock
	private IFlatRepository flatRepository;

	@Test
	public void test_updateFlat() {
		Flat c1 = new Flat(100.0f, new FlatAddress(1, "vn street", "bvrm", "andhra pradesh", 534201, "India"), "yes");

		assertThat(flatRepository.findById(c1.getFlatId())).isNotEqualTo(c1);

	}

	@Test
	public void test_addFlat() {
		Flat c1 = new Flat(100.0f, new FlatAddress(1, "vn street", "bvrm", "andhra pradesh", 534201, "India"), "yes");

		when(flatRepository.save(c1)).thenReturn(c1);

		assertEquals(c1.getFlatId(), flatService.addFlat(c1).getFlatId());

	}

	@Test
	public void test_getAllFlats() throws Exception {
		Flat f1 = new Flat(100.0f, new FlatAddress(1, "vn street", "bvrm", "andhra pradesh", 534201, "India"), "yes");
		Flat f2 = new Flat(2000.0f, new FlatAddress(2, "jk street", "rjy", "andhra pradesh", 534000, "India"), "no");

		List<Flat> flatlist = new ArrayList<>();
		flatlist.add(f1);
		flatlist.add(f2);
		Mockito.when(flatRepository.findAll()).thenReturn(flatlist);
		List<Flat> result = flatService.getAllFlats();
		assertEquals(2, result.size());

	}

	@Test
	public void test_viewFlatById_ThrowFlatNotFoundException() {
		try {
			Mockito.when(flatService.viewFlatById(1)).thenThrow(new FlatNotFoundException("not found"));
		} catch (Exception c1) {

			Assertions.assertTrue(c1 instanceof FlatNotFoundException);
		}
	}

	/*
	 * @Test public void test_deleteFlat_ThrowFlatNotFoundException() { try {
	 * Mockito.when(flatService.deleteFlat(Mockito.anyInt())).thenThrow(new
	 * FlatNotFoundException("not found")); } catch (Exception c1) {
	 * Assertions.assertTrue(c1 instanceof FlatNotFoundException); }
	 * 
	 * }
	 */
}
