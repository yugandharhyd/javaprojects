package com.redisapi.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication(scanBasePackages = {
        "com.redisapi.app",
        "com.redisapi.config",
        "com.redisapi.controller",
        "com.redisapi.service",
        "com.redisapi.model"
    })
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class RedisServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisServicesApplication.class, args);
	}

}
