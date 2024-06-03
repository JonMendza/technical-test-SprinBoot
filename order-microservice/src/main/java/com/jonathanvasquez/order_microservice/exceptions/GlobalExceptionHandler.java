package com.jonathanvasquez.order_microservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.jonathanvasquez.order_microservice.dto.PurcharseOrderResponseDTO;

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
        PurcharseOrderResponseDTO purcharseOrderResponseDTO = new PurcharseOrderResponseDTO();
        purcharseOrderResponseDTO.setCode("400");
        purcharseOrderResponseDTO.setStatus("not created");
        purcharseOrderResponseDTO.setMessage("It was not possible to create the purchase order, it must pass the validations and try again.");
        purcharseOrderResponseDTO.setErrors(errors);
        return new ResponseEntity<>(purcharseOrderResponseDTO, HttpStatus.BAD_REQUEST);
    }
}