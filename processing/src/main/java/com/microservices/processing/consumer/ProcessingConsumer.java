package com.microservices.processing.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ProcessingConsumer {

	@RabbitListener(queues = "${broker.queue.processamento.name}")
	public void listenerProcessingQueue(@Payload String description) {
		System.out.println(description);
	}
}
