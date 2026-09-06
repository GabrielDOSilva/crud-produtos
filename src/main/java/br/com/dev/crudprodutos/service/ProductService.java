package br.com.dev.crudprodutos.service;

import java.util.List;
import java.util.Optional;

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
	
	public List<ProductResponseDTO> findAll(){
		
		List<Product> products = productRepository.findAll();
		
		return products.stream()
	            .map(product -> {
	                ProductResponseDTO response = new ProductResponseDTO();

	                response.setId(product.getId());
	                response.setName(product.getName());
	                response.setPrice(product.getPrice());
	                response.setQuantity(product.getQuantity());

	                return response;
	            })
	            .toList();
		
	}
	
	public ProductResponseDTO findById(Long id) {
		
		Optional<Product> optionalProduct = productRepository.findById(id);
		
		Product product = optionalProduct
				.orElseThrow(() -> new RuntimeException("Product not found!"));
		
		ProductResponseDTO response = new ProductResponseDTO();
		
		response.setId(product.getId());
		response.setName(product.getName());
		response.setPrice(product.getPrice());
		response.setQuantity(product.getQuantity());
		
		return response;
		
	}
	
	public ProductResponseDTO update(Long id, ProductRequestDTO productRequestDTO) {
		
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Product not found!"));
		
		product.setName(productRequestDTO.getName());
		product.setPrice(productRequestDTO.getPrice());
		product.setQuantity(productRequestDTO.getQuantity());
		
		Product updateProduct = productRepository.save(product);
		
		ProductResponseDTO response = new ProductResponseDTO();
		
		response.setName(updateProduct.getName());
		response.setPrice(updateProduct.getPrice());
		response.setQuantity(updateProduct.getQuantity());
		
		return response;
		
	}
	
	public void delete(Long id) {
		
		Product product = productRepository.findById(id).orElseThrow(() -> new 
				RuntimeException("Product not Found"));
		
		productRepository.delete(product);
		
		
	}
	
}