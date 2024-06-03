package com.jonathanvasquez.payment_microservice.entity;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemOrderEntity {
	@NotNull(message = "The ID of product cannot be null")
	@Positive(message = "The ID of product must be greater than zero")
	private Long productID;
	@NotNull(message = "The quantity cannot be null")
	@Positive(message = "The quantity must be greater than zero")
	private Integer quantity;
	@NotNull(message = "The unitPrice cannot be null")
	@Positive(message = "The unitPrice must be greater than zero")
	private Double unitPrice;
}