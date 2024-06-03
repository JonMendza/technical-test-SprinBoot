package com.jonathanvasquez.order_microservice.dto;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PurcharseOrderResponseDTO {
	private String code;
	private String message;
	private String status;
	private Long orderNumber;
	private Map<String, String> errors;
}
