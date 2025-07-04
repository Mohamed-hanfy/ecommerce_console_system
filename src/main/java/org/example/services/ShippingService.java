package org.example.services;

import org.example.product.shipping.ShippableItems;

import java.util.List;

public class ShippingService {
    private static double costPerPound = 2.0;
    public static double shipOrder(List<ShippableItems> items) {
        if(items.isEmpty()) {
            return 0;
        }
        double totalWeight = items.stream().mapToDouble(ShippableItems::getWeight).sum();

        for(ShippableItems item : items) {
            System.out.println(item.getName() + " " + item.getWeight());
        }

        return totalWeight * costPerPound;
    }

}