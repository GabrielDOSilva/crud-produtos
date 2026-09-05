package br.com.dev.crudprodutos.service;

import org.springframework.stereotype.Service;

import br.com.dev.crudprodutos.repository.ProductRepository;

@Service
public class ProductService {

	private final ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository) {
		
		this.productRepository = productRepository;
		
	}
	
}
