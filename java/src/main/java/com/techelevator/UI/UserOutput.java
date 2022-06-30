package com.techelevator.UI;

import com.techelevator.model.Inventory;
import com.techelevator.model.Product;

import java.math.BigDecimal;

public class UserOutput {

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

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
        System.out.println("Current money provided: $" + price);
        System.out.println();
    }


    public static void displayFinishedTransaction(String change)
    {
        System.out.println();
        System.out.println("Thanks for your purchase!");
        System.out.println(change);
        System.out.println();
    }


    public static void displayPurchaseMessage(String product, BigDecimal price, BigDecimal moneyAvailable, String category)
    {
        String message = "";
        if (category.equals("Chip")) {
            message = "Crunch Crunch, Yum!";
        } else if (category.equals("Candy")) {
            message = "Munch Munch, Yum!";
        } else if (category.equals("Drink")) {
            message = "Glug Glug, Yum!";
        } else if (category.equals("Gum")) {
            message = "Chew Chew, Yum!";
        }

        System.out.println();
        System.out.println("You have purchased a " + product + " for $" + price + ".");
        System.out.println();
        System.out.println("Current money provided: $" + moneyAvailable);
        System.out.println();
        System.out.println(message);
        System.out.println();
    }
}
