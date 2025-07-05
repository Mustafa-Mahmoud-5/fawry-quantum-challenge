package org.example.models.implementations;

import org.example.models.interfaces.IShippableItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    private final Map<Product, Integer> productItems ; // product item: count

    public  Cart () {
        this.productItems  = new HashMap<>();
    }

    public void addItem(Product product, int qty) {
        if(isItemExists(product)) {
            int oldQty = productItems.get(product);
            int newQty = oldQty +  qty;
            productItems.put(product, newQty);
        } else {
            productItems.put(product, qty);
        }
    }


    public void removeItem(Product product, int qty) {
        if(isItemExists(product)) {
            int currentQty = productItems.get(product);
            int newQty = currentQty - qty;
            if(newQty <= 0) { // avoid leaving an item with qty 0
                productItems.remove(product);
            } else {
                productItems.put(product, newQty);
            }
        }
    }

    public boolean  isEmpty() {
        return productItems.isEmpty();
    }

    public int getProductQuantity(Product product) {
        Integer qty = productItems.get(product);
        return qty != null ? qty : 0;
    }
    public boolean  isItemExists(Product product) {
        Integer p = productItems.get(product);
        return p != null;
    }

    public Map<Product, Integer> getProductItems() {
        return productItems;
    }


    public Map<IShippableItem, Integer> getShippableItems() {
        Map<IShippableItem, Integer> shippableItems = new HashMap<>();
        for (Map.Entry<Product, Integer> item : productItems.entrySet()) {
            Product product = item.getKey();
            int quantity = item.getValue();

            // check if the product implements IShippable
            if (product instanceof IShippableItem) {
                shippableItems.put((IShippableItem) product, quantity);
            }
        }
        return shippableItems;
    }

    // return the actual items needs to be shipped as a list
    public List<IShippableItem> getShippableProductsList() {
        List<IShippableItem> shippableItems = new ArrayList<>();

        for (Map.Entry<Product, Integer> entry : productItems.entrySet()) {
            Product p = entry.getKey();
            int q = entry.getValue();
            if (p instanceof IShippableItem item) {
                for (int i = 0; i < q; i++) {
                    shippableItems.add(item);
                }
            }
        }

        return shippableItems;
    }

    // we need to calculate basic cost of all items in the list
    public double calculateSubtotalCost() {
        double subtotal = 0.0;
        for (Map.Entry<Product, Integer> entry : productItems.entrySet()) {
            Product p = entry.getKey();
            int quantity = entry.getValue();
            double productCost = p.getPrice() * quantity;
            subtotal += productCost;
        }

        return subtotal;
    }
}
