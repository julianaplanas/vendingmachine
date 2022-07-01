package com.techelevator.model;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class InventoryTest {

    @Test
    public void getProductByCode_should_returnProduct_when_providingCorrectCode() {
        // arrange
        String productCode = "A1";
        String code = "A1";
        String name = "Potato Crisps";
        BigDecimal price = BigDecimal.valueOf(3.05);
        String category = "Chip";
        Inventory.loadInventory();

        // act
        Product actual = Inventory.getProductByCode(productCode);

        // assert
        String message = "The information given should match the one in vendingmachine.csv file";
        assertEquals(message, code, actual.getCode());
        assertEquals(message, name, actual.getName());
        assertEquals(message, price, actual.getPrice());
        assertEquals(message, category, actual.getCategory());
    }

    @Test
    public void getProductByCode_should_returnNull_when_providingIncorrectCode() {
        // arrange
        String productCode = "H1";
        Product expected = null;
        Inventory.loadInventory();

        // act
        Product actual = Inventory.getProductByCode(productCode);

        // assert
        String message = "The code doesn't exist.";
        assertEquals(message, expected, actual);
    }

}
