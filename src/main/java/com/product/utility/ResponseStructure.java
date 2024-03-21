package com.product.utility;

import java.util.List;

import org.springframework.stereotype.Component;

import com.product.entity.Product;

@Component
public class ResponseStructure<T> {
	
	public int getStatuscode() {
		return statuscode;
	}
	public ResponseStructure<T> setStatuscode(int statuscode) {
		this.statuscode = statuscode;
		return this;
	}
	public String getMessage() {
		return message;
	}
	public ResponseStructure<T> setMessage(String message) {
		this.message = message;
		return this;
	}
	public T getData() {
		return Data;
	}
	
	public ResponseStructure<T> setData(T data) {
		Data = data;
		return this;
	}


	private int statuscode;
	private String message;
	private T Data;

}
