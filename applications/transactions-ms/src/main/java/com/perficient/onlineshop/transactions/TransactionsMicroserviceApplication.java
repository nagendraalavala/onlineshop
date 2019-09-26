package com.perficient.onlineshop.transactions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class TransactionsMicroserviceApplication {
    public static void main(String... args) {
        SpringApplication.run(TransactionsMicroserviceApplication.class, args);
    }
}