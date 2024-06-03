package com.jonathanvasquez.payment_microservice.rest;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jonathanvasquez.payment_microservice.entity.OrderEntity;
import com.jonathanvasquez.payment_microservice.entity.PaymentEntity;
import com.jonathanvasquez.payment_microservice.repository.PaymentRepository;


/**
 * PaymentRepository interface service implementation.
 * This service manages the saving of the payment.
 *if and only if the associated order exists before payment is processed.
 */
@Service
public class PaymentRest implements PaymentRepository {
	@Autowired
	private OrderRest orderRest;

	/**
     * Save a payment entity in the database.
     * This method checks if the associated order exists before saving
    
     *
     * @param payment The PaymentEntity object containing the payment details to save.
     * @return The PaymentEntity object updated with a set ID and status if the order exists. 
     * or null if the order does not exist.
     * @throws Exception if there is an error during the save operation.
     */
	@Override
	public PaymentEntity savePayment(PaymentEntity payment) throws Exception {
		// Checking if the order exists
		OrderEntity orderEntity = orderRest.getOrderByID(payment.getOrderID());
		if(orderEntity != null && orderEntity.getId() != null) {
			//Here it would be saved in the base or in an external API, 
			//for this example predefined values ​​have been defined
			Random range = new Random(System.currentTimeMillis());
			int paymentID = range.nextInt(1,100);
			payment.setId((long) paymentID);
			payment.setStatus("Paid");
		}
		return payment;
	}

}
