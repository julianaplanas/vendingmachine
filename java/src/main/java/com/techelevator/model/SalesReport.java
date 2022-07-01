package com.techelevator.model;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SalesReport {

    private static final String ORDER_FOLDER = "reports";
    private static final int MAX_QUANTITY = 5;

    public static List<Product> getNewReport() {
        return newReport;
    }

    private static List<Product> newReport = new ArrayList<>();

    public static void reportSalesList(Product product) {
        // Check if product exists in the list of sales report products
        // If it doesn't, add it
        if(!newReport.contains(product)) {
            newReport.add(product);
        }
    }

    public static void reportSalesWriting() {

        String newFileName = ORDER_FOLDER + "/" + dateTransformer()+ ".txt";

        // Check if folder exists
        File reports = new File(ORDER_FOLDER);
        if(!reports.exists()) {
            reports.mkdir();
        }

        // Create new file
        File newFile = new File(newFileName);
        try(PrintWriter writer = new PrintWriter(newFile)) {

            BigDecimal totalSpent = new BigDecimal(0);

            for (Product product : newReport) {
                // Set quantity to the max quantity (5) - the quantity left of that product
                int quantity = MAX_QUANTITY - product.getQuantity();
                // Print information in sales report file
                writer.println(product.getName() + "|" + quantity);
                // Add price * amount of products bought to the total spent
                totalSpent = totalSpent.add(product.getPrice().multiply(BigDecimal.valueOf(quantity)));
            }

            writer.println("");
            writer.println("TOTAL SALES: $" + totalSpent);

        } catch (IOException e) {
            System.out.println(e);
        }

    }

    public static String dateTransformer() {

        // Transform date format to fit the file name
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String formatDateTime = now.format(formatter);
        return formatDateTime;

    }

}
