package org.example.customer;

public class Customer {
    private String name;
    private double balance;

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public boolean hasEnoughBalance(double amount) {
        return balance >= amount;
    }

    public void addBalance(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }


}
