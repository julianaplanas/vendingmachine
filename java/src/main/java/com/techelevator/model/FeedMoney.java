package com.techelevator.model;

import com.techelevator.UI.UserOutput;

import java.math.BigDecimal;

public class FeedMoney {

    private static BigDecimal moneyAvailable = BigDecimal.ZERO;
    private static final BigDecimal QUARTER = new BigDecimal("0.25");
    private static final BigDecimal DIME = new BigDecimal("0.10");
    private static final BigDecimal NICKEL = new BigDecimal("0.05");


    public static BigDecimal getMoneyAvailable() {
        return moneyAvailable;
    }

    public static String getChange() {
        // Generate message in audit when change is returned
        Audit.auditEntries("GIVE CHANGE:", getMoneyAvailable(), BigDecimal.valueOf(0.00));
        // Return message with given change
        return "Your change is $" + moneyAvailable + " and you'll receive: \n" + coinChange();
    }


    public static void setMoneyAvailable(BigDecimal amount, boolean isPurchasing) {
        // Adds money when it's introduced to the machine, or subtract money when something is bought
        if (isPurchasing) {
            moneyAvailable = moneyAvailable.subtract(amount);
        } else {
            moneyAvailable = moneyAvailable.add(amount);
            // Generate message in audit when money is charged in the machine
            Audit.auditEntries("FEED MONEY:", getMoneyAvailable().subtract(amount), getMoneyAvailable());
        }
    }

    public static String coinChange() {
        int quarterCoin = 0;
        int dimeCoin = 0;
        int nickelCoin = 0;

        // Transform money available in amount of coins
        while (moneyAvailable.compareTo(QUARTER) >= 0) {
            moneyAvailable = moneyAvailable.subtract(QUARTER);
            quarterCoin++;
        }
        while (moneyAvailable.compareTo(DIME) >= 0) {
            moneyAvailable = moneyAvailable.subtract(DIME);
            dimeCoin++;
        }
        while (moneyAvailable.compareTo(NICKEL) >= 0) {
            moneyAvailable = moneyAvailable.subtract(NICKEL);
            nickelCoin++;
        }

        String message1 = quarterCoin > 0 ? quarterCoin + " quarter(s) " : "";
        String message2 = dimeCoin > 0 ? dimeCoin + " dime(s) " : "";
        String message3 = nickelCoin > 0 ? nickelCoin + " nickle(s) " : "";
        return message1 + "\n" + message2 + "\n" + message3;
    }


}
