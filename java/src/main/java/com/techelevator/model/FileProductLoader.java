package com.techelevator.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileProductLoader {


    public List<Product> getProducts() {

        File file = new File("vendingmachine.csv");
        List<Product> products = new ArrayList<>();

        try(Scanner reader = new Scanner(file)) {
            // Read file
            while(reader.hasNextLine()) {
                String line = reader.nextLine();

                // Split in columns
                String[] columns = line.split("\\|");

                // Set variables of information
                String code = columns[0];
                String name = columns[1];
                BigDecimal price = new BigDecimal(columns[2]);
                String category = columns[3];
                int quantity = 5;

                // Create new Product
                Product product = new Product(code, name, price, category, quantity);

                // Add product to the list
                products.add(product);

            }

        } catch (FileNotFoundException e) {

        }
        // Return list of products
        return products;

    }
}
