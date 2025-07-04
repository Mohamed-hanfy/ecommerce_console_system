package org.example.product.shipping;

public interface ShippingStrategy {
    boolean isShippable();
    double getWeight();
}
