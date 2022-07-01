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

    public static List<Product> getNewReport() {
        return newReport;
    }

    private static List<Product> newReport = new ArrayList<>();

    public static void reportSalesList(Product product) {

        if(!newReport.contains(product)) {
            newReport.add(product);
        }
    }

    public static void reportSalesWriting() {

        String newFileName = ORDER_FOLDER + "/" + dateTransformer()+ ".txt";

        File reports = new File(ORDER_FOLDER);
        if(!reports.exists()) {
            reports.mkdir();
        }

        File newFile = new File(newFileName);
        try(PrintWriter writer = new PrintWriter(newFile)) {

            BigDecimal totalSpent = new BigDecimal(0);

            for (Product product : newReport) {
                int quantity = 5 - product.getQuantity();
                writer.println(product.getName() + "|" + quantity);
                totalSpent = totalSpent.add(product.getPrice().multiply(BigDecimal.valueOf(quantity)));
            }

            writer.println("");
            writer.println("TOTAL SALES: $" + totalSpent);

        } catch (IOException e) {
            System.out.println(e);
        }

    }

    public static String dateTransformer() {

        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");

        String formatDateTime = now.format(formatter);

        return formatDateTime;

    }

}
