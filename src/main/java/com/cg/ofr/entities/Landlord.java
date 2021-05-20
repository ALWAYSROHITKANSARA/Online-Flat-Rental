package com.cg.ofr.entities;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;





@Entity
public class Landlord {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int landlordId;
	@Column(name = "Landlord_Name")
	@NotBlank(message = "Name field cannot be empty.")
	@Pattern(regexp = "^[A-Za-z][A-Za-z\\s]*$")
	@Size(min = 2, max = 40)
	private String landlordName;

	@Column(name = "Landlord_Age")
	@Min(18)
	@Max(100)
	private int  landlordAge;
	
	@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="landlord_id")
	private List<Flat> flatList;
	
	public Landlord() {
	}
	
	

	public Landlord(int landlordId,
			@NotBlank(message = "Name field cannot be empty.") @Size(min = 2, max = 40) String landlordName,
			@NotBlank(message = "Age field cannot be empty.") @Min(17) @Max(100) int landlordAge, List<Flat> flatList) {
		this.landlordId = landlordId;
		this.landlordName = landlordName;
		this.landlordAge = landlordAge;
		this.flatList = flatList;
	}

	public Landlord(int landlordId,
			@NotBlank(message = "Name field cannot be empty.") @Size(min = 2, max = 40) String landlordName,
			@NotBlank(message = "Age field cannot be empty.") @Min(17) @Max(100) int landlordAge) {
		super();
		this.landlordId = landlordId;
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
		this.landlordAge = landlordAge;
	}


	public List<Flat> getFlatList() {
		return flatList;
	}


	public void setFlatList(List<Flat> flatList) {
		this.flatList = flatList;
	}


	@Override
	public String toString() {
		return "Landlord [landlordId=" + landlordId + ", landlordName=" + landlordName + ", landlordAge=" + landlordAge
				+ ", flatList=" + flatList + "]";
	}
	

	

	
}
