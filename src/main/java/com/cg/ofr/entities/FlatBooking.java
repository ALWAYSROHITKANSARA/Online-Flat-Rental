package com.cg.ofr.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class FlatBooking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int	bookingNo;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Flat")
	private Flat flat;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="TenantID")
	private Tenant tenantId;
	private LocalDate bookingFromDate;
	private LocalDate bookingToDate;
	
	public int getBookingNo() {
		return bookingNo;
	}
	public void setBookingNo(int bookingNo) {
		this.bookingNo = bookingNo;
	}
	public Flat getFlat() {
		return flat;
	}
	public void setFlat(Flat flat) {
		this.flat = flat;
	}
	public Tenant getTenantId() {
		return tenantId;
	}
	public void setTenantId(Tenant tenantId) {
		this.tenantId = tenantId;
	}
	public LocalDate getBookingFromDate() {
		return bookingFromDate;
	}
	public void setBookingFromDate(LocalDate bookingFromDate) {
		this.bookingFromDate = bookingFromDate;
	}
	public LocalDate getBookingToDate() {
		return bookingToDate;
	}
	public void setBookingToDate(LocalDate bookingToDate) {
		this.bookingToDate = bookingToDate;
	}
	public FlatBooking(int bookingNo, Flat flat, Tenant tenantId, LocalDate bookingFromDate, LocalDate bookingToDate) {
		super();
		this.bookingNo = bookingNo;
		this.flat = flat;
		this.tenantId = tenantId;
		this.bookingFromDate = bookingFromDate;
		this.bookingToDate = bookingToDate;
	}
	public FlatBooking() {
		super();
	}
	

	

}
