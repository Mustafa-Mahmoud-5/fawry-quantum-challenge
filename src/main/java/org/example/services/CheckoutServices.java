package org.example.services;

import org.example.models.implementations.Cart;
import org.example.models.implementations.Product;

import java.util.Map;

public class CheckoutServices {

    ShippingServices shippingServices;

    public  CheckoutServices(ShippingServices shippingServices) {
        this.shippingServices = shippingServices;
    }

    // the only interface(public method the user interacts with to make a checkout)
    public void checkout(Cart cart) {
        shippingServices.printShipmentNotice(cart.getShippableItems());
        printCheckoutReceipt(cart.getProductItems());
        printCostSummary(cart);
    }

    private void printCostSummary(Cart cart) {
        System.out.println("----------------------");
        double subtotal = cart.calculateSubtotalCost();
        System.out.println("Subtotal " + subtotal);

        double shipping = shippingServices.calculateShippingCost(cart.getShippableProductsList());
        System.out.println("Shipping " + shipping);

        double total = subtotal + shipping;
        System.out.println("Amount " + total);
    }

    private void printCheckoutReceipt(Map<Product, Integer> allItems) {
        System.out.println("** Checkout receipt **");

        for (Map.Entry<Product, Integer> entry : allItems.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            double itemTotal = product.getPrice() * quantity;
            System.out.println(quantity + "x " + product.getName() + " " + itemTotal);
        }

        System.out.println();
    }


}
