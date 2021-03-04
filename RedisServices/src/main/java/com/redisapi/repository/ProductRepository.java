package com.redisapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.redisapi.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, String> {

}
