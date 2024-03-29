package com.horizon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
public class Horizon2Application{

	private static final Logger LOGGER=LoggerFactory.getLogger(Horizon2Application.class);
	public static void main(String[] args) {
		SpringApplication.run(Horizon2Application.class, args);
		LOGGER.info("Simple log statement with inputs {}, {} and {}", 1,2,3);
	}
	
	@Bean
	public Docket api() { 
		return new Docket(DocumentationType.SWAGGER_2)  
	    .select()                                  
	    .apis(RequestHandlerSelectors.any())              
	    .paths(PathSelectors.any())                          
	    .build();                                           
	}
}
