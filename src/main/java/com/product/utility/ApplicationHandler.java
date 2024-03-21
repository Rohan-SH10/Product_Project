package com.product.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.product.exception.ProductNotFoundException;

@RestControllerAdvice
public class ApplicationHandler
{
	 ErrorStructure errorStructure;
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> productNotFoundFoundException(ProductNotFoundException pnf)
	{
		ErrorStructure<String> errorStructure=new ErrorStructure<>();
		errorStructure.setStatuscode(HttpStatus.NOT_FOUND.value());
		errorStructure.setMessage(pnf.getMessage());
		errorStructure.setRootCause("Not Found");
		return new ResponseEntity<ErrorStructure<String>>(errorStructure,HttpStatus.NOT_FOUND);
	}

	
}
