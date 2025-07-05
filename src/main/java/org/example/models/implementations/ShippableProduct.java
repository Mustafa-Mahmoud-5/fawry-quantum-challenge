package org.example.models.implementations;

import org.example.models.interfaces.IShippable;
import org.example.models.interfaces.IShippableItem;

// ShippableProduct is also a IShippableItem(). an interface that has just getWeight() and getName()
// Shippable  implements both getWeight() and already implements getName() as being inherited from product attributes

public class ShippableProduct extends Product implements IShippable, IShippableItem {
    ShippableImpel shippableImpel;

    public ShippableProduct(String name, double price, int quantity, ShippableImpel shippableImpel) {
        super(name, price, quantity);
        this.shippableImpel = shippableImpel;
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
}
