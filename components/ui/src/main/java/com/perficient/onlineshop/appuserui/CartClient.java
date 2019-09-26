package com.perficient.onlineshop.appuserui;

import com.perficient.onlineshop.productui.ProductUI;

public class CartClient {
    private CartUI cart;

    public CartClient(){
        cart = new CartUI();
    }

    public CartClient(CartUI cart) {
        this.cart = cart;
    }

    public void addProduct(ProductUI productUI) {
        cart.addItem(productUI);
    }

    public CartUI view() {
        return cart;
    }

    public void deleteProduct(ProductUI productUI) {
        cart.deleteItem(productUI);
    }


//    public int countAll() {
//        return restOperations.getForEntity(productURL + "/count", Integer.class).getBody();
//    }
//
//    public List<ProductUI> findAll() {
//        String URI = UriComponentsBuilder.fromUriString(productURL).toUriString();
//        return restOperations.exchange(URI, HttpMethod.GET, null, productListType).getBody();
//    }
//
//    public List<ProductUI> findRange(String field, String key) {
//        String URI = UriComponentsBuilder.fromUriString(productURL)
//                .queryParam("field", field)
//                .queryParam("key", key)
//                .toUriString();
//        return restOperations.exchange(URI, HttpMethod.GET, null, productListType).getBody();
//    }
}


