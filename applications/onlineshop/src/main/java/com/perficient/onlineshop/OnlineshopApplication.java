package com.perficient.onlineshop;

import com.perficient.onlineshop.appuserui.AppUserClient;
import com.perficient.onlineshop.productui.ProductClient;
import com.perficient.onlineshop.transactionui.TransactionClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class OnlineshopApplication {

	@Value("${appusers.ms.url")
	private String appUserURL;
	@Value("${products.ms.url")
	private String productURL;
	@Value("${transactions.ms.url")
	private String transactionURL;

	public static void main(String[] args)
	{
		SpringApplication.run(OnlineshopApplication.class, args);
	}

	@Bean
	public RestOperations restOperations() {
		return new RestTemplate();
	}
	@Bean
	public AppUserClient appUserClient(RestOperations restOperations) {
		return new AppUserClient(appUserURL, restOperations);
	}
	@Bean
	public ProductClient productClient(RestOperations restOperations) {
		return new ProductClient(productURL, restOperations);
	}
	@Bean
	public TransactionClient transactionClient(RestOperations restOperations) {
		return new TransactionClient(transactionURL, restOperations);
	}

}
