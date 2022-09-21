package com.example.demo;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@FeignClient("product-service")
public interface ProductServiceProxy {

	@GetMapping("/products")
	public List<Product> getAllProducts();
	
	@GetMapping
	public String index();
	
	@GetMapping("/products/{id}")
	public Product getProductById(@PathVariable("id") Integer id);
	
	@ResponseStatus(value = HttpStatus.OK)
	@DeleteMapping("/products/{id}")
	public void deleteProductById(@PathVariable("id") Integer id);
	
	@ResponseStatus(value = HttpStatus.OK)
	@PutMapping("/products")
	public Product updateProduct(@RequestBody Product product);
	
	@ResponseStatus(value = HttpStatus.OK)
	@PostMapping("/products")
	public Product addProduct(@RequestBody Product product);
}
