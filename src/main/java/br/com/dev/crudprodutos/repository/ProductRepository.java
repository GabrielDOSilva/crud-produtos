package br.com.dev.crudprodutos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dev.crudprodutos.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
