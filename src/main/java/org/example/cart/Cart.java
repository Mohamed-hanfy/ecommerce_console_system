package org.example.cart;

import org.example.product.Product;
import org.example.product.shipping.ShippableItems;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Cart {

    private final Map<Product, Integer> items = new LinkedHashMap<>();

    public void addProduct(Product product, int quantity) {
        if(quantity <= 0) {
            assert false : "Quantity must be greater than zero";
        }

        if(product.getQuantity() < quantity) {
            assert false : "Quantity must be less than or equal to the available quantity" + product.getName();
        }

        if(product.isExpired()) {
            assert false : "Product is expired " + product.getName();
        }
        items.merge(product, quantity, Integer::sum);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public double getSubtotal() {
        return items.entrySet()
                .stream()
                .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue()).sum();

    }

    public Map<Product, Integer> getItems() {
        return items;
    }

    public List<ShippableItems> getShippableItems() {
        List<ShippableItems> items = new ArrayList<>();
        for(Map.Entry<Product, Integer> entry : this.items.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            if(product.isShippable()) {
                items.add(product.toshippableItems(quantity));
            }
        }
        return items;
    }

}
