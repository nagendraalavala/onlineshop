package com.perficient.onlineshop.product;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class ProductController {
    private ProductRepo productRepo;

    public ProductController(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }
    @GetMapping("/products")
    public String allProducts(Map<String,Object> model) {
        model.put("products", productRepo.findAll());
        return "products";
    }
}
