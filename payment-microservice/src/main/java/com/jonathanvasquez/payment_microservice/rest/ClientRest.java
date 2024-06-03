package com.jonathanvasquez.payment_microservice.rest;

import org.springframework.stereotype.Service;

import com.jonathanvasquez.payment_microservice.entity.ClientEntity;
import com.jonathanvasquez.payment_microservice.repository.ClientRepository;

@Service
public class ClientRest implements ClientRepository {

	/**
	 * Retrieves a client entity by its ID.
	 * This method simulates the recovery of a client entity from a data source that could be a database or another ENPOINT from an external API.
	 * Creates a new ClientEntity object with predefined values ​​and returns it.
	 *
	 * @param clientID The ID of the client to retrieve.
	 * @return The ClientEntity object with the specified ID.
	 * @throws Exception if there is an error during the recovery process.
	 */
	@Override
	public ClientEntity getClientByID(Long clientID) throws Exception {
		//// Create a new ClientEntity object with hardcoded values
		ClientEntity clientEntity = new ClientEntity();
		clientEntity.setId(Long.valueOf("12"));
		clientEntity.setFirstName("Jonathan");
		clientEntity.setLastName("Vasquez");
		clientEntity.setPhone("70045319");
		clientEntity.setEmail("jonathan96sv@gmail.com");
		
		//return object client
		return clientEntity;
	}

}
