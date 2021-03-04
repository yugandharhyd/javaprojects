package com.redisapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redisapi.model.Product;
import com.redisapi.repository.ProductRepository;

@Service
public class RedisService {
	
	@Autowired
	ProductRepository productRepository;
	
	public Product save(Product product) {
		return productRepository.save(product);
	}
	
	public Optional<Product> findById(String id) {
		return productRepository.findById(id);
	}

	public Iterable<Product> findAll() {
		return productRepository.findAll();
	}
	
	public void deleteById(String id) {
		 productRepository.deleteById(id);
	}
	
}
