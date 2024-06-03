package com.jonathanvasquez.payment_microservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jonathanvasquez.payment_microservice.entity.PaymentEntity;
import com.jonathanvasquez.payment_microservice.rest.PaymentRest;

@Service
public class PaymentService {

	@Autowired
	private PaymentRest paymentRest;

	/**
	 * Saves a payment order by delegating to the PaymentRest service.
	 * This method takes a PaymentEntity object and attempts to save it,
	 * potentially throwing an exception if the operation fails.
	 *
	 * @param payment The PaymentEntity object that contains payment details to be saved.
	 * @return The saved PaymentEntity object.
	 * @throws Exception if there is an error while saving the payment.
	 */
	public PaymentEntity savePaymentOrder(PaymentEntity payment) throws Exception {
		// Delegate the save operation to the PaymentRest service
		return paymentRest.savePayment(payment);
	}

}
