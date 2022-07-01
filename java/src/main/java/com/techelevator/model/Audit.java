package com.techelevator.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Audit {

    public static void auditEntries(String category, BigDecimal moneyBefore, BigDecimal moneyAfter)
    {
        // Create object file to write log messages
        String path = "Log.txt";
        File file = new File(path);

        try (FileWriter fileWriter = new FileWriter(file, true);
             PrintWriter writer = new PrintWriter(fileWriter)) {

            // Write message of business done and print it in the audit
            String message = String.format("%-20s %-15s $ %-7.2f $ %-7.2f", dateTransformer(), category, moneyBefore, moneyAfter);
            writer.println(message);

        }
        catch (IOException e)
        {

        }
    }
    public static String dateTransformer() {

        // Create data and time with required format
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
        String formatDateTime = now.format(formatter);
        return formatDateTime;

    }

}
