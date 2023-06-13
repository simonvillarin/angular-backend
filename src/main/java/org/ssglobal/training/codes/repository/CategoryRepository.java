package org.ssglobal.training.codes.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ssglobal.training.codes.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{
	Optional<Category> findByCategory(String category);
}
