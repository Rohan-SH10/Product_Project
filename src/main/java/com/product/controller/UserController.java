package com.product.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.entity.User;
import com.product.service.UserService;
import com.product.utility.ResponseStructure;

import jakarta.validation.Valid;

@RestController
public class UserController {

	
	UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/users")
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody @Valid User user)
	{
		return userService.saveUser(user);
	}
}
