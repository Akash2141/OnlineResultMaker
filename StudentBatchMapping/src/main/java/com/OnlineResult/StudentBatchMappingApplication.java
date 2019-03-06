package com.OnlineResult;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class StudentBatchMappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentBatchMappingApplication.class, args);
	}

}
