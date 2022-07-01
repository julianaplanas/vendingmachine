package com.techelevator.model;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ProductTest {

    @Test
    public void setQuantity_should_subtract1OfQuantity() {
        // arrange
        Product product = new Product("H1", "Cookie", BigDecimal.valueOf(2.14), "Candy", 5);
        int quantityToSubtract = 1;
        int expectedQuantity = 4;

        // act
        product.setQuantity(quantityToSubtract);
        int actualQuantity = product.getQuantity();

        // assert
        String message = "Every time you purchase a product the quantity should rest 1.";
        assertEquals(message, expectedQuantity, actualQuantity);
    }

    @Test
    public void quantityCheck_should_returnSoldOut_when_quantityIs0() {
        // arrange
        Product product = new Product("H1", "Cookie", BigDecimal.valueOf(2.14), "Candy", 0);
        String expected = " - SOLD OUT";

        // act
        String actual = product.quantityCheck();

        // assert
        String message = "If the quantity of the product is 0, then the vending machine should return SOLD OUT.";
        assertEquals(message, expected, actual);
    }

}
