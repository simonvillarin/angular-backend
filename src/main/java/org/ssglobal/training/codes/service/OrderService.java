package org.ssglobal.training.codes.service;

import java.util.List;

import org.ssglobal.training.codes.model.Order;
import org.ssglobal.training.codes.response.Response;

public interface OrderService {
	List<Order> getOrdersByUserId(Integer userId);
	List<Order> getOrderByOrderTracking(Integer orderTracking);
	Order getOrderById(Integer orderId);
	Response addOrder(Order order);
	void addOrders(List<Order> order);
	Response deleteOrder(Integer orderId);
}
