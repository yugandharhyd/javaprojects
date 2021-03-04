package com.redisapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

@Configuration
@EnableRedisRepositories(basePackages =  {
        "com.redisapi.repository"
    })
public class RedisConfig {
	
	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
	    return new JedisConnectionFactory();
	}

	@Bean
	public RedisTemplate<String, Object> redisTemplate() {
	    RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
	    redisTemplate.setConnectionFactory(jedisConnectionFactory());
	    redisTemplate.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));
	    return redisTemplate;
	}
	
}
