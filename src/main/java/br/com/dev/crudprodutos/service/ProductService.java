package br.com.dev.crudprodutos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.dev.crudprodutos.dto.ProductRequestDTO;
import br.com.dev.crudprodutos.dto.ProductResponseDTO;
import br.com.dev.crudprodutos.entity.Product;
import br.com.dev.crudprodutos.exception.ProductNotFoundException;
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

	    return toResponseDTO(savedProduct);
	}
	
	public List<ProductResponseDTO> findAll(){
		
		List<Product> products = productRepository.findAll();
		
		return products.stream()
	            .map(this::toResponseDTO)
	            .toList();
		
	}
	
	public ProductResponseDTO findById(Long id) {
		
		Optional<Product> optionalProduct = productRepository.findById(id);
		
		Product product = optionalProduct
				.orElseThrow(() -> new ProductNotFoundException("Product not found!"));
		
		return toResponseDTO(product);
		
	}
	
	public ProductResponseDTO update(Long id, ProductRequestDTO productRequestDTO) {
		
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ProductNotFoundException("Product not found!"));
		
		product.setName(productRequestDTO.getName());
		product.setPrice(productRequestDTO.getPrice());
		product.setQuantity(productRequestDTO.getQuantity());
		
		Product updateProduct = productRepository.save(product);
		
		return toResponseDTO(updateProduct);
		
	}
	
	public void delete(Long id) {
		
		Product product = productRepository.findById(id).orElseThrow(() -> new 
				ProductNotFoundException("Product not Found"));
		
		productRepository.delete(product);
		
		
	}
	
	private ProductResponseDTO toResponseDTO(Product product) {
		
		ProductResponseDTO response = new ProductResponseDTO();
		
		response.setId(product.getId());
		response.setName(product.getName());
		response.setPrice(product.getPrice());
		response.setQuantity(product.getQuantity());
		
		return response;
	}
	
}