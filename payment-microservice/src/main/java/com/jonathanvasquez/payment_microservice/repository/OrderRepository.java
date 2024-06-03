package com.jonathanvasquez.payment_microservice.repository;

import org.springframework.stereotype.Repository;

import com.jonathanvasquez.payment_microservice.entity.OrderEntity;

/**
 * Repository interface to access purchase order data. This interface defines
 * the logic to retrieve order entities based on their identification.
 */
@Repository
public interface OrderRepository {

	/**
	 * Retrieves an order entity by its ID. This method would query the database for
	 * find and return an order entity with the specified ID.
	 *
	 * @param orderID The ID of the order to retrieve.
	 * @return The OrderEntity object with the specified ID.
	 * @throws Exception if there is an error during the recovery process.
	 */
	OrderEntity getOrderByID(Long orderID) throws Exception;
}
