package com.robosoft.departmentserviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DepartmentServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceRegistryApplication.class, args);
	}

}
