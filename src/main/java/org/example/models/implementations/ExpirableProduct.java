package org.example.models.implementations;

import org.example.models.interfaces.IExpirable;

import java.time.LocalDate;

public class ExpirableProduct extends Product implements IExpirable {

    // iam using composition to stick to the Open/closed and DRY principle
    // 1- i don't have to repeat the implementation in both ExpirableProduct and ShippableAndExpirableProduct
    // 2- if the implementation changes. this class and ShippableAndExpirableProduct will not get changed
    // as they are just wr  appers for the expirableImpel interface methods

    private final ExpirableImpel expirableImpel;

    public ExpirableProduct(String name, double price, int quantity, ExpirableImpel expirableImpel) {
        super(name, price, quantity);
        this.expirableImpel = expirableImpel;
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
