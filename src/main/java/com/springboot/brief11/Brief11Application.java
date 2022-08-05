package com.springboot.brief11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan({"controller.EmployeeController","service.EmployeeService"})

public class Brief11Application {

	public static void main(String[] args) {
		SpringApplication.run(Brief11Application.class, args);
	}

}
