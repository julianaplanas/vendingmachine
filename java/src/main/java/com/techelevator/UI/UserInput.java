package com.techelevator.UI;

import java.util.Scanner;

public class UserInput {


    private static Scanner scanner = new Scanner(System.in);

    public static String getHomeScreenOption() {

        System.out.println("What would you like to do?");
        System.out.println();

        System.out.println("1) Display Vending Machine Items");
        System.out.println("2) Purchase");
        System.out.println("3) Exit");

        System.out.println();
        System.out.print("Please select an option: ");
        String selectedOption = scanner.nextLine();


        if(selectedOption.equals("1"))
        {
            return "display";
        }
        else if(selectedOption.equals("2"))
        {
            return "purchase";
        }
        else if(selectedOption.equals("3"))
        {
            return "exit";
        }
        else
        {
            return "";
        }

    }
}
