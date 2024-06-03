package com.jonathanvasquez.order_microservice.entity;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientEntity {

	@NotNull(message = "The ID of client cannot be null")
	@Positive(message = "The ID of client must be greater than zero")
	private Long id;
	@NotEmpty(message = "The first name is required.")
	@Size(min = 2, max = 100, message = "The length of first name must be between 2 and 50 characters.")
	private String firstName;
	@NotEmpty(message = "The last name is required.")
	@Size(min = 2, max = 100, message = "The length of last name must be between 2 and 50 characters.")
	private String lastName;
	@NotEmpty(message = "The email is required.")
	@Size(min = 2, max = 100, message = "The length of email must be between 2 and 100 characters.")
	private String email;
	@NotEmpty(message = "The phone is required.")
	@Size(min = 8, max = 8, message = "The length of phone must be between 2 and 100 characters.")
	private String phone;
}

