package com.jonathanvasquez.payment_microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jonathanvasquez.payment_microservice.dto.PaymentResponseDTO;
import com.jonathanvasquez.payment_microservice.entity.PaymentEntity;
import com.jonathanvasquez.payment_microservice.service.PaymentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/test")
@Validated
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;

	/**
	 * Handles the HTTP POST request for processing a payment.
	 * This method receives a payment entity in the request body,
	 * attempts to save it, and returns a response indicating
	 * whether the operation was successful or not.
	 *
	 * @param payment The PaymentEntity object that contains the information necessary to process the payment..
	 * @return PaymentResponseDTO object containing the response code, message, 
	 *         payment ID (if successful), and any errors.
	 */
	@PostMapping("/payment")
	public PaymentResponseDTO payment(@Valid @RequestBody  PaymentEntity payment) {
		//object that contains the response sent to the client informing whether the payment was processed or not
		PaymentResponseDTO paymentResponseDTO = new PaymentResponseDTO();
		try {
			//saved payment
			paymentService.savePaymentOrder(payment);
			
			//If the payment has been registered successfully, a success response is prepared
			paymentResponseDTO.setCode("200");
			paymentResponseDTO.setMessage("Payment registered successfully.");
			paymentResponseDTO.setId(payment.getId());
			paymentResponseDTO.setErrors(null);
		}catch(Exception e) {
			//If the payment has not been registered successfully, an error response is prepared
			paymentResponseDTO.setCode("500");
			paymentResponseDTO.setMessage("Payment could not be processed.");
			paymentResponseDTO.setId(null);
			paymentResponseDTO.setErrors(null);
		}
		//returning payment response
		return paymentResponseDTO;
	}
}
