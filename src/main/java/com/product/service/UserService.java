package com.product.service;

import org.springframework.http.ResponseEntity;

import com.product.entity.User;
import com.product.utility.ResponseStructure;

public interface UserService {

	ResponseEntity<ResponseStructure<User>> saveUser(User user);

}
