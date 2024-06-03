package com.jonathanvasquez.order_microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jonathanvasquez.order_microservice.dto.PurcharseOrderDTO;
import com.jonathanvasquez.order_microservice.dto.PurcharseOrderResponseDTO;
import com.jonathanvasquez.order_microservice.service.PurcharseOrderService;

import jakarta.validation.Valid;

/**
 * REST controller for managing purchase order-related requests.
 * This controller provides endpoints to add purchase orders.
 */
@RestController
@RequestMapping("/test")
@Validated
public class PurcharseOrderController {

	@Autowired
	private PurcharseOrderService purcharseOrderService;
	
	/**
     * Adds a purchase order.
     * This method handles POST requests to /test/addPurcharseOrder and adds
     * a purchase order based on the provided PurcharseOrderDTO.
     *
     * @param purcharseOrderDTO The PurcharseOrderDTO object containing the details of the purchase order to be added.
     * @return A PurcharseOrderResponseDTO object containing the response status, order number, code, errors, and message.
     */
	@PostMapping("/addPurcharseOrder")
	public PurcharseOrderResponseDTO addPurcharseOrder(@Valid @RequestBody PurcharseOrderDTO purcharseOrderDTO) {
		PurcharseOrderResponseDTO purcharseOrderResponseDTO = new PurcharseOrderResponseDTO();
		try {
			// Attempt to save the purchase order
			purcharseOrderDTO = purcharseOrderService.savePurcharseOrder(purcharseOrderDTO);
			
			// Set response details from the saved purchase order
			purcharseOrderResponseDTO.setStatus(purcharseOrderDTO.getOrder().getStatus());
			purcharseOrderResponseDTO.setOrderNumber(purcharseOrderDTO.getOrder().getId());
			purcharseOrderResponseDTO.setCode("200");
			purcharseOrderResponseDTO.setErrors(null);
			purcharseOrderResponseDTO.setMessage("order successfully registered.");
		}catch(Exception e) {
			// Handle exceptions during order registration
			purcharseOrderResponseDTO.setStatus(null);
			purcharseOrderResponseDTO.setOrderNumber(null);
			purcharseOrderResponseDTO.setCode("500");
			purcharseOrderResponseDTO.setErrors(null);
			purcharseOrderResponseDTO.setMessage("An error occurred while registering the order.");
		}
		return purcharseOrderResponseDTO;
	}

}
