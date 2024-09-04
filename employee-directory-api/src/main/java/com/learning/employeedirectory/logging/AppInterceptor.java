package com.learning.employeedirectory.logging;

import java.util.UUID;

import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AppInterceptor implements HandlerInterceptor {
	@Autowired
	public Environment env;
	private String TRACE_HEADER ="x-correlation-id";
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		String correlationId = UUID.randomUUID().toString();
		if(request.getHeader(TRACE_HEADER) != null) {
			correlationId = request.getHeader(TRACE_HEADER);
		}
		MDC.put("correlationId", correlationId);
		MDC.put("applicationName", env.getProperty("spring.application.name"));
		MDC.put("environment", env.getProperty("spring.profiles.active"));
		response.setHeader(TRACE_HEADER, correlationId);
		return true;
	} 
}
