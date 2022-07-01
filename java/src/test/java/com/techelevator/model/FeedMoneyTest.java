package com.techelevator.model;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class FeedMoneyTest {

    @Test
    public void setMoneyAvailable_should_add_when_isNotPurchasing() {
        // arrange
        BigDecimal amount = BigDecimal.valueOf(20);
        boolean isPurchasing = false;
        BigDecimal expected = BigDecimal.valueOf(20);

        // act
        FeedMoney.setMoneyAvailable(amount, isPurchasing);
        BigDecimal actual = FeedMoney.getMoneyAvailable();

        // assert
        String message = String.format("If the user is feeding money to the vending machine, the amount should be added to the money available.");
        assertEquals(message, expected, actual);

    }

    @Test
    public void setMoneyAvailable_should_subtract_when_isPurchasing() {
        // arrange
        BigDecimal amount = BigDecimal.valueOf(15);
        boolean isPurchasing = true;
        BigDecimal expected = BigDecimal.valueOf(5);
        FeedMoney.setMoneyAvailable(BigDecimal.valueOf(20), false);

        // act
        FeedMoney.setMoneyAvailable(amount, isPurchasing);
        BigDecimal actual = FeedMoney.getMoneyAvailable();

        // assert
        String message = String.format("If the user is purchasing a product, the price should be subtract to the money available.");
        assertEquals(message, expected, actual);

    }

    @Test
    public void coinChange_should_returnWholeAmount_dividedBy_quartersDimesAndNickels() {
        // arrange
        BigDecimal amount = BigDecimal.valueOf(15);
        FeedMoney.setMoneyAvailable(amount, false);
        int quarterCoin = 60;
        int dimeCoin = 0;
        int nickelCoin = 0;

        String message1 = quarterCoin > 0 ? quarterCoin + " quarter(s) " : "";
        String message2 = dimeCoin > 0 ? dimeCoin + " dime(s) " : "";
        String message3 = nickelCoin > 0 ? nickelCoin + " nickle(s) " : "";
        String expected = message1 + "\n" + message2 + "\n" + message3;

        // act
        String actual = FeedMoney.coinChange();

        // assert
        String message = String.format("The vending machine should return %f divided by quarts, dimes and nickels", amount);
        assertEquals(message, expected, actual);

    }

    @Test
    public void coinChange_should_returnNotWholeAmount_dividedBy_quartersDimesAndNickels() {
        // arrange
        BigDecimal amount = BigDecimal.valueOf(11.15);
        FeedMoney.setMoneyAvailable(amount, false);
        int quarterCoin = 44;
        int dimeCoin = 1;
        int nickelCoin = 1;

        String message1 = quarterCoin > 0 ? quarterCoin + " quarter(s) " : "";
        String message2 = dimeCoin > 0 ? dimeCoin + " dime(s) " : "";
        String message3 = nickelCoin > 0 ? nickelCoin + " nickle(s) " : "";
        String expected = message1 + "\n" + message2 + "\n" + message3;

        // act
        String actual = FeedMoney.coinChange();

        // assert
        String message = String.format("The vending machine should return %f divided by quarts, dimes and nickels", amount);
        assertEquals(message, expected, actual);

    }

}
