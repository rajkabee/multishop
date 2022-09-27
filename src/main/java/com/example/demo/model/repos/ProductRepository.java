package com.example.demo.model.repos;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	public List<Product> findByCategoryId(long id, Pageable pageable);
}
