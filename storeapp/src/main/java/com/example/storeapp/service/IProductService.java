package com.example.storeapp.service;

import java.util.List;

import com.example.storeapp.domain.Product;

public interface IProductService {

	Product addProduct(Product product);
	Product updateProduct(Product product);
	void deleteProduct(Integer id);
	Product getProduct(Integer id);
	List<Product> getAllProducts();
}
