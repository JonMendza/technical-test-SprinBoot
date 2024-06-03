package com.jonathanvasquez.product_microservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductEntity {
	private Long id;
	private String title;
	private Double price;
	private String description;
	private String category;
	private String image;
	private RatingEntity rating;

}
