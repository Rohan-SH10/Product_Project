package com.product.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.product.dto.ProductRequest;
import com.product.entity.Product;
import com.product.exception.ProductNotFoundException;
import com.product.repository.ProductRepository;
import com.product.service.ProductService;
import com.product.utility.ResponseStructure;

@Service
public class ProductServiceImpl  implements ProductService{

	//	@Autowired
	private ProductRepository productRepository;

	//	@Autowired
	private ResponseStructure<Product> responseStructure;

	private ResponseStructure<List<Product>> responseStructureList;


	public ProductServiceImpl(ProductRepository productRepository, ResponseStructure<Product> responseStructure,
			ResponseStructure<List<Product>> responseStructureList) {
		this.productRepository = productRepository;
		this.responseStructure = responseStructure;
		this.responseStructureList = responseStructureList;
	}

	@Override
	public ResponseEntity<ResponseStructure<Product>> saveProduct(ProductRequest productRequest) {
		
		Product product = productRepository.save(mapToProduct(productRequest,new Product()));
		return ResponseEntity.ok(responseStructure.setStatuscode(HttpStatus.OK.value()).setMessage("Product Saved Successfully").setData(product));
	}

	private Product mapToProduct(ProductRequest productRequest,Product product ) {
		// TODO Auto-generated method stub
		product.setProductName(productRequest.getProductName());
		return product;
//		return Product.builder().productName(productRequest.getProductName()).build();
		
	}

	@Override
	public ResponseEntity<ResponseStructure<Product>> updateProduct(Product updateProduct,int productId) {
		return productRepository.findById(productId).map(exProd->{
			updateProduct.setProductId(exProd.getProductId());
			productRepository.save(updateProduct);
			return ResponseEntity.ok(responseStructure.setStatuscode(HttpStatus.OK.value())
					.setMessage("Found")
					.setData(updateProduct));})
				.orElseThrow(()-> new ProductNotFoundException("Not Found"));
	}

	@Override
	public ResponseEntity<ResponseStructure<Product>> deleteProduct(int productId) {
//		Optional<Product> optional = productRepository.findById(productId);
//		if(optional.isPresent())
//		{
//			Product product = optional.get();
//			productRepository.delete(product);
//			ResponseStructure<Product> rs=new ResponseStructure<>();
//			rs.setStatuscode(HttpStatus.OK.value());
//			rs.setMessage("Deleted Successfully");
//			rs.setData(product);
//			return new ResponseEntity<ResponseStructure<Product>>(rs,HttpStatus.OK);
//		}else
//		{
//			throw new ProductNotFoundException("Product Not Found");
//		}
		return productRepository.findById(productId).map(p->{
			productRepository.delete(p);
		return ResponseEntity.ok(responseStructure.setStatuscode(HttpStatus.OK.value()).setMessage("Product Deleted Successfully ").setData(p));
		}).orElseThrow(()->new ProductNotFoundException("Not Found"));
	}

	@Override
	public ResponseEntity<ResponseStructure<Product>> findById(int productId) {
		return productRepository.findById(productId).map(p->ResponseEntity.ok(
				responseStructure.setStatuscode(HttpStatus.OK.value())
				.setMessage("Product Found")
				.setData(p)))
				.orElseThrow(() -> new ProductNotFoundException("product not found"));
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Product>>> findAll() {
		List<Product> products = productRepository.findAll();
		if(!products.isEmpty()) {
			return ResponseEntity.ok(responseStructureList.setStatuscode(HttpStatus.OK.value())
					.setMessage("product found").setData(products)
					);
		}
		else throw new ProductNotFoundException("Product not found ");
	}

}
