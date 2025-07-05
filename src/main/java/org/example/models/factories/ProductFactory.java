package org.example.models.factories;

import org.example.models.implementations.*;

import java.time.LocalDate;

class ProductFactory {
    public static Product createBasicProduct(String name, double price, int quantity) {
        return new Product(name, price, quantity);
    }

    public static ShippableProduct createShippableProduct(String name, double price, int quantity, double weight) {
        return new ShippableProduct(name, price, quantity, new ShippableImpel(weight));
    }

    public static ExpirableProduct createExpirableProduct(String name, double price, int quantity, LocalDate expirationDate) {
        return new ExpirableProduct(name, price, quantity, new ExpirableImpel(expirationDate));
    }
    public static ShippableAndExpirableProduct createShippableExpirableProduct(
            String name,
            double price,
            int quantity,
            double weight,
            LocalDate expirationDate) {
        return new ShippableAndExpirableProduct(name, price, quantity, new ShippableImpel(weight), new ExpirableImpel(expirationDate));
    }
}
