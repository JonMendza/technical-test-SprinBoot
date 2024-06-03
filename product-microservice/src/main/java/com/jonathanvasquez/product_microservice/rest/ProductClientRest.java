package com.jonathanvasquez.product_microservice.rest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jonathanvasquez.product_microservice.entity.ProductEntity;
import com.jonathanvasquez.product_microservice.repository.ProductRepository;

@Service
public class ProductClientRest implements ProductRepository {
	@Autowired
	private RestTemplate restTemplate;

	private static final String BASE_URL_FAKE_STORE = "https://fakestoreapi.com/products";

	/**
     * Retrieves all products, optionally sorted.
     * This method queries the Fake-Store API to find and return a list of all product entities.
     * sorted according to the specified sort order.
     *
     * @param sort The sort order of the products (for example, "asc" for ascending or "desc" for descending).
     * @return A list of ProductEntity objects.
     * @throws Exception if there is an error during the recovery process.
     */
	@Override
	public List<ProductEntity> getAllProducts(String sort) throws Exception {
		String url = BASE_URL_FAKE_STORE + "?sort=" + sort;
		ProductEntity[] productArray = restTemplate.getForObject(url, ProductEntity[].class);
		if (productArray != null) {
			return Arrays.asList(productArray);
		} else {
			return null;
		}
	}

	/**
     * Retrieves a product entity by its ID.
     * This method queries the Fake-store API to find and return a product entity with the specified ID.
     *
     * @param id The ID of the product to retrieve.
     * @return The ProductEntity object with the specified ID.
     * @throws Exception if there is an error during the recovery process.
     */
	@Override
	public ProductEntity getProductByID(Long id) throws Exception {
		String url = BASE_URL_FAKE_STORE + "/" + id;
		return restTemplate.getForObject(url, ProductEntity.class);
	}
	

	/**
     * Recovers a limited number of products.
     * This method queries the Fake-store API to find and return a list of product entities,
     * limited to specified number of products.
     *
     * @param limit The maximum number of products to return.
     * @return A list of ProductEntity objects.
     * @throws Exception if there is an error during the recovery process.
     */
	@Override
	public List<ProductEntity> getProductByLimit(int limit) throws Exception {
		String url = BASE_URL_FAKE_STORE + "?limit=" + limit;
		ProductEntity[] productArray = restTemplate.getForObject(url, ProductEntity[].class);
		if (productArray != null) {
			return Arrays.asList(productArray);
		} else {
			return null;
		}
	}
}
