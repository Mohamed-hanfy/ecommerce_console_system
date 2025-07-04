package org.example.product;

import org.example.product.expire.ExpireStrategy;
import org.example.product.shipping.ShippableItems;
import org.example.product.shipping.ShippingStrategy;

public class Product {
    private String name;
    private double price;
    private int quantity;

    private ExpireStrategy expireStrategy;
    private ShippingStrategy shippingStrategy;


    public Product(String name, double price, int quantity, ExpireStrategy expireStrategy, ShippingStrategy shippingStrategy) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.expireStrategy = expireStrategy;
        this.shippingStrategy = shippingStrategy;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void decrementQuantity(int amount) {
        quantity -= amount;
    }

    public boolean isExpired() {
        return expireStrategy.isExpired();
    }

    public boolean isShippable() {
        return shippingStrategy.isShippable();
    }

    public double getWeight() {
        return shippingStrategy.getWeight();
    }

    public ShippableItems toshippableItems(int quantity) {
        if(!isShippable()) {
            return null;
        }
        return new ShippableItems() {
            public String getName() {
                return name;
            }
            public double getWeight() {
                return shippingStrategy.getWeight() * quantity;
            }
        };
    }
}
