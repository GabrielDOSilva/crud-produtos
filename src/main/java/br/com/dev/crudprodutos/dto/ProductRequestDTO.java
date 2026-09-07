package br.com.dev.crudprodutos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public class ProductRequestDTO {

	@NotBlank
	private String name;
	
	@NotNull
	@Positive
	private Double price;
	
	@NotNull
	@PositiveOrZero
	private Integer quantity;
	
	public ProductRequestDTO() {}

	public ProductRequestDTO(String name, Double price, Integer quantity) {
		
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
	
}
