package com.jonathanvasquez.product_microservice.dto;

import java.util.List;

import com.jonathanvasquez.product_microservice.entity.ProductEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductsDTO {
	private String code;
	private String message;
	private List<ProductEntity> products;

}
