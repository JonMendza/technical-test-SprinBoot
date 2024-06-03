package com.jonathanvasquez.payment_microservice.entity;

import java.util.Date;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
public class PaymentEntity {

	private Long id;
	@NotNull(message = "The ID of order cannot be null")
	@Positive(message = "The ID of order must be greater than zero")
	private Long orderID;
	@NotNull(message = "The payment date cannot be null")
	private Date paymentDate;
	@NotEmpty(message = "The card holder is required.")
	@Size(min = 2, max = 100, message = "The length of card holder must be between 2 and 50 characters.")
	private String cardHolder;
	@NotEmpty(message = "The lasf four digits card is required.")
	@Size(min = 4, max = 4, message = "The length lasf four digits card must be between 4 and 4 characters.")
	@Pattern(regexp = "\\d{4}", message = "The last four digits of the card must be numeric.")
	private String lastFourDigits;
	@Min(value = 1, message = "The expiration month must be greater than 0.")
	@Max(value = 12, message = "The expiration month must be less than or equal to 12.")
	private int expirationMonth;
	@Positive(message = "The expiration year card must be greater than zero")
	private int expirationYear;
	@NotEmpty(message = "The cvv card is required.")
	@Size(min = 3, max = 3, message = "The length cvv card must be between 3 and 3 characters.")
	@Pattern(regexp = "\\d{3}", message = "The last three digits of the cvv card must be numeric.")
	private String cvv;
	@NotNull(message = "The subtotal cannot be null")
	@Positive(message = "The subtotal must be greater than zero")
	private Double total;
	private String status;
}
