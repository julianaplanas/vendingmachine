package com.techelevator.application;

import com.techelevator.UI.UserInput;
import com.techelevator.UI.UserOutput;
import com.techelevator.model.Inventory;

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
            } else if(userChoice.equalsIgnoreCase("exit")) {
                // break out of the loop and end the application
                break;
            }
        }
    }


    public void showInventory() {
        UserOutput.displayInventory(inventory);
    }


}
