package com.jonathanvasquez.payment_microservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.jonathanvasquez.payment_microservice.dto.PaymentResponseDTO;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        PaymentResponseDTO paymentResponseDTO = new PaymentResponseDTO();
        paymentResponseDTO.setCode("400");
        paymentResponseDTO.setMessage("It was not possible to process the payment, you must pass the validations and try again.");
        paymentResponseDTO.setErrors(errors);
        return new ResponseEntity<>(paymentResponseDTO, HttpStatus.BAD_REQUEST);
    }
}