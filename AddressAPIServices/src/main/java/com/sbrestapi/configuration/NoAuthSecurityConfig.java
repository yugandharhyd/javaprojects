package com.sbrestapi.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
* <h1>NoAuthSecurityConfig profile can used 
* if authorization is not required for services!</h1>
* 
* @author  Yugandhara Reddy Kuraakula 
* @version 1.0
* @since   2021-02-07
*/

@Configuration
@EnableWebSecurity
@Order(1000)
@Profile(ProfileTypes.NO_AUTH)
public class NoAuthSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		
		// Disable CSRF
		httpSecurity.csrf().disable()
				// Permit all requests without authentication
				.authorizeRequests().anyRequest().permitAll();
		
		httpSecurity.headers().frameOptions().disable();
	}
}
