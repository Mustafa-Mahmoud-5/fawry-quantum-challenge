package org.example.models.implementations;

import org.example.models.interfaces.IShippable;
import org.example.models.interfaces.IShippableItem;

public class ShippableImpel implements IShippable {
    private double weight; // in grams

    public ShippableImpel(double weight) {
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public double calculateShippingCost() {
        return weight * 3.5; // each gram costs 1.5 egps
    }
 }

