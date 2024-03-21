package com.product.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.product.dto.ProductRequest;
import com.product.entity.Product;
import com.product.utility.ResponseStructure;

public interface ProductService {
	
	public ResponseEntity<ResponseStructure<Product>> saveProduct(ProductRequest productRequest);
	
	public ResponseEntity<ResponseStructure<Product>> updateProduct(Product product,int productId);
	
	public ResponseEntity<ResponseStructure<Product>> deleteProduct(int productId);
	
	public ResponseEntity<ResponseStructure<Product>> findById(int productId);
	public ResponseEntity<ResponseStructure<List<Product>>> findAll();

}
