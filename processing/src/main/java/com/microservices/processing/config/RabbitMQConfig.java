package com.microservices.processing.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

	@Value("${broker.queue.processamento.name}")
	private String queue;
	
	@Bean
	public Queue queue() {
		return new Queue(queue,true);
	}
}
