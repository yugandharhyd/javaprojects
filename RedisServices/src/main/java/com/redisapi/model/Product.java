package com.redisapi.model;

import java.io.Serializable;

import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@RedisHash("Product")
@AllArgsConstructor
@Getter
@Setter
public class Product implements Serializable {
  
    /**
	 * 
	 */
	private static final long serialVersionUID = 7748329361059526953L;

	private String id;
    
    private String name;

}