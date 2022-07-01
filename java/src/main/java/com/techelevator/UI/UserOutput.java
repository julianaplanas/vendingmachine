package com.techelevator.UI;

import com.techelevator.UI.constants.ColorCodes;
import com.techelevator.model.Inventory;
import com.techelevator.model.Product;

import java.math.BigDecimal;

public class UserOutput {

    public static void clearScreen() {
        final String ANSI_CLS = "\u001b[2J";
        final String ANSI_HOME = "\u001b[H";
        System.out.print(ANSI_CLS + ANSI_HOME);
        System.out.flush();
    }

    public static void displayInventory(Inventory inventory) {
        for(Product product : inventory.getProducts()) {
            System.out.println(ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + product.toString() + ColorCodes.RESET);
        }
        System.out.println();
    }

    public static void displayIntro(String message)
    {
        System.out.println(ColorCodes.YELLOW);
        System.out.println("---------------------------------");
        System.out.println("        " + message);
        System.out.println("---------------------------------");
        System.out.println(ColorCodes.RESET);
    }

    public static void displayMessage(String message)
    {
        System.out.println(ColorCodes.RED);
        System.out.println(message);
        System.out.println(ColorCodes.RESET);
    }

    public static void displayMoneyAvailable(BigDecimal price)
    {
        System.out.println(ColorCodes.GREEN);
        System.out.println("Current money provided: $" + price);
        System.out.println(ColorCodes.RESET);
    }


    public static void displayFinishedTransaction(String change)
    {
        System.out.println();
        System.out.println(ColorCodes.YELLOW_BACKGROUND + ColorCodes.BLACK + "Thanks for your purchase!" + ColorCodes.RESET);
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
        System.out.println(ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "You have purchased a " + product + " for $" + price + "." + ColorCodes.RESET);
        System.out.println(ColorCodes.GREEN);
        System.out.println("Current money provided: $" + moneyAvailable);
        System.out.println(ColorCodes.RESET);
        System.out.println(message);
        System.out.println();
    }
}
