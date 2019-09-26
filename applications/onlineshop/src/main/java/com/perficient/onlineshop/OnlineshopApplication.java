package com.perficient.onlineshop;

import com.perficient.onlineshop.appuserui.AppUserClient;
import com.perficient.onlineshop.productui.ProductClient;
import com.perficient.onlineshop.transactionui.TransactionClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@SpringBootApplication
public class OnlineshopApplication {


	public static void main(String[] args)
	{
		SpringApplication.run(OnlineshopApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestOperations restOperations() {
		return new RestTemplate();
	}

	@Bean
	public AppUserClient appUserClient(RestOperations restOperations) {
		return new AppUserClient("//appusers-ms/appusers", restOperations);
	}

	@Bean
	public ProductClient productClient(RestOperations restOperations) {
		return new ProductClient("//products-ms/products", restOperations);
	}

	@Bean
	public TransactionClient transactionClient(RestOperations restOperations) {
		return new TransactionClient("//transactions-ms/transactions", restOperations);
	}

}
