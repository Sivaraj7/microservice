package com.example.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
public class MicroserviceApplication {
	public static void main(String[] args) {
		SpringApplication.run(MicroserviceApplication.class, args);
	}
}

@RestController
@RequestMapping("/api")
class HelloController {

	@GetMapping("/hello")
	public String hello() {
		return "Hello from Microservice!";
	}

	@GetMapping("/health")
	public String health() {
		return "OK";
	}
}
