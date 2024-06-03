package com.jonathanvasquez.product_microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jonathanvasquez.product_microservice.dto.ProductDTO;
import com.jonathanvasquez.product_microservice.dto.ProductsDTO;
import com.jonathanvasquez.product_microservice.service.ProductService;

/**
 * REST controller to manage product related requests.
 * This controller provides endpoints to retrieve a list of products
 * or a specific product by its ID.
 */
@RestController
@RequestMapping("/test")
public class ProductController {

	@Autowired
	private ProductService productService;

	/**
     * Retrieves a list of products.
     * This method handles GET requests to /test/products and returns a list
     * of products according to the specified limit and sort order.
     *
     * @param limit The maximum number of products to return. The default value is 0, which means no limit.
     * @param sort The sort order of the products. The default value is "asc" for ascending order.
     * @return A ProductsDTO object containing the response code, message, and list of products.
     */
	@GetMapping("/products")
	public ProductsDTO getProducts(@RequestParam(required = false, defaultValue = "0") int limit, @RequestParam(required = false, defaultValue = "asc") String sort) {
		ProductsDTO productsDTO = new ProductsDTO();
		try {
			productsDTO.setCode("200");
			productsDTO.setMessage("Successful request.");
			productsDTO.setProducts(
					limit == 0 ? productService.getAllProducts(sort) : productService.getProductByLimit(limit));
		} catch (Exception e) {
			productsDTO.setCode("500");
			productsDTO.setMessage("An error occurred while retrieving the products.");
			productsDTO.setProducts(null);
		}
		return productsDTO;
	}

	/**
     * Retrieves a product by its ID.
     * This method handles GET requests to /test/products/{id} and returns
     * the details of the specified product.
     *
     * @param id The ID of the product to retrieve.
     * @return A ProductDTO object containing the response code, message, and product details.
     */
	@GetMapping("/products/{id}")
	public ProductDTO getProductByID(@PathVariable Long id) {
		ProductDTO productDTO = new ProductDTO();
		try {
			productDTO.setProduct(productService.getProductByID(id));
			productDTO.setCode(productDTO.getProduct() == null ? "404" : "200");
			productDTO
					.setMessage(productDTO.getProduct() == null ? "The product does not exist" : "Successful request.");
		} catch (Exception e) {
			productDTO.setCode("500");
			productDTO.setMessage("An error occurred while retrieving the product.");
			productDTO.setProduct(null);
		}
		return productDTO;
	}
	
}
