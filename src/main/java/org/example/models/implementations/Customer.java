package org.example.models.implementations;

import java.security.InvalidParameterException;

public class Customer {
    private String name;
    private String email;
    private double balance;
    private Cart cart; // composition


    public Customer(String name, String email, double balance) {
        this.name = name;
        this.email = email;
        this.setBalance(balance);
        this.cart = new Cart();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if(balance < 0) throw new IllegalArgumentException("balance can't be less than 0");
        this.balance = balance;
    }

    public Cart getCart() {
        return cart;
    }
}
