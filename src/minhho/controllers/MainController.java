package minhho.controllers;

import minhho.io.ProductIO;
import minhho.models.Product;
import minhho.utils.ProductLinkedList;
import minhho.views.MainMenu;

import java.util.Scanner;

import static java.lang.System.exit;

public class MainController {

    private static ProductLinkedList linkedList = new ProductLinkedList();

    private static void toChoiceOption(int choice) {

        switch (choice) {
            case 1:
                ProductIO.readFromFile("data.txt", ",,,|\\r\\n", linkedList);
                linkedList.printList();
                break;
            case 2:
                System.out.println("Input & add to the end");
                Product newProduct = inputNewProduct();
                linkedList.append(newProduct);
                // TODO: delete this debug line
                linkedList.printList();
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

    public static void run() {
        while(true) {

            boolean isContinue = true;

            MainMenu.printMenu();
            int choice = MainMenu.makeChoice();
            MainMenu.printChoice(choice);

            toChoiceOption(choice);

            while (isContinue) {
                System.out.print("Do you want to continue using apps? (Y/N): ");
                Scanner sc = new Scanner(System.in);
                String ans = sc.next();

                if (ans.equalsIgnoreCase("Y") || ans.equalsIgnoreCase("Yes")) {
                    isContinue = false;
                } else if (ans.equalsIgnoreCase("N") || ans.equalsIgnoreCase("No")) {
                    isContinue = false;
                    exit(1);
                } else {
                    System.out.println("Invalid choice, please try again!");

                }
            }
        }
    }

    // TODO: add validate
    private static Product inputNewProduct() {

        Product newProduct = new Product();
        Scanner sc = new Scanner(System.in);

        System.out.println("Please input new product's information: ");

        System.out.print("Product code: ");
        newProduct.setCode(sc.nextLine());

        System.out.print("Product name: ");
        newProduct.setName(sc.nextLine());

        System.out.print("Product price: ");
        newProduct.setUnitPrice(sc.nextDouble());

        System.out.print("Product quantity: ");
        newProduct.setQty(sc.nextInt());

        return newProduct;


    }

}
