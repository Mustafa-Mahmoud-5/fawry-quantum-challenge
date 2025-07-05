package org.example.models.implementations;

import java.util.HashMap;
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
}
