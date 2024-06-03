package com.jonathanvasquez.order_microservice.rest;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.jonathanvasquez.order_microservice.entity.OrderEntity;
import com.jonathanvasquez.order_microservice.repository.OrderRepository;

/**
 * Service class implementing the OrderRepository interface for managing order-related operations.
 * This service class provides methods to save orders.
 */
@Service
public class OrderRest implements OrderRepository {

	/**
     * Save an order.
     * This method generates a random order ID and sets the order status to "Registered".
     *
     * @param order The OrderEntity object that represents the order to save.
     * @return The OrderEntity object after saving.
     * @throws Exception if there is an error during the save process.
     */
	@Override
	public OrderEntity saveOrder(OrderEntity order) throws Exception {
		Random range = new Random(System.currentTimeMillis());
		int orderID = range.nextInt(1,100);
		order.setId((long) orderID);
		order.setStatus("Registered");
		return order;
	}

}
