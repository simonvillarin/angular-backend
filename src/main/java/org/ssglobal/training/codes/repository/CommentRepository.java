package org.ssglobal.training.codes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ssglobal.training.codes.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer>{
	List<Comment> findByProductId(Integer productId);
}
