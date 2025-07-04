package org.example.services;

import org.example.cart.Cart;
import org.example.customer.Customer;
import org.example.product.Product;

import java.util.Map;

public class CheckoutService {
    public static void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            assert false : "Cart is empty";
        }

        for (var entry : cart.getItems().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            if (product.isExpired()) {
                assert false : "Product is expired " + product.getName();
            }
            if (product.getQuantity() < quantity) {
                assert false : "Quantity must be less than or equal to the available quantity" + product.getName();
            }
        }
        double subtotal = cart.getSubtotal();
        double shippingCost = ShippingService.shipOrder(cart.getShippableItems());
        double total = subtotal + shippingCost;

        if (!customer.hasEnoughBalance(total)) {
            assert false : "Customer does not have enough balance";
        }
        customer.withdraw(total);

        for (Map.Entry<Product, Integer> item : cart.getItems().entrySet()) {
            item.getKey().decrementQuantity(item.getValue());
        }

        System.out.println("** Checkout receipt **");
        for (Map.Entry<Product, Integer> item : cart.getItems().entrySet()) {
            Product product_item = item.getKey();
            int quantity_item = item.getValue();
            System.out.printf("%s x %d - %.2f\n", product_item.getName(), quantity_item, product_item.getPrice() * quantity_item);
        }

        System.out.println("----------------------");
        System.out.printf("Subtotal: %.2f\n", subtotal);
        System.out.printf("Shipping: %.2f\n", shippingCost);
        System.out.printf("Amount: %.2f\n", total);
        System.out.printf("Remaining Balance: %.2f\n", customer.getBalance());
    }
}