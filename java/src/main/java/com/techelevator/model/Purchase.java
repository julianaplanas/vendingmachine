package com.techelevator.model;

import com.techelevator.UI.UserInput;
import com.techelevator.UI.UserOutput;

import java.math.BigDecimal;
import java.util.Locale;

public class Purchase {

    private static final int QUANTITY_TO_SUBTRACT = 1;

    public static void checkCodeExistence(String inputCode) {

        // Get product by code provided
        Product productByCode = Inventory.getProductByCode(inputCode.toUpperCase());

        // Check if code is null
        if (productByCode == null) {
            UserOutput.displayMessage("Your code doesn't exist. \n Please select a valid one.");
        } else {
            // Check if quantity of product is 0
            if (productByCode.getQuantity() == 0) {
                UserOutput.displayMessage("The product is sold out. \n Please select another one.");
            } else {
                // Purchase product only if its quantity its more than 0
                purchaseProduct(productByCode);
            }
        }
    }

    public static void purchaseProduct(Product product) {

        // Subtract the price of the product to the amount of money available
        BigDecimal amountAvailable = FeedMoney.getMoneyAvailable().subtract(product.getPrice());
        double doubleAmountAvailable = amountAvailable.doubleValue();

        try {
            // Check if there's enough money available to purchase the product
            if (doubleAmountAvailable >= 0) {

                // Subtract the price to the amount of money available
                FeedMoney.setMoneyAvailable(product.getPrice(), true);
                // Subtract 1 to the quantity of product
                product.setQuantity(QUANTITY_TO_SUBTRACT);
                // Display message of purchase
                UserOutput.displayPurchaseMessage(product.getName(), product.getPrice(), FeedMoney.getMoneyAvailable(), product.getCategory());
                // Add entry to audit with info about the product purchased
                Audit.auditEntries(product.getName() + " " + product.getCode(), FeedMoney.getMoneyAvailable().add(product.getPrice()), FeedMoney.getMoneyAvailable());
                // Add product purchased to the list of sales report
                SalesReport.reportSalesList(product);

            } else {
                UserOutput.displayMessage("You don't have enough money for this purchase.");
            }
        } catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }



}
