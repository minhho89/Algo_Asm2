package minhho.views;

import java.util.Scanner;

import static minhho.utils.ConsoleTextColor.*;

public class MainMenu {

    /**
     * Print main menu with options
     */
    public static void printMenu() {
        System.out.println(ANSI_YELLOW + "Choose one of this options: ");
        System.out.println(ANSI_YELLOW + "Product list: ");
        System.out.println("-----------------------------------------------");
        System.out.println(ANSI_RESET + "1. Load data from file and display");
        System.out.println(ANSI_RESET + "2. Input & add to the end.");
        System.out.println(ANSI_RESET +  "3. Display data");
        System.out.println(ANSI_RESET +  "4. Save product list to file.");
        System.out.println(ANSI_RESET +  "5. Search by ID");
        System.out.println(ANSI_RESET +  "6. Delete by ID");
        System.out.println(ANSI_RESET +  "7. Sort by ID.");
        System.out.println(ANSI_RESET +  "8. Convert to Binary of the first item in LinkedList");
        System.out.println(ANSI_RESET +  "9. Load to stack and display");
        System.out.println(ANSI_RESET +  "10. Load to queue and display.");
        System.out.println(ANSI_RESET +  "Exit:\n" +
                "0. Exit");
        System.out.println("-----------------------------------------------");
        System.out.println(ANSI_YELLOW + "Please input your choice (0 - 10): ");
    }

    /**
     * Handle user input for choosing option
     * @return option value
     */
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

    /**
     * Print user's option input
     * @param choice
     */
    public static void printChoice(int choice) {
        System.out.println(ANSI_RESET + "Your choice is: " + choice);
    }

    /**
     * Check if user input is valid or not
     * @param choice
     * @return true if valid, false if not
     */
    private static boolean isValid(String choice) {
        try {
            Integer.parseInt(choice);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

