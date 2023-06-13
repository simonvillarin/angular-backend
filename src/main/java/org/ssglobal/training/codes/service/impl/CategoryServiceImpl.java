package org.ssglobal.training.codes.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.ssglobal.training.codes.model.Category;
import org.ssglobal.training.codes.repository.CategoryRepository;
import org.ssglobal.training.codes.response.Response;
import org.ssglobal.training.codes.service.CategoryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
	
	private final CategoryRepository categoryRepository;

	@Override
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	@Override
	public Response addCategory(Category category) {
		Optional<Category> categoryOpt = categoryRepository.findByCategory(category.getCategory());
		if (categoryOpt.isEmpty()) {
			categoryRepository.save(category);
		}
		return Response.builder()
				.statusCode(201)
				.message("Category successfully added")
				.build();
	}

	@Override
	public Response updateCategory(Integer categoryId, Category category) {
		Optional<Category> categoryOpt = categoryRepository.findById(categoryId);
		if (categoryOpt.isPresent()) {
			Category _category = categoryOpt.get();
			
			if (category.getCategory() != null) {
				_category.setCategory(category.getCategory());
			}
			categoryRepository.save(_category);
			return Response.builder()
					.statusCode(200)
					.message("Category successfully updated")
					.build();
		}
		return Response.builder()
				.statusCode(404)
				.message("Category not found")
				.build();
	}

	@Override
	public Response deleteCategory(Integer categoryId) {
		Optional<Category> categoryOpt = categoryRepository.findById(categoryId);
		if (categoryOpt.isPresent()) {
			categoryRepository.deleteById(categoryId);
			return Response.builder()
					.statusCode(200)
					.message("Category successfully deleted")
					.build();
		}
		return Response.builder()
				.statusCode(404)
				.message("Category not found")
				.build();
	}

}
