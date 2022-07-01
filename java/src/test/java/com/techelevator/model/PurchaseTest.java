package com.techelevator.model;

import com.techelevator.UI.UserOutput;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class PurchaseTest {

    @Test
    public void checkCodeExistence_should_returnMessage_when_codeIsNull() {
        // arrange
        String productCode = "H1";

        // act
        Purchase.checkCodeExistence(productCode);

        // assert
        String message = "The information given should match the one in vendingmachine.csv file";
        //assertEquals(Purchase.checkCodeExistence(productCode), UserOutput.displayMessage("Your code doesn't exist. \n Please select a valid one."));
    }

}
