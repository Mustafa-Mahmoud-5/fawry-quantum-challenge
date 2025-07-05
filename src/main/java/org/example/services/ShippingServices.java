package org.example.services;

import org.example.models.implementations.Cart;
import org.example.models.implementations.Product;
import org.example.models.interfaces.IShippableItem;

import java.util.List;
import java.util.Map;

public class ShippingServices {
    private double PRICE_PER_GRAM = 0.5;

    private double calculateShippingWeight(List<IShippableItem> shappableItems) {
        double totalWeight = 0.0;
        for (IShippableItem item : shappableItems) {
            totalWeight += item.getWeight();
        }
        return totalWeight;
    }


    public double calculateShippingCost (List<IShippableItem> shappableItems) {
        return calculateShippingWeight(shappableItems) * PRICE_PER_GRAM;
    }


    // map of ite quantities is easier to be dealt with in this view
    public void printShipmentNotice(Map<IShippableItem, Integer> shippableItems) {
        System.out.println("** Shipment notice **");
        double totalWeight = 0.0;

        for (Map.Entry<IShippableItem, Integer> entry : shippableItems.entrySet()) {
            IShippableItem item = entry.getKey();
            int quantity = entry.getValue();

            double weight = item.getWeight();
            totalWeight += weight * quantity;

            System.out.println(quantity + "x " + item.getName() + " " + weight*quantity + "g");
        }

        System.out.println("Total package weight " + totalWeight/1000 + "kg");
        System.out.println();
    }
}
