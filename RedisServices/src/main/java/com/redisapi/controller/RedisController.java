package com.redisapi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redisapi.model.Product;
import com.redisapi.service.RedisService;

@RestController
@RequestMapping("/redis")
public class RedisController {
	
	@Autowired
	RedisService redisService;

	@GetMapping("/test")
	public String test() {
		return "Service mapping is working fine";
	}
	
	@PostMapping("/save")
	public String save(@RequestBody final Product product) {
		return redisService.save(product) + " product saved successfully.";
	}

	@GetMapping("/findById/{id}")
	public Optional<Product> findById(@PathVariable("id") final String id) {
		return redisService.findById(id);
	}

	@GetMapping("/findAll")
	public Iterable<Product> findAll() {
		return redisService.findAll();
	}

	@DeleteMapping("/deleteById/{id}")
	public String deleteById(@PathVariable("id") final String id) {
		redisService.deleteById(id);
		return "Product deleted successfully by an Id:"+id;
	}

}
