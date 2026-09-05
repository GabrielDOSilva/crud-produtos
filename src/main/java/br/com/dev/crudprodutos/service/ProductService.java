package br.com.dev.crudprodutos.service;

import org.springframework.stereotype.Service;

import br.com.dev.crudprodutos.dto.ProductResquestDTO;
import br.com.dev.crudprodutos.entity.Product;
import br.com.dev.crudprodutos.repository.ProductRepository;

@Service
public class ProductService {

	private final ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository) {
		
		this.productRepository = productRepository;
		
	}
	
	public Product create(ProductResquestDTO productresquestDTO) {
		Product product = new Product();
		
		product.setName(productresquestDTO.getName());
		product.setPrice(productresquestDTO.getPrice());
		product.setQuantity(productresquestDTO.getQuantity());
		
		return productRepository.save(product);
		
	}
		
	
}