package br.com.dev.crudprodutos.exception;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.converter.HttpMessageNotReadableException;

import br.com.dev.crudprodutos.dto.ErrorResponseDTO;
import br.com.dev.crudprodutos.dto.ValidationErrorDTO;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ErrorResponseDTO> handleProductNotFound(
			ProductNotFoundException exception){
		ErrorResponseDTO error = new ErrorResponseDTO(
				HttpStatus.NOT_FOUND.value(), 
				exception.getMessage(), 
				LocalDateTime.now()
				);
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponseDTO> handleValidationException(
	        MethodArgumentNotValidException exception) {

	    List<ValidationErrorDTO> errors = exception.getBindingResult()
	            .getFieldErrors()
	            .stream()
	            .map(error -> new ValidationErrorDTO(
	                    error.getField(),
	                    error.getDefaultMessage()))
	            .toList();

	    ErrorResponseDTO response = new ErrorResponseDTO(
	            HttpStatus.BAD_REQUEST.value(),
	            "Validation failed",
	            LocalDateTime.now(),
	            errors
	    );

	    return ResponseEntity
	            .status(HttpStatus.BAD_REQUEST)
	            .body(response);
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ErrorResponseDTO> handleHttpMessageNotReadable(
	        HttpMessageNotReadableException exception) {

	    ErrorResponseDTO error = new ErrorResponseDTO(
	            HttpStatus.BAD_REQUEST.value(),
	            "Invalid request body",
	            LocalDateTime.now()
	    );

	    return ResponseEntity.badRequest().body(error);
	}

}
