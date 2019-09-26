package com.perficient.onlineshop.productui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class ProductController {
    private ProductClient productClient;

    public ProductController(ProductClient productClient) {
        this.productClient = productClient;
    }
    @GetMapping("/products")
    public String allProducts(Map<String,Object> model) {
        model.put("products", productClient.getAll());
        return "products";
    }

    @GetMapping("/products/{id}")
    public String getUser(Map<String,Object> model, @PathVariable Long id) {
        model.put("viewproduct", productClient.view(id));
        return "viewproduct";
    }

    @GetMapping("/products/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        productClient.delete(id);
        return "backtoproducts";
    }



}
