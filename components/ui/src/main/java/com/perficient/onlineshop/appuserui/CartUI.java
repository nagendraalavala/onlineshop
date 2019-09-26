package com.perficient.onlineshop.appuserui;

import com.perficient.onlineshop.productui.ProductUI;

import java.util.ArrayList;
import java.util.List;

public class CartUI {
    private List<ProductUI> items;
    private double total;

    public CartUI(){
        items = new ArrayList<>();
        total = 0;
    }

    public CartUI(List<ProductUI> items) {
        this.items = items;
        double total = items.stream().mapToDouble(ProductUI::getPdcost).sum();
        this.total = total;
    }

    public List<ProductUI> getItems() {
        return items;
    }

    public void addItem(ProductUI productUI) {
        items.add(productUI);
        total += productUI.getPdcost();
    }

    public void deleteItem(ProductUI productUI){
        items.remove(productUI);
        total -= productUI.getPdcost();
    }

    public double getTotal() {
        return total;
    }
}
