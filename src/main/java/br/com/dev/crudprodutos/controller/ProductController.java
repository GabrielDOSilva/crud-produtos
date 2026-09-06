package br.com.dev.crudprodutos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dev.crudprodutos.dto.ProductRequestDTO;
import br.com.dev.crudprodutos.dto.ProductResponseDTO;
import br.com.dev.crudprodutos.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> create(
            @RequestBody ProductRequestDTO productRequestDTO) {

        ProductResponseDTO response = productService.create(productRequestDTO);

        return ResponseEntity.ok(response);
    }
}