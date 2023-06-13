package org.ssglobal.training.codes.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ssglobal.training.codes.model.Order;
import org.ssglobal.training.codes.response.Response;
import org.ssglobal.training.codes.service.impl.OrderServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class OrderController {
	
	private final OrderServiceImpl orderServiceImpl;
	
	@GetMapping("/orders/{id}")
	public ResponseEntity<List<Order>> getOrdersByUserId(@PathVariable("id") Integer userId) {
		return ResponseEntity.ok(orderServiceImpl.getOrdersByUserId(userId));
	}
	
	@GetMapping("/orders/tracking/{id}")
	public ResponseEntity<List<Order>> getOrdersByOrderTracking(@PathVariable("id") Integer orderTracking) {
		return ResponseEntity.ok(orderServiceImpl.getOrderByOrderTracking(orderTracking));
	}
	
	@GetMapping("/order/{id}")
	public ResponseEntity<Order> getOrderById(@PathVariable("id") Integer orderId) {
		return ResponseEntity.ok(orderServiceImpl.getOrderById(orderId));
	}
	
	@PostMapping("/order")
	public ResponseEntity<Response> addOrder(@RequestBody Order order) {
		return ResponseEntity.status(HttpStatus.CREATED).body(orderServiceImpl.addOrder(order));
	}
	
	@PostMapping("/orders")
	public void addOrder(@RequestBody List<Order> orders) {
		orderServiceImpl.addOrders(orders);
	}
	
	@DeleteMapping("/order/{id}")
	public ResponseEntity<Response> deleteOrder(@PathVariable("id") Integer orderId) {
		return ResponseEntity.ok(orderServiceImpl.deleteOrder(orderId));
	}
}
