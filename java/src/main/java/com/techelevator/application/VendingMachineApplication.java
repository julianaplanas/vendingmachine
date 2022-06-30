package com.techelevator.application;

import com.techelevator.UI.UserInput;
import com.techelevator.UI.UserOutput;
import com.techelevator.model.FeedMoney;
import com.techelevator.model.Inventory;
import com.techelevator.model.Purchase;

public class VendingMachineApplication {

    private Inventory inventory = new Inventory();

    public void run() {

        while(true) {
            // todo: display home screen
            // todo: and get user choice
            String userChoice = UserInput.getHomeScreenOption();

            if(userChoice.equalsIgnoreCase("display")) {
                // todo: logic to display all vending machine items
                showInventory();

            } else if(userChoice.equalsIgnoreCase("purchase")) {
                // todo: logic to display purchase options
                boolean isFinish = showPurchaseMenu();
                if (isFinish) {
                    break;
                }

            } else if(userChoice.equalsIgnoreCase("exit")) {
                // break out of the loop and end the application

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

    public boolean showPurchaseMenu() {
        while(true) {

            String userChoice = UserInput.getPurchaseOption();
            boolean isPurchasing;

            if(userChoice.equalsIgnoreCase("money")) {

                isPurchasing = false;
                FeedMoney.setMoneyAvailable(UserInput.getFeedMoney(), isPurchasing);
                UserOutput.displayMoneyAvailable(FeedMoney.getMoneyAvailable());

            } else if(userChoice.equalsIgnoreCase("select")) {

                Purchase.checkCodeExistence(UserInput.getProductCode());

            } else if(userChoice.equalsIgnoreCase("finish")) {

                UserOutput.displayFinishedTransaction(FeedMoney.getChange());
                return true;

            } else {
                UserOutput.displayMessage("You selected an invalid option");
            }
        }
    }


}
