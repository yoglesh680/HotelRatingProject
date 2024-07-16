package com.hotalService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HotalApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotalApplication.class, args);
	}

}
