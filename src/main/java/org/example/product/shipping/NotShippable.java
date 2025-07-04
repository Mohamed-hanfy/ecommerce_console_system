package org.example.product.shipping;

public class NotShippable implements ShippingStrategy{

    @Override
    public boolean isShippable() {
        return false;
    }

    @Override
    public double getWeight() {
        return 0;
    }

}
