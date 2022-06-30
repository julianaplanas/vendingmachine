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

            while(reader.hasNextLine()) {
                String line = reader.nextLine();

                String[] columns = line.split("\\|");

                String code = columns[0];
                String name = columns[1];
                BigDecimal price = new BigDecimal(columns[2]);
                String category = columns[3];
                int quantity = 5;

                Product product = new Product(code, name, price, category, quantity);

                products.add(product);

            }

        } catch (FileNotFoundException e) {

        }

        return products;

    }
}
