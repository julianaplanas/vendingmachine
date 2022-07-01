package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private static List<Product> products = new ArrayList<>();

    public Inventory() {
        loadInventory();
    }

    protected static void loadInventory() {
        FileProductLoader loader = new FileProductLoader();
        products = loader.getProducts();
    }

    public List<Product> getProducts() {
        return products;
    }

    public static Product getProductByCode(String productCode) {
        Product product = null;
        for (Product p : products) {
            if(p.getCode().equals(productCode)) {
                product = p;
                break;
            }
        }
        return product;
    }


}
