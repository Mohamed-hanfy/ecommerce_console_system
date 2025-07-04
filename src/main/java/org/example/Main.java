package org.example;

import org.example.cart.Cart;
import org.example.customer.Customer;
import org.example.product.Product;
import org.example.product.expire.Expirable;
import org.example.product.expire.NonExpirable;
import org.example.product.shipping.Shippable;
import org.example.product.shipping.NotShippable;
import org.example.services.CheckoutService;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Test Case 1: Normal Checkout with Mixed Products ===\n");


        Product cheese = new Product("Cheese", 100.0, 10, new Expirable(LocalDate.of(2025, 7, 11)), new Shippable(0.2));
        Product tv = new Product("TV", 3000.0, 5, new NonExpirable(), new Shippable(10.0));
        Product scratchCard = new Product("Scratch Card", 50.0, 100, new NonExpirable(), new NotShippable());


        Customer customer = new Customer("Mo7amed", 5000.0);

        Cart cart = new Cart();
        cart.addProduct(cheese, 2);
        cart.addProduct(tv, 1);
        cart.addProduct(scratchCard, 3);

        System.out.println("Customer: " + customer.getName());
        System.out.println("Initial balance: " + customer.getBalance() + " EGP");
        System.out.println("\nCart contents:");
        cart.getItems().forEach((product, quantity) -> {
            System.out.println("- " + product.getName() + " x" + quantity + " @ " + product.getPrice() + " EGP each");
        });


        System.out.println("\n ** CHECKOUT PROCESS **");
        CheckoutService.checkout(customer, cart);
    }
}