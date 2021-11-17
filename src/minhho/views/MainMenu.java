package minhho.views;

import java.util.Scanner;

public class MainMenu {

    public static void printMenu() {

        System.out.println("Choose one of this options: ");
        System.out.println("Product list: ");
        System.out.println("1. Load data from file and display");
        System.out.println("2. Input & add to the end.");
        System.out.println("3. Display data");
        System.out.println("4. Save product list to file.");
        System.out.println("5. Search by ID");
        System.out.println("6. Delete by ID");
        System.out.println("7. Sort by ID.");
        System.out.println("8. Convert to Binary of the first item in LinkedList");
        System.out.println("9. Load to stack and display");
        System.out.println("10. Load to queue and display.");
        System.out.println("Exit:\n" +
                "0. Exit");
        System.out.println("Please input your choice (0 - 10): ");
    }

    public static int makeChoice() {
        Scanner sc = new Scanner(System.in);
        String choice = sc.next();

        if (isValid(choice)) {
            return Integer.parseInt(choice);
        } else {
            System.out.println("Invalid input");
            return -1;
        }

    }

    public static void printChoice(int choice) {
        System.out.println("Your choice is: " + choice);
    }

    private static boolean isValid(String choice) {
        try {
            Integer.parseInt(choice);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}

