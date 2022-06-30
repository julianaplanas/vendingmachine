package com.techelevator.model;

import com.techelevator.UI.UserOutput;

import java.math.BigDecimal;

public class FeedMoney {

    private static BigDecimal moneyAvailable = BigDecimal.ZERO;
    private static BigDecimal change;
    private static final double QUARTER = 0.25;
    private static final double DIME = 0.10;
    private static final double NICKEL = 0.05;


    public static BigDecimal getMoneyAvailable() {
        return moneyAvailable;
    }

    public String getChange() {
        return "Your change is " + moneyAvailable + " and you'll receive " + coinChange();
    }

    // setMoneyAvailable(): adds money when it's introduced to the machine, or subtract money when something is bought
    public static void setMoneyAvailable(BigDecimal amount, boolean isPurchasing) {
        if (isPurchasing) {
            moneyAvailable = moneyAvailable.subtract(amount);
        } else {
            moneyAvailable = moneyAvailable.add(amount);
        }
    }

    public String coinChange() {
        double changeMoney = moneyAvailable.doubleValue();
        int quarterCoin = 0;
        int dimeCoin = 0;
        int nickelCoin = 0;

        while (changeMoney >= QUARTER) {
            changeMoney -= QUARTER;
            quarterCoin++;
        }
        while (changeMoney >= DIME) {
            changeMoney -= DIME;
            dimeCoin++;
        }
        while (changeMoney >= NICKEL) {
            changeMoney -= NICKEL;
            nickelCoin++;
        }
        return quarterCoin + " quarters + " + dimeCoin + " dimes + " + nickelCoin + " nickles";
    }


}
