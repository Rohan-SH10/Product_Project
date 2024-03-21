package com.product;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.product.entity.Product;

@SpringBootApplication
public class ProductProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductProjectApplication.class, args);

//		Product product=null;
//		Optional.of(product).map(p->{System.out.println("Inside Map");return p;}).orElseThrow(()->new RuntimeException());
	}
}


