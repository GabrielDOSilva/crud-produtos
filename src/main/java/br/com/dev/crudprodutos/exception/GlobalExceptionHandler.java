package br.com.dev.crudprodutos.exception;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponseDTO> handleValidationException(MethodArgumentNotValidException exception) {
		
		String message = exception.getBindingResult()
				.getFieldErrors()
				.stream()
				.map(error -> error.getField() + ": " +
				 error.getDefaultMessage())
				.collect(Collectors.joining(", "));
		
		ErrorResponseDTO error = new ErrorResponseDTO(
				HttpStatus.BAD_REQUEST.value(),
				message,
				LocalDateTime.now()
				);
		
		return ResponseEntity
				.status(HttpStatus.BAD_REQUEST)
				.body(error);
	}

}
