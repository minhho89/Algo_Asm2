package minhho.controllers;

import static java.lang.System.exit;

public class MainController {

    public static void run(int choice) {

        switch (choice) {
            case 1:
                System.out.println("Load data from file and display");
                break;
            case 2:
                System.out.println("Input & add to the end");
                break;
            case 3:
                System.out.println("Display data");
                break;
            case 4:
                System.out.println("Save product");
                break;
            case 5:
                System.out.println("Search by ID");
                break;
            case 6:
                System.out.println("Delete by ID");
                break;
            case 7:
                System.out.println("Sort by ID");
                break;
            case 8:
                System.out.println("Covert to Binary");
                break;
            case 9:
                System.out.println("Load to stack and display");
                break;
            case 10:
                System.out.println("Load to queue and display");
                break;
            case 0:
                exit(1);
            default:
                System.out.println("again");
        }
    }

}
