package com.kgisl.springdataquerymethods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@OpenAPIDefinition
@EnableAspectJAutoProxy(proxyTargetClass=true) 
public class SpringdataquerymethodsApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringdataquerymethodsApplication.class, args);

	}
}
