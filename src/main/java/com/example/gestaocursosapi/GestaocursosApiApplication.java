package com.example.gestaocursosapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.example.gestaocursosapi.config.property.GestaoCursosApiProperty;

@SpringBootApplication
@EnableConfigurationProperties(GestaoCursosApiProperty.class)
public class GestaocursosApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestaocursosApiApplication.class, args);
	}
}
