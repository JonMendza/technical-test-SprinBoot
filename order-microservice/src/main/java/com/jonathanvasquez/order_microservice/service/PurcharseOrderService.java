package com.jonathanvasquez.order_microservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jonathanvasquez.order_microservice.dto.PurcharseOrderDTO;
import com.jonathanvasquez.order_microservice.rest.OrderDetailRest;
import com.jonathanvasquez.order_microservice.rest.OrderRest;

/**
 * Service class for managing purchase order-related operations.
 * This service class provides methods to save purchase orders.
 */
@Service
public class PurcharseOrderService {

	@Autowired
	private OrderDetailRest orderDetailRest;

	@Autowired
	private OrderRest orderRest;

	/**
     * Saves a purchase order.
     * This method saves the provided PurcharseOrderDTO by first saving the order details
     * and then saving the order itself. It returns the updated PurcharseOrderDTO.
     *
     * @param purcharseOrder The PurcharseOrderDTO object containing the details of the purchase order to be saved.
     * @return The updated PurcharseOrderDTO object after saving the purchase order.
     * @throws Exception if there is an error during the save process.
     */
	public PurcharseOrderDTO savePurcharseOrder(PurcharseOrderDTO purcharseOrder) throws Exception {
		// Save order 
		purcharseOrder.setOrder(orderRest.saveOrder(purcharseOrder.getOrder()));
		// Save order details
		orderDetailRest.saveDetailOrder(purcharseOrder.getOrderDetail());
		return purcharseOrder;
	}

}
