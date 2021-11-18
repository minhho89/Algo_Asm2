package minhho.controllers;

import minhho.io.ProductIO;
import minhho.models.Product;
import minhho.utils.ProductValidation;
import minhho.utils.linkedList.ProductLinkedList;
import minhho.utils.Utils;
import minhho.utils.queue.ProductQueue;
import minhho.utils.stack.ProductStack;
import minhho.views.MainMenu;

import java.util.Scanner;

import static java.lang.System.exit;

public class MainController {

    private static ProductLinkedList linkedList = new ProductLinkedList();

    private static void toChoiceOption(int choice) {

        switch (choice) {
            case 1:
                loadDataFromFileToLinkedListAndDisplay();
                break;
            case 2:
                inputAndAddToTheEnd();
                break;
            case 3:
                displayData();
                break;
            case 4:
                saveListToFile();
                break;
            case 5:
                searchById();
                break;
            case 6:
                deleteById();
                break;
            case 7:
                sortById();
                break;
            case 8:
                convertToBinary();
                break;
            case 9:
                loadToStackAndDisplay();
                break;
            case 10:
                loadToQueueAndDisplay();
                break;
            case 0:
                exit(1);
            default:
                System.out.println("again");
        }
    }

    private static void saveListToFile() {
        ProductIO.saveToFile("data.txt", ",,,", linkedList);
    }

    private static void displayData() {
        linkedList.printList();
        System.out.println("Display data");
    }

    private static void inputAndAddToTheEnd() {
        Product newProduct = inputNewProduct();
        linkedList.append(newProduct);
    }

    private static void loadDataFromFileToLinkedListAndDisplay() {
        loadDataToLinkedList();
        linkedList.printList();
    }

    private static void loadDataToLinkedList() {
        // First, clear the list, then add data from file to list
        linkedList = new ProductLinkedList();
        ProductIO<ProductLinkedList> io = new ProductIO<>();
        io.readFromFile("data.txt", "\\r\\n|,,,", linkedList);
    }

    private static void loadToQueueAndDisplay() {

        ProductQueue queue = new ProductQueue(1000);
        ProductIO<ProductQueue> io = new ProductIO<>();

        System.out.println("About to add products to queue...");
        io.readFromFile("data.txt","\\r\\n|,,,", queue);
        System.out.println("Enqueue done.");

        System.out.println();
        System.out.println("Queue elements:");
        queue.printQueue();
    }

    private static void loadToStackAndDisplay() {
        ProductStack stack = new ProductStack();
        Utils.pushToStack(linkedList, stack);
        System.out.println();
        System.out.println("Display Stack:");
        stack.printStack();
    }

    private static void convertToBinary() {

        int number = linkedList.getHead().getInfo().getQty();
        System.out.println("Quantity of first element product in list is " + number +
                " >> to Binary: " + Utils.toBinary(number));
    }

    private static void sortById() {

        System.out.println("Sorting...");
        linkedList.sortById();
        System.out.println("Sorted list:");
        linkedList.printList();

    }

    private static void deleteById() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Please input an product ID to delete: ");
        String key = sc.nextLine();

        Product p = linkedList.linearSearch(key);
        if (p == null) {
            System.out.println("Not found");
        } else {
            System.out.println("Product found. About to delete... ");
            linkedList.deleteProduct(key);
            System.out.println("Product " + p.getCode() + " has been deleted.");
        }

    }

    private static void searchById() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Please input an product ID to search: ");
        String key = sc.nextLine();

        Product p = linkedList.linearSearch(key);
        if (p == null) {
            System.out.println("Not found");
        } else {
            System.out.print("Product found: ");
            System.out.println(p);
        }


    }

    public static void run() {

        System.out.println("App initializing...");
        System.out.println("Adding data to list...");
        loadDataToLinkedList();
        System.out.println("Done initializing");
        System.out.println();

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

    private static Product inputNewProduct() {

        Product newProduct = new Product();
        Scanner sc = new Scanner(System.in);

        System.out.println("Please input new product's information: ");

        while(true) {
            System.out.print("Product code (no space in code): ");
            String code = sc.nextLine();
            if(ProductValidation.isCodeValid(code)) {
                newProduct.setCode(code);
                break;
            } else {
                System.out.println("Invalid value. Please try again");
            }
        }

        System.out.print("Product name: ");
        newProduct.setName(sc.nextLine());

        while(true) {
            System.out.print("Product price: ");
            String priceStr = sc.nextLine();
            if (ProductValidation.isPriceValid(priceStr)) {
                newProduct.setUnitPrice(Double.valueOf(priceStr));
                break;
            } else {
                System.out.println("Invalid value. Please try again");
            }
        }

        while(true) {
            System.out.print("Product quantity: ");
            String qtyStr = sc.nextLine();

            if (ProductValidation.isQuantityValid(qtyStr)) {
                newProduct.setQty(Integer.valueOf(qtyStr));
                break;
            } else {
                System.out.println("Invalid value. Please try again");
            }
        }
        return newProduct;
    }

}
