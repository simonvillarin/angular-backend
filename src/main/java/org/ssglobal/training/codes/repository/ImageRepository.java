package org.ssglobal.training.codes.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ssglobal.training.codes.model.Image;

public interface ImageRepository extends JpaRepository<Image, Integer>{
	Optional<Image> findByFilename(String filename);
	boolean existsByFilename(String fileName);
}
