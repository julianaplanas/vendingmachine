package com.techelevator.UI;

import com.techelevator.model.Inventory;
import com.techelevator.model.Product;

public class UserOutput {

    public static void displayInventory(Inventory inventory) {
        for(Product product : inventory.getProducts()) {
            System.out.println(product.toString());
        }
    }
}
