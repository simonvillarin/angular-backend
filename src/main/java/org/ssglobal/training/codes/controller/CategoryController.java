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
import org.ssglobal.training.codes.model.Category;
import org.ssglobal.training.codes.response.Response;
import org.ssglobal.training.codes.service.impl.CategoryServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class CategoryController {
	
	private final CategoryServiceImpl categoryServiceImpl;
	
	@GetMapping("/categories")
	public ResponseEntity<List<Category>> getAllCategories() {
		return ResponseEntity.ok(categoryServiceImpl.getAllCategories());
	}
	
	@PostMapping("/category")
	public ResponseEntity<Response> addCategory(@RequestBody Category category) {
		return ResponseEntity.status(HttpStatus.CREATED).body(categoryServiceImpl.addCategory(category));
	}
	
	@PutMapping("/category/{id}")
	public ResponseEntity<Response> updateCategory(@PathVariable("id") Integer categoryId, @RequestBody Category category) {
		return ResponseEntity.ok(categoryServiceImpl.updateCategory(categoryId, category));
	}
	
	@DeleteMapping("/category/{id}")
	public ResponseEntity<Response> deleteCategory(@PathVariable("id") Integer categoryId) {
		return ResponseEntity.ok(categoryServiceImpl.deleteCategory(categoryId));
	}
}
