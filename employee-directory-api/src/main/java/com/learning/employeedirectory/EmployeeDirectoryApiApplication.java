package com.learning.employeedirectory;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class EmployeeDirectoryApiApplication {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeDirectoryApiApplication.class);
	
	public static void main(String[] args) {
		MDC.put("correlationId", UUID.randomUUID().toString());
        MDC.put("applicationName", "employee-directory-api");
        /*
         * Also we cannot put spring managed beans here, those will not be initialized at this point (Environment)
         * In Spring Boot, beans (including the Environment bean) are only available after the Spring context has been initialized, which happens inside the SpringApplication.run call.
         * The MDC (Mapped Diagnostic Context) is thread-local, which means it only applies within the current thread where it is set. If you're setting MDC values in an interceptor or filter that handles HTTP requests, those values will not be available in the main method of your Spring Boot application since the main method is executed in the main thread before any HTTP requests are processed.
         * Thus setting those values here also
         * */
		SpringApplication.run(EmployeeDirectoryApiApplication.class, args);
		logger.info("Hello in the main class");
	}

}
