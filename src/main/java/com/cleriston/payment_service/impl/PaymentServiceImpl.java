package com.cleriston.payment_service.impl;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.io.Serializable;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.cleriston.payment_service.PaymentService;
import com.cleriston.payment_service.model.Payment;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequiredArgsConstructor
@Log4j2
@Service
public class PaymentServiceImpl implements  PaymentService {
	
	private final KafkaTemplate<String, Serializable> kafkaTemplate;
	
	@Override
	public void sendPayment(Payment payment) {
		log.info("Recebi o pagamento {}", payment);
		Thread.sleep(1000);
		
		log.info("Enviando pagamento...");
		KafkaTemplate.send("payment-topic", payment);
	}

}
