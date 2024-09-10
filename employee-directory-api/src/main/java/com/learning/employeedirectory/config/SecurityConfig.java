package com.learning.employeedirectory.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	private CustomAccessDeniedHandler customAccessDeniedHandler;
	private CustomAuthenticationEntryPoint customAuthenticationEntryPoint;
	private CustomAuthenticationFailureHandler customAuthenticationFailureHandler;
	@Autowired
	public SecurityConfig(CustomAccessDeniedHandler theCustomAccessDeniedHandler, CustomAuthenticationEntryPoint theCustomAuthenticationEntryPoint, CustomAuthenticationFailureHandler theCustomAuthenticationFailureHandler) {
		customAccessDeniedHandler = theCustomAccessDeniedHandler;
		customAuthenticationEntryPoint = theCustomAuthenticationEntryPoint;
		customAuthenticationFailureHandler = theCustomAuthenticationFailureHandler;
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(authorize -> authorize
				.requestMatchers("/actuator/health/**").permitAll() // Public access to health endpoints
				.requestMatchers("/actuator/**").hasRole("ADMIN") // ther actuator endpoints require admin role
				.requestMatchers(HttpMethod.GET, "/api/v1/employees/swagger").permitAll()
				.requestMatchers(HttpMethod.GET, "/api/v1/employees/swagger-ui/**").permitAll()
				.requestMatchers(HttpMethod.GET, "/api/v1/employees/api-docs/**").permitAll()
				.anyRequest().authenticated()
				);
		http.httpBasic();
		http.exceptionHandling(exception->exception
				.accessDeniedHandler(customAccessDeniedHandler)
				.authenticationEntryPoint(customAuthenticationEntryPoint)
				);
		http.formLogin(login-> login
				.failureHandler(customAuthenticationFailureHandler));
		http.csrf(csrf->csrf.disable());
		
		return http.build();
		
	}

}
