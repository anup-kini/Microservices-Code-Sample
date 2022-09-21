package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;

@RestController
public class StoreAppClientController {
	
	// RestTemplate is used as a RestClient
	@Autowired
	private ProductService productService;
	
	
	@GetMapping("/get-products")
	public String getAllProducts() {
		
	 	return productService.getProducts();
		
	}
	
	
	@GetMapping("/get-product/{id}")
	public Product getProductById(@PathVariable("id") int id) {
		
	 	Product productDetails = productService.getProductById(id);
		return productDetails;
	}
}
