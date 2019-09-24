package com.perficient.onlineshop;

import com.example.onlineshop.Appuserui.AppUserController;
import com.example.onlineshop.Appuserui.AppuserClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class OnlineshopApplication {

	@Value("${appusers.ms.url")
	private String appuserurl;

	public static void main(String[] args)
	{
		SpringApplication.run(OnlineshopApplication.class, args);
	}
	@Bean
	public ServletRegistrationBean registerActionServlet(AppUserController appUserController) {
		return new ServletRegistrationBean(appUserController, "/Appusers/*");
	}
	@Bean
	public RestOperations restOperations() {
		return new RestTemplate();
	}
	@Bean
	public AppuserClient appuserClient(RestOperations restOperations) {
		return new AppuserClient(appuserurl, restOperations);
	}

}
