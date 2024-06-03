package com.jonathanvasquez.order_microservice.dto;

import java.util.List;

import com.jonathanvasquez.order_microservice.entity.ClientEntity;
import com.jonathanvasquez.order_microservice.entity.ItemOrderEntity;
import com.jonathanvasquez.order_microservice.entity.OrderEntity;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PurcharseOrderDTO {
	@Valid
	@NotNull(message = "The client data is required.")
	private ClientEntity client;
	@Valid
	@NotNull(message = "The order data is required.")
	private OrderEntity order;
	@Valid
	@NotNull(message = "The order detail is required.")
	private List<ItemOrderEntity> orderDetail;
}
