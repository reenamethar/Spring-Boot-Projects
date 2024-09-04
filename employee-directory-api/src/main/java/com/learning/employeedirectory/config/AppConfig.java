package com.learning.employeedirectory.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.learning.employeedirectory.logging.AppInterceptor;

@Component
public class AppConfig  implements WebMvcConfigurer{
	@Autowired
	AppInterceptor appInterceptor;
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(appInterceptor);
	}

}
