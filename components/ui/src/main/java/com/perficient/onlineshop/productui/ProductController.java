package com.perficient.onlineshop.productui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class ProductController {
    private ProductClient productClient;

    public ProductController(ProductClient productClient) {
        this.productClient = productClient;
    }
    @GetMapping("/products")
    public String allProducts(Map<String,Object> model) {
        model.put("products", productClient.findAll());
        return "products";
    }
}
