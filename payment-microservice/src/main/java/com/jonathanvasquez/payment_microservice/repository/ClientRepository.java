package com.jonathanvasquez.payment_microservice.repository;

import org.springframework.stereotype.Repository;

import com.jonathanvasquez.payment_microservice.entity.ClientEntity;

/**
 * Repository interface for accessing client data. This interface defines the
 * contract for retrieving client entities based on their ID.
 */
@Repository
public interface ClientRepository {

	/**
	 * Retrieves a client entity by its ID. This method could query the database for
	 * find and return a client entity with the specified ID.
	 *
	 * @param clientID The ID of the client to retrieve.
	 * @return The ClientEntity object with the specified ID.
	 * @throws Exception if there is an error during the retrieval process.
	 */
	ClientEntity getClientByID(Long clientID) throws Exception;
}
