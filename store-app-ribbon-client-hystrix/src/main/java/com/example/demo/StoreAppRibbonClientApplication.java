package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

import com.netflix.ribbon.proxy.annotation.Hystrix;

@EnableHystrixDashboard
@EnableHystrix
@EnableEurekaClient
@SpringBootApplication
public class StoreAppRibbonClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreAppRibbonClientApplication.class, args);
	}

}
