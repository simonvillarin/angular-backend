package org.ssglobal.training.codes.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ssglobal.training.codes.model.Brand;

public interface BrandRepository extends JpaRepository<Brand, Integer>{
	Optional<Brand> findByBrand(String brand);
}
