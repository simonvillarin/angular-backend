package org.ssglobal.training.codes.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ssglobal.training.codes.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	Optional<Product> findByProductName(String productName);
}
