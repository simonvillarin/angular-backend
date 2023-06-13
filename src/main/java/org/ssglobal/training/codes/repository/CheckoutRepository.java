package org.ssglobal.training.codes.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ssglobal.training.codes.model.Checkout;

public interface CheckoutRepository extends JpaRepository<Checkout, Integer> {
	List<Checkout> findByUserId(Integer userId);
	Optional<Checkout> findByProductName(String productName);
}
