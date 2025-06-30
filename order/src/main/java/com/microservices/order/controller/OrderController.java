package com.microservices.order.controller;

import java.util.List;
import java.util.Map;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.order.controller.dto.OrderAccRequest;
import com.microservices.order.model.Order;
import com.microservices.order.service.OrderService;

@RestController
@RequestMapping(value="/orders")
public class OrderController {

	private final OrderService orderService;
	private final RabbitTemplate rabbitTemplate;
	
	@Value("${broker.queue.processamento.name}")
	private String routingKey;
	
	public OrderController(OrderService orderService,RabbitTemplate rabbitTemplate) {
		this.orderService = orderService;
		this.rabbitTemplate = rabbitTemplate;
	}
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){
		List<Order> list = orderService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<?> insertOrder(@RequestBody OrderAccRequest request){
		Order orderSaved = orderService.insertOrder(new Order(request.description()));
		rabbitTemplate.convertAndSend("",routingKey,orderSaved);
		return ResponseEntity.ok().body(Map.of("message","Pedido salvo e enviado para o processamento"));
	}
	
	
}
