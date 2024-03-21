package com.product.utility;

import org.springframework.stereotype.Component;

@Component
public class ErrorStructure<Object> {

	private int statuscode;
	private String message;
	private Object rootCause;
	public int getStatuscode() {
		return statuscode;
	}
	public ErrorStructure<Object> setStatuscode(int statuscode) {
		this.statuscode = statuscode;
		return this;
	}
	public String getMessage() {
		return message;
	}
	public ErrorStructure<Object> setMessage(String message) {
		this.message = message;
		return this;
	}
	public Object getRootCause() {
		return rootCause;
	}
	public ErrorStructure<Object> setRootCause(Object rootCause) {
		this.rootCause = rootCause;
		return this;
	}
}
