package br.com.dev.crudprodutos.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dev.crudprodutos.dto.ProductRequestDTO;
import br.com.dev.crudprodutos.dto.ProductResponseDTO;
import br.com.dev.crudprodutos.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> create(
            @RequestBody @Valid ProductRequestDTO productRequestDTO) {

        ProductResponseDTO response = productService.create(productRequestDTO);

        return ResponseEntity.ok(response);
    }
    
    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> findAll() {

        List<ProductResponseDTO> products = productService.findAll();

        return ResponseEntity.ok(products);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> findById(@PathVariable Long id) {
    	
    	ProductResponseDTO response = productService.findById(id);
    	return ResponseEntity.ok(response);
    	
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> update(@PathVariable Long id,
    		@RequestBody @Valid ProductRequestDTO productRequestDTO) {
    	
    	ProductResponseDTO response = productService.update(id, productRequestDTO);
    	
    	return ResponseEntity.ok(response);
    	
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
    	
    	productService.delete(id);
    	
    	return ResponseEntity.noContent().build();
    	
    }
    
}