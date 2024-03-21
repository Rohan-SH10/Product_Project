package com.product.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.product.entity.User;
import com.product.repository.UserRepository;
import com.product.service.UserService;
import com.product.utility.ResponseStructure;

@Service
public class UserServiceImpl implements UserService{

	UserRepository userRepository;
	ResponseStructure<User> responseStructure;
	
	
	public UserServiceImpl(UserRepository userRepository, ResponseStructure<User> responseStructure) {
		this.userRepository = userRepository;
		this.responseStructure = responseStructure;
	}


	@Override
	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
	    User uniqUser = userRepository.save(user);
		return ResponseEntity.ok(
				responseStructure.setStatuscode(HttpStatus.OK.value())
				.setMessage("User Data Saved Successfully")
				.setData(uniqUser));
	}

}
