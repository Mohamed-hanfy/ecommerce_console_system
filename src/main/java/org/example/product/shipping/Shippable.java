package org.example.product.shipping;

public class Shippable implements ShippingStrategy{
    private final double weight;
    
    public Shippable(double weight) {
        this.weight = weight;
    }
    @Override
    public boolean isShippable() {
        return true;
    }
    
    @Override
    public double getWeight() {
        return weight;
    }
}
