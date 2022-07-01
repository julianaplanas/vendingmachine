package com.techelevator.model;

import com.techelevator.UI.UserOutput;
import com.techelevator.application.VendingMachineApplication;
import org.junit.Test;

import java.beans.FeatureDescriptor;
import java.math.BigDecimal;

import static org.junit.Assert.*;

public class PurchaseTest {

    @Test
    public void purchaseProduct_should_returnSubtract1Quantity_and_MoneyAvailableMinusProductPrice() {
        // arrange
        Product product = new Product("H1", "Cookie", BigDecimal.valueOf(2.14), "Candy", 5);
        FeedMoney.setMoneyAvailable(BigDecimal.valueOf(20), false);

        BigDecimal expectedPrice = BigDecimal.valueOf(17.86);
        int expectedQuantity = 4;

        // act
        Purchase.purchaseProduct(product);
        BigDecimal actualPrice = FeedMoney.getMoneyAvailable();
        int actualQuantity = product.getQuantity();

        // assert
        assertEquals(expectedQuantity, actualQuantity);
        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void purchaseProduct_should_returnNotSubtractQuantity_and_notSubtractMoneyAvailable_whenQuantity0() {
        // arrange
        Product product = new Product("H1", "Cookie", BigDecimal.valueOf(2.14), "Candy", 5);
        FeedMoney.setMoneyAvailable(BigDecimal.valueOf(0), false);

        BigDecimal expectedPrice = BigDecimal.valueOf(0);
        int expectedQuantity = 5;

        // act
        Purchase.purchaseProduct(product);
        BigDecimal actualPrice = FeedMoney.getMoneyAvailable();
        int actualQuantity = product.getQuantity();

        // assert
        assertEquals(expectedQuantity, actualQuantity);
        assertEquals(expectedPrice, actualPrice);
    }

}
