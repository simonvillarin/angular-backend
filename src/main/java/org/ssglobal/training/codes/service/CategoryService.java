package org.ssglobal.training.codes.service;

import java.util.List;

import org.ssglobal.training.codes.model.Category;
import org.ssglobal.training.codes.response.Response;

public interface CategoryService {
	List<Category> getAllCategories();
	Response addCategory(Category category);
	Response updateCategory(Integer categoryId, Category category);
	Response deleteCategory(Integer categoryId);
}
