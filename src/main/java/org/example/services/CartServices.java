package org.example.services;

import org.example.models.implementations.Customer;
import org.example.models.implementations.Product;
import org.example.models.interfaces.IExpirable;

public class CartServices {
    Customer customer; // customer contains the cart

    public CartServices(Customer customer) {
        this.customer = customer;
    }

    public void addToCart(Product product, int qty) throws Exception {
        if (product.getQuantity() <= 0) {
            throw new IllegalArgumentException("Product is out of stock");
        }

        if (product.getQuantity() - qty < 0) {
            throw new IllegalArgumentException("Product has less quantity than the quantity being added");
        }

        if (product instanceof IExpirable) {
            IExpirable expirableProduct = (IExpirable) product;
            if (expirableProduct.isExpired()) throw new Exception("Product is already expired");
        }

        customer.getCart().addItem(product, qty);
        product.setQuantity(product.getQuantity() - qty);
    }

    public void removeFromCart(Product product, int qty) throws Exception {
        if (qty <= 0) {
            throw new IllegalArgumentException("removed qty must be greater than 0");
        }

        if (customer.getCart().isEmpty()) {
            throw new Exception("Cart is empty");
        }

        // item doesn't even exist
        if (!customer.getCart().isItemExists(product)) {
            throw new Exception("Item doesn't exist in the cart");
        }


        // Check if we're trying to remove more than what's in the cart
        int currentQtyInCart = customer.getCart().getProductQuantity(product);
        if (qty > currentQtyInCart) {
            throw new IllegalArgumentException("Cannot remove more items than what is already in cart");
        }

        customer.getCart().removeItem(product, qty);
        product.setQuantity(product.getQuantity() + qty);
    }
}
