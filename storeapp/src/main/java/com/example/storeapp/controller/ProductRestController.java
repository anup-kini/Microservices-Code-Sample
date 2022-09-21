package com.example.storeapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.storeapp.domain.Product;
import com.example.storeapp.service.IProductService;

@RestController
@RequestMapping("/products")
public class ProductRestController {

	@Autowired
	private IProductService productService;
	
	@GetMapping
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}

	@GetMapping("/{id}")
	public Product getProductById(@PathVariable("id") Integer id){
		return productService.getProduct(id);
	}
	
	@ResponseStatus(value = HttpStatus.OK)
	@DeleteMapping("/{id}")
	public void deleteProductById(@PathVariable("id") Integer id){
		 productService.deleteProduct(id);
	}
	
	@ResponseStatus(value = HttpStatus.OK)
	@PutMapping
	public Product updateProduct(@RequestBody Product product){
		return productService.updateProduct(product);
	}
	
	@ResponseStatus(value = HttpStatus.OK)
	@PostMapping
	public Product addProduct(@RequestBody Product product){
		return productService.addProduct(product);
	}
}
