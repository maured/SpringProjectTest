package com.edeal.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
 
@SpringBootApplication(scanBasePackages = {"com.edeal.connector"})
public class Application{
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
}
