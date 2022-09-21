package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.domain.Product;

@RestController
public class StoreAppClientController {
	
	// RestTemplate is used as a RestClient
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private DiscoveryClient client;
	
	@GetMapping("/get-products")
	public String getAllProducts() {
		
		System.out.println(client.getInstances("product-service").stream().findFirst().get().getPort());
	 	return restTemplate.getForObject("http://product-service", String.class);
		
	}
	
	
	@GetMapping("/get-product/{id}")
	public Product getProductById(@PathVariable("id") int id) {
		
	 	
	 	Product productDetails = restTemplate.getForObject("http://product-service/products/"+id, Product.class);
		return productDetails;
	}
}
