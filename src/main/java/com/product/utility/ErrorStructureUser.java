package com.product.utility;

public class ErrorStructureUser {
	private int statuscode;
	private String message;
	private Object rootCause;
	public int getStatuscode() {
		return statuscode;
	}
	public ErrorStructureUser setStatuscode(int statuscode) {
		this.statuscode = statuscode;
		return this;
	}
	public String getMessage() {
		return message;
	}
	public ErrorStructureUser setMessage(String message) {
		this.message = message;
		return this;
	}
	public Object getRootCause() {
		return rootCause;
	}
	public ErrorStructureUser setRootCause(Object rootCause) {
		this.rootCause = rootCause;
		return this;
	}
	
}
