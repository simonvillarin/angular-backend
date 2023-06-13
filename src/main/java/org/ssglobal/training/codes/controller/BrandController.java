package org.ssglobal.training.codes.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ssglobal.training.codes.model.Brand;
import org.ssglobal.training.codes.response.Response;
import org.ssglobal.training.codes.service.impl.BrandServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class BrandController {
	
	private final BrandServiceImpl brandServiceImpl;
	
	@GetMapping("/brands")
	public ResponseEntity<List<Brand>> getAllBrands() {
		return ResponseEntity.ok(brandServiceImpl.getAllBrands());
	}
	
	@PostMapping("/brand")
	public ResponseEntity<Response> addBrand(@RequestBody Brand brand) {
		return ResponseEntity.status(HttpStatus.CREATED).body(brandServiceImpl.addBrand(brand));
	}
	
	@PutMapping("/brand/{id}")
	public ResponseEntity<Response> updateBrand(@PathVariable("id") Integer brandId, @RequestBody Brand brand) {
		return ResponseEntity.ok(brandServiceImpl.updateBrand(brandId, brand));
	}
	
	@DeleteMapping("/brand/{id}")
	public ResponseEntity<Response> deleteBrand(@PathVariable("id") Integer brandId) {
		return ResponseEntity.ok(brandServiceImpl.deleteBrand(brandId));
	}
}
