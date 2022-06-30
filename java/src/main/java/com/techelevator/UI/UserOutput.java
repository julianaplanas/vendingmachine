package com.techelevator.UI;

import com.techelevator.model.Inventory;
import com.techelevator.model.Product;

import java.math.BigDecimal;

public class UserOutput {

    public static void displayInventory(Inventory inventory) {
        for(Product product : inventory.getProducts()) {
            System.out.println(product.toString());
        }
    }

    public static void displayMessage(String message)
    {
        System.out.println();
        System.out.println(message);
        System.out.println();
    }

    public static void displayMoneyAvailable(BigDecimal price)
    {
        System.out.println();
        System.out.println("Current money provided: " + price);
        System.out.println();
    }
}
