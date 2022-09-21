package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductClientController {

	@Autowired
	private ProductServiceProxy productServiceProxy;
	
	@GetMapping("/get-all-products")
	public List<Product> getAllProducts(){
		
		return productServiceProxy.getAllProducts();
	}
	
	@GetMapping("/get-all-product/{id}")
	public Product getProductById(@PathVariable("id") int id){
		
		return productServiceProxy.getProductById(id);
	}
	
	@GetMapping("/get-product-service")
	public String getProductService(){
		
		return productServiceProxy.index();
	}
	
}
