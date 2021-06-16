package com.cg.ofr.entities;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;


@Entity
public class Landlord {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int landlordId;
	@Column(name = "Landlord_Name")
	@NotBlank(message = "Name field cannot be empty.")
	private String landlordName;

	@Column
	private int landlordAge;
	
	//@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	//@JoinColumn(name="landlord_id")
	//@OneToMany(mappedBy = "landlord", cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	@OneToMany(mappedBy = "landlord", cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Flat> flatList;
	
	public Landlord() {
	}
	
	/*
	public Landlord(@NotBlank(message = "Name field cannot be empty.") String landlordName, List<Flat> flatList,int landlordAge) {
		this.landlordName = landlordName;
		this.flatList = flatList;
		this.landlordAge = landlordAge;
	}
*/
	public Landlord(@NotBlank(message = "Name field cannot be empty.")  String landlordName,int landlordAge) {
		this.landlordName = landlordName;
		this.landlordAge = landlordAge;
	}

	public int getLandlordId() {
		return landlordId;
	}


	public void setLandlordId(int landlordId) {
		this.landlordId = landlordId;
	}

	public String getLandlordName() {
		return landlordName;
	}


	public void setLandlordName(String landlordName) {
		this.landlordName = landlordName;
	}

	
	public int getLandlordAge() {
		return landlordAge;
	}
	public void setLandlordAge(int landlordAge) {
		this.landlordAge =landlordAge;
	}

	public List<Flat> getFlatList() {
		return flatList;
	}

	public void setFlatList(List<Flat> flatList) {
		this.flatList = flatList;
	}
/*
	public void setFlatList(List<Flat> flatList) {
		this.flatList = flatList;
	}
*/


	@Override
	public String toString() {
		return "Landlord [landlordId=" + landlordId + ", landlordName=" + landlordName + ", landlordAge=" + landlordAge
				+", flatList=" + flatList + "]";
	}

	
}