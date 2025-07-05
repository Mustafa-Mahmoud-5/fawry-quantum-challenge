package org.example;

import org.example.models.factories.ProductFactory;
import org.example.models.implementations.Cart;
import org.example.models.implementations.Customer;
import org.example.models.implementations.Product;
import org.example.services.CartServices;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            // create a user, the cart-customer is a composition relationship
            Customer customer = new Customer("Mustafa", "mustafa.mahmoud@test.com", 3000);

            // create some products of different types
            Product cheese = ProductFactory.createShippableExpirableProduct("cheese", 5, 8, 500, LocalDate.of(2025, 7, 20));
            Product tv = ProductFactory.createShippableProduct("tv", 100, 10, 1000);
            Product scratchCard = ProductFactory.createBasicProduct("scratchCard", 20, 6);


            // add few items to cart

            CartServices cartServices = new CartServices(customer);

            cartServices.addToCart(cheese, 2);
            cartServices.addToCart(cheese, 5);
            cartServices.addToCart(cheese, 1);
//            cartServices.removeFromCart(cheese, 9); // test if remove works correctly

            cartServices.addToCart(tv, 3);
            cartServices.addToCart(scratchCard, 6);


            // make a checkout

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}