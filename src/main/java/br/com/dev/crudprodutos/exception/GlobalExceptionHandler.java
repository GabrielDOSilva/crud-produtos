package br.com.dev.crudprodutos.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.dev.crudprodutos.dto.ErrorResponseDTO;

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

}
