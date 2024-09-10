package com.learning.employeedirectory.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Employee Directory API", version = "1.0.0"))
public class SwaggerConfig {
	// to make swagger use basic authentication
	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.components(new Components().addSecuritySchemes(
						"basicScheme", new SecurityScheme().type(SecurityScheme.Type.HTTP)
						.scheme("basic")
						)).addSecurityItem(new SecurityRequirement().addList("basicScheme"))
				;
				
	}
	

}
