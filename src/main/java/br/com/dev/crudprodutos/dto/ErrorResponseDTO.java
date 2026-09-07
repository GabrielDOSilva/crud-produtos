package br.com.dev.crudprodutos.dto;

import java.time.LocalDateTime;
import java.util.List;

public class ErrorResponseDTO {
	
	private int status;
	private String message;
	private LocalDateTime timestamp;
	private List<ValidationErrorDTO> erros;
	
	public ErrorResponseDTO(
	        int status,
	        String message,
	        LocalDateTime timestamp) {

	    this.status = status;
	    this.message = message;
	    this.timestamp = timestamp;
	}
	
	public ErrorResponseDTO(int status, String message, LocalDateTime timestamp, List<ValidationErrorDTO> erros) {
		
		this.status = status;
		this.message = message;
		this.timestamp = timestamp;
		this.erros = erros;
	}


	public int getStatus() {
		return status;
	}


	public String getMessage() {
		return message;
	}


	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	
	public List<ValidationErrorDTO> getErros(){
		return erros;
	}


}
