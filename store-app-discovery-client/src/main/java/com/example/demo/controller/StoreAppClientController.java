package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class StoreAppClientController {

	@Autowired
	private DiscoveryClient discoveryClient;
	
	// RestTemplate is used as a RestClient
	RestTemplate restTemplate = new RestTemplate();
	
	@GetMapping("/get-product/{id}")
	public String getProductById(@PathVariable("id") int id) {
		
	 	 List<ServiceInstance> instances = discoveryClient.getInstances("product-service");
		 
	 	 for (ServiceInstance serviceInstance : instances) {
			
	 		  System.out.println("Instance Port : "+serviceInstance.getPort());
	 		  System.out.println("Instance URI : "+serviceInstance.getUri());
	 		 System.out.println("Instance Host : "+serviceInstance.getHost());
	 		 System.out.println("---Metadata---");
	 		 System.out.println(serviceInstance.getMetadata());
		}
	 	 
	 	 String productDetails = restTemplate.getForObject(instances.get(0).getUri().toString()+"/products/"+id, String.class);
	 	 
		 return "Product Details"+productDetails;
	}
}
