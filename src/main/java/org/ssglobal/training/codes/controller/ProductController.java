package org.ssglobal.training.codes.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.ssglobal.training.codes.model.Product;
import org.ssglobal.training.codes.response.Response;
import org.ssglobal.training.codes.service.impl.ProductServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ProductController {
	
	private final ProductServiceImpl productServiceImpl;
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllUsers() {
		return ResponseEntity.ok(productServiceImpl.getAllProducts());
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id") Integer productId) {
		return ResponseEntity.ok(productServiceImpl.getProductById(productId));
	}
	
	@PostMapping(value = "/product", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Response> addProduct(@RequestPart Product product, @RequestPart MultipartFile file) {
		return ResponseEntity.status(HttpStatus.CREATED).body(productServiceImpl.addProduct(product, file));
	}
	
	@PutMapping(value = "/product/image/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Response> updateProduct(@PathVariable("id") Integer productId, @RequestPart Product product, @RequestPart MultipartFile file) {
		return ResponseEntity.ok(productServiceImpl.updateProduct(productId, product, file));
	}
	
	@PutMapping(value = "/product/{id}")
	public ResponseEntity<Response> updateProduct(@PathVariable("id") Integer productId, @RequestBody Product product) {
		return ResponseEntity.ok(productServiceImpl.updateProduct(productId, product));
	}
	
	
	@DeleteMapping("/product/{id}")
	public ResponseEntity<Response> deleteProduct(@PathVariable("id") Integer productId) {
		return ResponseEntity.ok(productServiceImpl.deleteProduct(productId));
	}
}
