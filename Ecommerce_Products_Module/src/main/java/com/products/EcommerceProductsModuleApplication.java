package com.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EcommerceProductsModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceProductsModuleApplication.class, args);
	}

}
