package com.microservices.order.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.microservices.order.model.ItemOrder;
import com.microservices.order.model.Order;
import com.microservices.order.repository.OrderRepository;

@Service
public class OrderService {

	private final OrderRepository orderRepository;
	
	public OrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}
	
	public List<Order> findAll(){
		return orderRepository.findAll();
	}
	
	public Order insertOrder(Order order) {
		
		if(order.getItens() != null) {
			for(ItemOrder item : order.getItens()) {
				item.setOrder(order);
			}
		}
		return orderRepository.save(order);
	}
	
	
}
