package com.securityserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SecurityserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityserverApplication.class, args);
	}
}
