package com.cg.ofr.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Tenant")
public class Tenant {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int tenantId;
	@Column(name = "TENANT_NAME", length = 30)
	private String tenantName;
	@Column(name = "TENANT_AGE")
	private int age;
	/*@OneToOne(cascade = CascadeType.ALL)
	private FlatAdress taddress;*/
	
	public Tenant() {
		super();
		
	}

	public Tenant(String tenantName, int age) {
		super();
		this.tenantName = tenantName;
		this.age = age;
	}

	/*public Tenant(int tenantId, String tenantName, int age, FlatAdress taddress) {
		super();
		this.tenantId = tenantId;
		this.tenantName = tenantName;
		this.age = age;
		//this.taddress = taddress;
	}*/

	public int getTenantId() {
		return tenantId;
	}

	public void setTenantId(int tenantId) {
		this.tenantId = tenantId;
	}

	public String getTenantName() {
		return tenantName;
	}

	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
/*
	public FlatAdress getTaddress() {
		return taddress;
	}

	public void setTaddress(FlatAdress taddress) {
		this.taddress = taddress;
	}
*/
	@Override
	public String toString() {
		return "Tenant [tenantId=" + tenantId + ", tenantName=" + tenantName + ", age=" + age + "]";
	}
	
	
}
