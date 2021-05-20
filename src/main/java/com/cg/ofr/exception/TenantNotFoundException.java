package com.cg.ofr.exception;

public class TenantNotFoundException extends RuntimeException {
	public TenantNotFoundException(String message) {
		super(message);
	}
}
