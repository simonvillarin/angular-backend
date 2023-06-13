package org.ssglobal.training.codes.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.ssglobal.training.codes.model.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
	List<CartItem> findByUserId(Integer userId);
	@Query("SELECT c FROM CartItem c WHERE c.userId = :userId AND c.productName = :productName")
	Optional<CartItem> findByUserIdAndProductName(@Param("userId") Integer userId, @Param("productName") String productName);
	Optional<CartItem> findByProductName(String productName);
}
