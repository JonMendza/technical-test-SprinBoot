package com.jonathanvasquez.product_microservice.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jonathanvasquez.product_microservice.entity.ProductEntity;

/**
 * Repository interface to access product data.
 * This interface defines the methods to retrieve product entities,
 * including get all products, get a product by its ID and get
 * a limited number of products.
 */
@Repository
public interface ProductRepository {

	
	List<ProductEntity> getAllProducts(String sort) throws Exception;

	ProductEntity getProductByID(Long id) throws Exception;
	
	public List<ProductEntity> getProductByLimit(int limit) throws Exception;
}
