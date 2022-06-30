package com.techelevator.model;

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

    public static BigDecimal getChange() {
        // BigDecimal quarterChange = moneyAvailable % QUARTER;
        return change;
    }

    public static void setMoneyAvailable(BigDecimal moneyAvailable, boolean isPurchasing) {

        if (isPurchasing) {
            FeedMoney.moneyAvailable.subtract(moneyAvailable);
        } else {
            FeedMoney.moneyAvailable.add(moneyAvailable);
        }
    }


}
