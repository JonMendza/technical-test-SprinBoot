package com.jonathanvasquez.payment_microservice.entity;

import java.util.Date;

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
public class OrderEntity {

	private Long id;
	private Long idCliente;
	@NotNull(message = "The order date cannot be null")
	private Date orderDate;
	private String status;
	private Double discount;
	@NotNull(message = "The subtotal cannot be null")
	@Positive(message = "The subtotal must be greater than zero")
	private Double subTotal;
	private Double totalPay;

}