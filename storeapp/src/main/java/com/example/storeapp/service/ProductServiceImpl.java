package com.example.storeapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.storeapp.domain.Product;
import com.example.storeapp.repository.IProductRepository;

@Service
public class ProductServiceImpl implements IProductService {

	
	@Autowired
	private IProductRepository productRepository;
	
	
	@Override
	public Product addProduct(Product product) {	
		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(Product product) {
		
		return productRepository.save(product);
	}

	@Override
	public void deleteProduct(Integer id) {
		
		productRepository.deleteById(id);
	}

	@Override
	public Product getProduct(Integer id) {
		
		return productRepository.findById(id).get();
	}

	@Override
	public List<Product> getAllProducts() {
		
		return productRepository.findAll();
	}

}
