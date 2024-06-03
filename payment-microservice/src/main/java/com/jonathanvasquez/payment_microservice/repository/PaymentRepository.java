package com.jonathanvasquez.payment_microservice.repository;

import org.springframework.stereotype.Repository;
import com.jonathanvasquez.payment_microservice.entity.PaymentEntity;

/**
 * Repository interface to access and manage payment data. This interface
 * defines the methods to process payments.
 */
@Repository
public interface PaymentRepository {
	/**
	 * Save a payment entity in the database. This method attempts to save the
	 * provided payment entity and returns the saved entity with its generated ID.
	 *
	 * @param payment The PaymentEntity object containing the payment details to
	 *                save.
	 * @return The saved PaymentEntity object.
	 * @throws Exception if there is an error during the save operation.
	 */
	PaymentEntity savePayment(PaymentEntity payment) throws Exception;

}
