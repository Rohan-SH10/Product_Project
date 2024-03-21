package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product.dto.ProductRequest;
import com.product.entity.Product;
import com.product.service.ProductService;
import com.product.utility.ErrorStructure;
import com.product.utility.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
public class ProductController {

	@Autowired
	public ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@Operation(description = "Insert the Product",responses = {
			@ApiResponse(responseCode = "200", description = "Product Saved Successfully"),
			@ApiResponse(responseCode = "400", description = "Invalid Inputs",content = {
					@Content(schema = @Schema(implementation = ErrorStructure.class))
			})
	})
	@PostMapping("/products")
	public ResponseEntity<ResponseStructure<Product>> saveProduct(@RequestBody ProductRequest  productRequest)
	{
		return productService.saveProduct(productRequest);
	}

	
	@Operation(description = "Update The Product Based On Id",responses = {
			@ApiResponse(responseCode = "200", description = "Product found"),
			@ApiResponse(responseCode = "400", description = "Product Not found based on given id",content = {
					@Content(schema = @Schema(implementation = ErrorStructure.class))
			})
	})
	@PutMapping("/products/{productId}")
	public ResponseEntity<ResponseStructure<Product>> updateProduct(@RequestBody Product product,@PathVariable int productId)
	{
		return productService.updateProduct(product,productId);
	}

	
	@Operation(description = "Delete the Product Based On Id", responses = {
	@ApiResponse(responseCode = "200", description = "Product found"),
	@ApiResponse(responseCode = "400", description = "Product Not found based on given id",content = {
			@Content(schema = @Schema(implementation = ErrorStructure.class))
	})
	})
	@DeleteMapping("/products/{productId}")
	public ResponseEntity<ResponseStructure<Product>> deleteProduct(@PathVariable int productId)
	{
		return productService.deleteProduct(productId);
	}
	
	
	@Operation(description = "Find The Product Based On Id",responses = {
			@ApiResponse(responseCode = "200", description = "Product found"),
			@ApiResponse(responseCode = "400", description = "Product Not found based on given id",content = {
					@Content(schema = @Schema(implementation = ErrorStructure.class))
			})

	})
	@GetMapping("/products/{productId}")
	public ResponseEntity<ResponseStructure<Product>> findById(@PathVariable int productId)
	{
		return productService.findById(productId);
	}
	
	
	@Operation(description = "Find All the Product",responses = {
			@ApiResponse(responseCode = "200", description = "Product found"),
			@ApiResponse(responseCode = "400", description = "Product Not found",content = {
					@Content(schema = @Schema(implementation = ErrorStructure.class))
			})
	})
	@GetMapping("/products")
	public ResponseEntity<ResponseStructure<List<Product>>> findAll()
	{
		return productService.findAll();
	}
	 
	
}
