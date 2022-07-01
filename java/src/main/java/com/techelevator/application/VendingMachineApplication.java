package com.techelevator.application;

import com.techelevator.UI.UserInput;
import com.techelevator.UI.UserOutput;
import com.techelevator.model.*;

public class VendingMachineApplication {

    private Inventory inventory = new Inventory();
    private SalesReport salesReport = new SalesReport();

    public void run() {

        while(true) {
            // Display main menu options
            String userChoice = UserInput.getHomeScreenOption();

            if(userChoice.equalsIgnoreCase("display")) {

                showInventory();

            } else if(userChoice.equalsIgnoreCase("purchase")) {

                showPurchaseMenu();

            } else if(userChoice.equalsIgnoreCase("report")) {

                UserOutput.displaySalesReport(salesReport);

            } else if(userChoice.equalsIgnoreCase("exit")) {
                // Create sales report in file
                SalesReport.reportSalesWriting();
                UserOutput.displayMessage("Thank you :) Come back soon!");
                break;

            } else {
                UserOutput.displayMessage("You selected an invalid option");
            }
        }
    }


    public void showInventory() {
        UserOutput.displayInventory(inventory);
    }

    public void showPurchaseMenu() {
        while(true) {
            // Display Purchable menu options
            String userChoice = UserInput.getPurchaseOption();
            boolean isPurchasing;

            if(userChoice.equalsIgnoreCase("money")) {

                // Adding feeded money
                isPurchasing = false;
                FeedMoney.setMoneyAvailable(UserInput.getFeedMoney(), isPurchasing);
                // Display message with new money available
                UserOutput.displayMoneyAvailable(FeedMoney.getMoneyAvailable());

            } else if(userChoice.equalsIgnoreCase("select")) {
                // Select product code and check if exist
                Purchase.checkCodeExistence(UserInput.getProductCode());

            } else if(userChoice.equalsIgnoreCase("finish")) {
                // Break out of purchase menu loop and display change message
                UserOutput.displayFinishedTransaction(FeedMoney.getChange());
                break;

            }
            else {
                UserOutput.displayMessage("You selected an invalid option");
            }
        }
    }


}
