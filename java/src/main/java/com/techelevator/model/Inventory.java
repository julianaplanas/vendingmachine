package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private static List<Product> products = new ArrayList<>();

    public Inventory() {
        loadInventory();
    }

    protected static void loadInventory() {
        // Create List of products
        FileProductLoader loader = new FileProductLoader();
        products = loader.getProducts();
    }

    public List<Product> getProducts() {
        return products;
    }

    public static Product getProductByCode(String productCode) {
        Product product = null;
        for (Product p : products) {
            // Check if a products code matches the given code
            if(p.getCode().equals(productCode)) {
                // Return the matching product
                product = p;
                break;
            }
        }
        return product;
    }


}
