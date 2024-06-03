package com.jonathanvasquez.product_microservice.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jonathanvasquez.product_microservice.entity.ProductEntity;
import com.jonathanvasquez.product_microservice.rest.ProductClientRest;

/**
 * Service class to manage product-related operations. This service acts as an
 * intermediary between the data controller and ProductClientRest, Provide
 * methods to retrieve product data.
 */
@Service
public class ProductService {

	@Autowired
	private ProductClientRest ProductClientRest;

	/**
	 * Recupera todos los productos, opcionalmente ordenados. Este método delega la
	 * operación a ProductClientRest para recuperar todos los productos con el orden
	 * de clasificación especificado.
	 *
	 * @param sort El orden de clasificación de los productos (por ejemplo, "asc"
	 *             para ascendente o "desc" para descendente).
	 * @return Una lista de objetos ProductEntity.
	 * @throws Excepción si hay un error durante el proceso de recuperación.
	 */
	public List<ProductEntity> getAllProducts(String sort) throws Exception {
		return ProductClientRest.getAllProducts(sort);
	}

	  /**
     * Retrieves a product entity by its ID.
     * This method delegates the operation to the ProductClientRest to retrieve
     * the product with the specified ID.
     *
     * @param id The ID of the product to retrieve.
     * @return The ProductEntity object with the specified ID.
     * @throws Exception if there is an error during the retrieval process.
     */
	public ProductEntity getProductByID(Long id) throws Exception {
		return ProductClientRest.getProductByID(id);
	}

	/**
     * Retrieves a limited number of products.
     * This method delegates the operation to the ProductClientRest to retrieve
     * a limited number of products.
     *
     * @param limit The maximum number of products to return.
     * @return A list of ProductEntity objects.
     * @throws Exception if there is an error during the retrieval process.
     */
	public List<ProductEntity> getProductByLimit(int limit) throws Exception {
		return ProductClientRest.getProductByLimit(limit);
	}
}
