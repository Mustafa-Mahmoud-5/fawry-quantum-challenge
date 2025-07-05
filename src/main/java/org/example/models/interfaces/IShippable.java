package org.example.models.interfaces;

public interface IShippable {
    double getWeight();
    void setWeight(double weight);
    double calculateShippingCost();
}
