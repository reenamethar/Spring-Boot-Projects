package com.learning.employeedirectory.config;

import org.springframework.boot.actuate.autoconfigure.security.reactive.EndpointRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ActuatorSecurityConfig {
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(authorizeRequest ->authorizeRequest
				.requestMatchers("/actuator/health/**").permitAll() // Public access to health endpoints
				.requestMatchers("/actuator/**").hasRole("ADMIN") // ther actuator endpoints require admin role
				.anyRequest().authenticated() // Other requests require authentication
				).httpBasic(); // Use HTTP Basic Authentication
		return http.build();
		
	}
	

}
