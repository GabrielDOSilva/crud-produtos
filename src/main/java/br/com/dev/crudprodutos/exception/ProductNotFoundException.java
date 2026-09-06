package br.com.dev.crudprodutos.exception;

public class ProductNotFoundException  extends RuntimeException{
	
	public ProductNotFoundException(String message) {
		super(message);
	}

}
