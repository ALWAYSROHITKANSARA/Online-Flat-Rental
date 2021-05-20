package com.cg.ofr.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
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

import com.cg.ofr.entities.Tenant;
import com.cg.ofr.exception.TenantNotFoundException;
import com.cg.ofr.repository.ITenantRepository;

@ExtendWith(MockitoExtension.class)
public class TenantServiceTest {

	@Mock
	private ITenantRepository tenantRepository;

	@InjectMocks
	private TenantService tenantService;

	@Test
	public void test_UpdateTenant() {

		Tenant c1 = new Tenant("Yathin", 22);
		assertThat(tenantRepository.findById(c1.getTenantId())).isNotEqualTo(c1);

	}

	@Test
	public void test_AddTenant() {
		Tenant c1 = new Tenant("Vamsi", 18);

		when(tenantRepository.save(c1)).thenReturn(c1);

		assertEquals(c1.getTenantId(), tenantService.addTenant(c1).getTenantId());

	}

	@Test
	public void test_viewAllTenant() throws Exception {
		Tenant cust1 = new Tenant();
		Tenant cust2 = new Tenant();

		List<Tenant> tenantlist = new ArrayList<Tenant>();
		tenantlist.add(cust1);
		tenantlist.add(cust2);
		Mockito.when(tenantRepository.findAll()).thenReturn(tenantlist);
		List<Tenant> result = tenantService.viewAllTenant();
		assertEquals(2, result.size());

	}

	@Test
	public void test_viewTenant_ThrowTenantNotFoundException() {
		try {
			Mockito.when(tenantService.viewTenant(1)).thenThrow(new TenantNotFoundException("not found"));
		} catch (Exception c1) {

			Assertions.assertTrue(c1 instanceof TenantNotFoundException);
		}

	}

	 

}
