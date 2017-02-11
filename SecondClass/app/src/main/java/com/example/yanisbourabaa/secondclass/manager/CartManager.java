package com.example.yanisbourabaa.secondclass.manager;

import com.example.yanisbourabaa.secondclass.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yanisbourabaa on 10/02/2017.
 */

public class CartManager {

    Map<Integer, Product> cart = new HashMap<>();

    private static CartManager mCartManager = new CartManager();

    public static CartManager getInstance() {
        return mCartManager;
    }

    private CartManager() {

    }

    public void updateCart(Product product) {
        cart.put(product.getId(), product);
    }

    public int getQuantity(int id) {
        if (cart.containsKey(id)) {
            return cart.get(id).getQuantity();
        }
        return 0;
    }

    public void addProduct(Product currentProduct) {
        currentProduct.setQuantity(getQuantity(currentProduct.getId()) + 1);
        cart.put(currentProduct.getId(), currentProduct);
    }

    public void removeProduct(Product currentProduct) {
        if (cart.containsKey(currentProduct.getId())) {
            int quantity = getQuantity(currentProduct.getId());
            if (quantity == 0)
                return;
            currentProduct.setQuantity(quantity - 1);
            cart.put(currentProduct.getId(), currentProduct);
        }
    }


    public List<Product> getCart() {
        return new ArrayList<>(cart.values());
    }

    public Float getFinalPrice() {
        List<Product> products = getCart();
        Float result = 0.0f;
        for (Product p : products) {
            result += p.getPrice() * p.getQuantity();
        }
        return result;
    }

    public void clearCart() {
        cart = new HashMap<>();
    }
}
