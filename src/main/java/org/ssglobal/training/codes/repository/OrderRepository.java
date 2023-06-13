package org.ssglobal.training.codes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ssglobal.training.codes.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
	List<Order> findByUserId(Integer userId);
	List<Order> findByOrderTracking(Integer orderTracking);
}
