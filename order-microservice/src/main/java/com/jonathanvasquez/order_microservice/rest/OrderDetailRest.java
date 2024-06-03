package com.jonathanvasquez.order_microservice.rest;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jonathanvasquez.order_microservice.entity.ItemOrderEntity;
import com.jonathanvasquez.order_microservice.repository.OrderDetailRepository;

/**
 * Service class implementing the OrderDetailRepository interface for managing order detail-related operations.
 * This service class provides methods to save order details.
 */
@Service
public class OrderDetailRest implements OrderDetailRepository {

	/**
     * Save order details.
     * This method simply returns the provided list of order details entities but here would be the logic to store them in the database or in an external API.
     *
     * @param orderDetail The list of ItemOrderEntity objects that represent the order details to save.
     * @return The same list of ItemOrderEntity objects after saving.
     * @throws Exception if there is an error during the save process.
     */
	@Override
	public List<ItemOrderEntity> saveDetailOrder(List<ItemOrderEntity> orderDetail) throws Exception {
		return orderDetail;
	}

}
