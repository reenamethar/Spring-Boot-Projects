package com.learning.employeedirectory.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.security.reactive.EndpointRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ActuatorSecurityConfig {
	private CustomAccessDeniedHandler customAccessDeniedHandler;
	private CustomAuthenticationEntryPoint customAuthenticationEntryPoint;
	private CustomAuthenticationFailureHandler customAuthenticationFailureHandler;
	@Autowired
	public ActuatorSecurityConfig(CustomAccessDeniedHandler theCustomAccessDeniedHandler, CustomAuthenticationEntryPoint theCustomAuthenticationEntryPoint, CustomAuthenticationFailureHandler theCustomAuthenticationFailureHandler) {
		customAccessDeniedHandler = theCustomAccessDeniedHandler;
		customAuthenticationEntryPoint = theCustomAuthenticationEntryPoint;
		customAuthenticationFailureHandler = theCustomAuthenticationFailureHandler;
	}

	public SecurityFilterChain filterChainActuator(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(authorizeRequest ->authorizeRequest
				.requestMatchers("/actuator/health/**").permitAll() // Public access to health endpoints
				.requestMatchers("/actuator/**").hasRole("ADMIN") // ther actuator endpoints require admin role
				.anyRequest().authenticated() // Other requests require authentication
				).exceptionHandling(exception->exception
						.accessDeniedHandler(customAccessDeniedHandler)
						.authenticationEntryPoint(customAuthenticationEntryPoint)
						)
		.httpBasic(); // Use HTTP Basic Authentication
		return http.build();
		
	}
	

}
