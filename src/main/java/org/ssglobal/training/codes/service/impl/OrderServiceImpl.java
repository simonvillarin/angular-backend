package org.ssglobal.training.codes.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.ssglobal.training.codes.model.Order;
import org.ssglobal.training.codes.repository.OrderRepository;
import org.ssglobal.training.codes.response.Response;
import org.ssglobal.training.codes.service.OrderService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
	
	private final OrderRepository orderRepository;
	
	@Override
	public List<Order> getOrdersByUserId(Integer userId) {
		return orderRepository.findByUserId(userId);
	}
	
	@Override
	public List<Order> getOrderByOrderTracking(Integer orderTracking) {
		return orderRepository.findByOrderTracking(orderTracking);
	}


	@Override
	public Order getOrderById(Integer orderId) {
		Optional<Order> orderOpt = orderRepository.findById(orderId);
		if (orderOpt.isPresent()) {
			return orderOpt.get();
		} else {
			throw new RuntimeException("Order not found");
		}
	}

	@Override
	public Response addOrder(Order order) {	
		orderRepository.save(order);
		return Response.builder()
				.statusCode(201)
				.message("Order successfully added")
				.timestamp(LocalDateTime.now())
				.build();
	}
	
	@Override
	public void addOrders(List<Order> orders) {
		for (int i = 0; i < orders.size(); i++) {
			orderRepository.save(orders.get(i));
		}
	}


	@Override
	public Response deleteOrder(Integer orderId) {
		Optional<Order> orderOpt = orderRepository.findById(orderId);
		if (orderOpt.isPresent()) {
			orderRepository.deleteById(orderId);
			return Response.builder()
					.statusCode(201)
					.message("Order successfully deleted")
					.timestamp(LocalDateTime.now())
					.build();
		}
		return Response.builder()
				.statusCode(404)
				.message("Order not found")
				.timestamp(LocalDateTime.now())
				.build();
	}
}
