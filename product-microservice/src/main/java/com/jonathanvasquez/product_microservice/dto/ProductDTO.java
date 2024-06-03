package com.jonathanvasquez.product_microservice.dto;

import com.jonathanvasquez.product_microservice.entity.ProductEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {
	private String code;
	private String message;
	private ProductEntity product;

}
