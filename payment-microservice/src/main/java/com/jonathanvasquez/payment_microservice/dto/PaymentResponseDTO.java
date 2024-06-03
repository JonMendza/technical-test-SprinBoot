package com.jonathanvasquez.payment_microservice.dto;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentResponseDTO {
	private Long id;
	private String code;
	private String message;
	private Map<String, String> errors;
}
