package com.techelevator.UI;

import com.techelevator.UI.constants.ColorCodes;
import com.techelevator.model.FeedMoney;
import com.techelevator.model.Inventory;

import java.math.BigDecimal;
import java.util.Scanner;

public class UserInput {
    private static Inventory inventory = new Inventory();

    private static Scanner scanner = new Scanner(System.in);

    public static String getHomeScreenOption() {

        UserOutput.clearScreen();

        UserOutput.displayIntro("Home Screen");

        System.out.println("What would you like to do?");

        System.out.println(ColorCodes.PURPLE);
        System.out.println("1) Display Vending Machine Items");
        System.out.println("2) Purchase");
        System.out.println("3) Exit");
        System.out.println(ColorCodes.RESET);

        System.out.print("Please select an option: ");
        String selectedOption = scanner.nextLine();
        System.out.println();


        if(selectedOption.equals("1")) {
            return "display";
        }
        else if(selectedOption.equals("2")) {
            return "purchase";
        }
        else if(selectedOption.equals("3")) {
            return "exit";
        }
        else if (selectedOption.equals("4")) {
            return "report";
        }
        else {
            return "";
        }
    }

    public static String getPurchaseOption() {

        UserOutput.clearScreen();

        UserOutput.displayIntro("Purchase options");

        System.out.println("What would you like to do?");

        System.out.println(ColorCodes.PURPLE);
        System.out.println("1) Feed Money");
        System.out.println("2) Select Product");
        System.out.println("3) Finish Transaction ");
        System.out.println(ColorCodes.RESET);

        System.out.println(ColorCodes.GREEN + "Current Money Available: $" + FeedMoney.getMoneyAvailable());
        System.out.println(ColorCodes.RESET);

        System.out.print("Please select an option: ");
        String selectedOption = scanner.nextLine();
        System.out.println();


        if(selectedOption.equals("1"))
        {
            return "money";
        }
        else if(selectedOption.equals("2"))
        {
            return "select";
        }
        else if(selectedOption.equals("3"))
        {
            return "finish";
        }
        else
        {
            return "";
        }
    }


    public static BigDecimal getFeedMoney() {

        System.out.println(ColorCodes.PURPLE);
        System.out.print("How much money do you wanna feed the machine with? ");
        BigDecimal selectedOption = new BigDecimal(scanner.nextLine());
        System.out.println(ColorCodes.RESET);

        return selectedOption;
    }

    public static String getProductCode() {

        UserOutput.displayInventory(inventory);

        System.out.println(ColorCodes.PURPLE);
        System.out.print("Select a code to purchase a product: ");
        String selectedOption = scanner.nextLine();
        System.out.println(ColorCodes.RESET);

        return selectedOption;
    }
}
