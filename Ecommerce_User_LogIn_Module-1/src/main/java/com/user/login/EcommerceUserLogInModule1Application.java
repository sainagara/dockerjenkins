package com.user.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EcommerceUserLogInModule1Application {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceUserLogInModule1Application.class, args);
	}

}
