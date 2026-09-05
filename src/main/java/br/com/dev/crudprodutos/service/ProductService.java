package br.com.dev.crudprodutos.service;

import org.springframework.stereotype.Service;

import br.com.dev.crudprodutos.dto.ProductRequestDTO;
import br.com.dev.crudprodutos.dto.ProductResponseDTO;
import br.com.dev.crudprodutos.entity.Product;
import br.com.dev.crudprodutos.repository.ProductRepository;

@Service
public class ProductService {

	private final ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository) {
		
		this.productRepository = productRepository;
		
	}
	
	public ProductResponseDTO create(ProductRequestDTO productRequestDTO) {

	    Product product = new Product();

	    product.setName(productRequestDTO.getName());
	    product.setPrice(productRequestDTO.getPrice());
	    product.setQuantity(productRequestDTO.getQuantity());

	    Product savedProduct = productRepository.save(product);

	    ProductResponseDTO response = new ProductResponseDTO();

	    response.setId(savedProduct.getId());
	    response.setName(savedProduct.getName());
	    response.setPrice(savedProduct.getPrice());
	    response.setQuantity(savedProduct.getQuantity());

	    return response;
	}
		
	
}