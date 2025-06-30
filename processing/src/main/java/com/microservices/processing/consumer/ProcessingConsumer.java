package com.microservices.processing.consumer;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.microservices.processing.dto.OrderDTO;

@Component
public class ProcessingConsumer {

	@RabbitListener(queues = "${broker.queue.processamento.name}")
	public void listenerProcessingQueue(OrderDTO orderDTO) {
		System.out.println(orderDTO.getDescription());
	}
}
