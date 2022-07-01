package com.techelevator.model;

import com.techelevator.UI.UserInput;
import com.techelevator.UI.UserOutput;

import java.math.BigDecimal;
import java.util.Locale;

public class Purchase {

    private static final int QUANTITY_TO_SUBTRACT = 1;

    public static void checkCodeExistence(String inputCode) {

        Product productByCode = Inventory.getProductByCode(inputCode.toUpperCase());

        if (productByCode == null) {
            UserOutput.displayMessage("Your code doesn't exist. \n Please select a valid one.");
        } else {
            if (productByCode.getQuantity() == 0) {
                UserOutput.displayMessage("The product is sold out. \n Please select another one.");
            } else {
                purchaseProduct(productByCode);
            }
        }
    }

    public static void purchaseProduct(Product product) {

        BigDecimal amountAvailable = FeedMoney.getMoneyAvailable().subtract(product.getPrice());
        double doubleAmountAvailable = amountAvailable.doubleValue();

        if (doubleAmountAvailable >= 0) {

            FeedMoney.setMoneyAvailable(product.getPrice(),true);
            product.setQuantity(QUANTITY_TO_SUBTRACT);
            UserOutput.displayPurchaseMessage(product.getName(), product.getPrice(), FeedMoney.getMoneyAvailable(), product.getCategory());
            Audit.auditEntries(product.getName() + " " + product.getCode(), FeedMoney.getMoneyAvailable().add(product.getPrice()), FeedMoney.getMoneyAvailable());
            SalesReport.reportSalesList(product);

        } else {
            UserOutput.displayMessage("You don't have enough money for this purchase.");
        }
    }



}
