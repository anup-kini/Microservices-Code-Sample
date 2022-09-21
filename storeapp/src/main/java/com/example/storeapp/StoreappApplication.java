package com.example.storeapp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.storeapp.domain.Product;
import com.example.storeapp.repository.IProductRepository;

@RestController
@EnableEurekaClient
@SpringBootApplication
public class StoreappApplication implements CommandLineRunner {

	@Autowired
	IProductRepository productRepository;
	
	@Value("${server.port:8080}")
	private int port;
	
	public static void main(String[] args) {
		SpringApplication.run(StoreappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		productRepository.save(new Product(null,"Iphone", 130000.00, "Mobile"));
		productRepository.save(new Product(null,"Oppo 37", 15000.00, "Mobile"));
		productRepository.save(new Product(null,"Mac Book Pro", 233000.00, "Laptop"));
		productRepository.save(new Product(null,"LG TV", 60000.00, "Electronics"));
		System.out.println("Inserted the data in DB.."); 
	}
	
	@GetMapping
	public String index() {
		return "Product Service Running at port :"+port;
	}

}
