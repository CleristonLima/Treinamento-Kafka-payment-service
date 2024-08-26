package com.cleriston.payment_service;

import com.cleriston.payment_service.model.Payment;

public interface PaymentService {
	
	void sendPayment(Payment payment);

}
