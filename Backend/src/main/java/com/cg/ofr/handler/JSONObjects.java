package com.cg.ofr.handler;

import org.springframework.stereotype.Component;
@Component
public class JSONObjects {
	private String error;
	public JSONObjects() {
	}
	public void setError(String error) {
		this.error=error;
	}
	public String getError() {
		return error;
	}
}
