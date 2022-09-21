package com.example.demo.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.domain.Product;


@Service
public class ProductService {

	@Autowired
	private RestTemplate restTemplate;

	public String getPort() {
		return restTemplate.getForObject("http://product-service", String.class);
	}

	public String getProducts() {
		return restTemplate.getForObject("http://product-service/products", String.class);
	}
	
	public String fallbackMethodForgetProducts() {
		return Arrays.asList(new Product(11111,"Default Product",34444.555,"Default Category")).toString();
	}

	public Product getProductById(int id) {
		return restTemplate.getForObject("http://product-service/products/"+id, Product.class);
	}
	
	
	public Product fallbackMethodForgetProductById(int id) {
		return new Product(1111,"Default Product",2303.33,"Default Category");
	}
	

}
