package org.example.models.implementations;

import org.example.models.interfaces.IExpirable;
import org.example.models.interfaces.IShippable;
import org.example.models.interfaces.IShippableItem;

import java.time.LocalDate;

public class ShippableAndExpirableProduct extends Product implements IExpirable, IShippable, IShippableItem {
    private final ShippableImpel shippableImpel;
    private final ExpirableImpel expirableImpel;

    public ShippableAndExpirableProduct(String name, double price, int quantity, ShippableImpel shippableImpel, ExpirableImpel expirableImpel) {
        super(name, price, quantity);
        this.shippableImpel = shippableImpel;
        this.expirableImpel = expirableImpel;
    }


    @Override
    public double getWeight() {
        return shippableImpel.getWeight();
    }

    @Override
    public void setWeight(double weight) {
        shippableImpel.setWeight(weight);
    }

    @Override
    public double calculateShippingCost() {
        return shippableImpel.calculateShippingCost();
    }


    @Override
    public LocalDate getExpirationDate() {
        return expirableImpel.getExpirationDate();
    }

    @Override
    public void setExpirationDate(LocalDate expirationDate) {
        expirableImpel.setExpirationDate(expirationDate);
    }


    @Override
    public boolean isExpired() {
        return expirableImpel.isExpired();
    }
}
