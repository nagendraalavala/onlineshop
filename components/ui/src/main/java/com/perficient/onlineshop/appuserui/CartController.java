package com.perficient.onlineshop.appuserui;

import com.perficient.onlineshop.productui.ProductClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

@Controller
public class CartController {
    private CartClient cartClient;
    private ProductClient productClient;

    public CartController(ProductClient productClient) {
        this.productClient = productClient;
        this.cartClient = new CartClient();
    }


    @GetMapping("/cart")
    public String allProducts(Map<String,Object> model) {
        model.put("cart", cartClient.view());
        return "cart";
    }

    @GetMapping("/cart/delete/{id}")
    public String deleteItem(@PathVariable Long id) {
        cartClient.deleteProduct(productClient.view(id));
        return "backtoproducts";
    }

    @GetMapping("/cart/add/{id}")
    public String addItem(@PathVariable Long id) {
        cartClient.addProduct(productClient.view(id));
        return "backtoproducts";
    }



}
