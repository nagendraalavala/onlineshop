package com.perficient.onlineshop.product;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ProductInitialList {

    public List<Product> asList() {
        return Arrays.asList(new Product("Electronics", "Iphone", 1000, "New iphone 11", 50),
                new Product("Furniture", "Dresser", 100, "New design", 100),
                new Product("Furniture", "Couch", 700, "Sectional Sofa", 25),
                new Product("Clothing", "Shirt", 25, "Comes in black, white, or grey", 125)
        );
    }
}
