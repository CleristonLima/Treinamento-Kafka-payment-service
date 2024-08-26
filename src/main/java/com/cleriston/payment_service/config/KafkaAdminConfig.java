package com.cleriston.payment_service.config;

import java.util.HashMap;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

@Configuration
public class KafkaAdminConfig {
	
	private final KafkaProperties properties;

	@Bean
	public KafkaAdmin kafkaAdmin() {
		var configs = new HashMap<String, object>();
		configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, properties.getBootstrapServers());
		return new KafkaAdmin(configs);
		
	}
	
	@Bean
	public KafkaAdmin.NewTopics newTopics(){
		return new KafkaAdmin.NewTopics(
				TopicBuilder.name("payment-topic").partitions(1).build()
				);
	}
}
