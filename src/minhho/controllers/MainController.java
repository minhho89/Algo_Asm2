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
import static minhho.utils.ConsoleTextColor.*;

/**
 * Control the app's main flow. Including input to select features and call the right handle method.
 */
public class MainController {

    private static ProductLinkedList linkedList = new ProductLinkedList();

    /**
     * The entry point of the class, handle all app's operation
     */
    public static void run() {
        System.out.println(ANSI_GREEN + "App initializing...");
        System.out.println(ANSI_GREEN + "Adding data to list...");
        linkedList = loadDataToLinkedList();
        System.out.println(ANSI_GREEN + "Done initializing");
        System.out.println();

        while(true) {

            boolean isContinue = true;

            MainMenu.printMenu();
            int choice = MainMenu.makeChoice();
            MainMenu.printChoice(choice);

            toChoiceOption(choice);

            while (isContinue) {
                System.out.print(ANSI_RESET + "Do you want to continue using apps? (Y/N): ");
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
            System.out.println("");
        }
    }

    /**
     * Calls the right method when user input a feature option
     * @param choice feature option number
     */
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

    /**
     * Save LinkedList products to data.txt file.
     * Using encapsulated method from ProductIO
     */
    private static void saveListToFile() {
        ProductIO.saveToFile("data.txt", ",,,", linkedList);
    }

    /**
     * Print all products in LinkedList to the console
     */
    private static void displayData() {
        linkedList.printList();
    }

    /**
     * Input new Product and append to the end of the LinkedList as a new node
     */
    private static void inputAndAddToTheEnd() {
        Product newProduct = inputNewProduct();
        linkedList.append(newProduct);
    }

    /**
     * Helps the app to load product data from file, then append to the LinkedList and display to the console
     */
    private static void loadDataFromFileToLinkedListAndDisplay() {
        linkedList = loadDataToLinkedList();
        linkedList.printList();
    }

    /**
     * Helps load product data from file to linkedList
     * @return data loaded linkedlist
     */
    private static ProductLinkedList loadDataToLinkedList() {
        ProductLinkedList productLinkedList = new ProductLinkedList();
        ProductIO<ProductLinkedList> io = new ProductIO<>();
        io.readFromFile("data.txt", "\\r\\n|,,,", productLinkedList);
        return productLinkedList;
    }

    /**
     * Load product data from LinkedList to a queue then display them to the console
     */
    private static void loadToQueueAndDisplay() {

        ProductQueue queue = new ProductQueue(1000); // set Capacity to the queue as 1000
        ProductIO<ProductQueue> io = new ProductIO<>();

        System.out.println("About to add products to queue...");
        io.readFromFile("data.txt","\\r\\n|,,,", queue);
        System.out.println("Enqueue done.");

        System.out.println();
        System.out.println("Queue elements:");
        queue.printQueue();
    }

    /**
     * Load product data from the linkedlist and then push them to the stack, then print to the console
     */
    private static void loadToStackAndDisplay() {
        ProductStack stack = new ProductStack();
        Utils.pushToStack(linkedList, stack);
        System.out.println();
        System.out.println("Display Stack:");
        stack.printStack();
    }

    /**
     * Convert number of the first product quality to binary form
     */
    private static void convertToBinary() {
        int number = linkedList.getHead().getInfo().getQty();
        System.out.println(ANSI_BLUE + "Quantity of first element product in list is " + number +
                " >> to Binary: " + Utils.toBinary(number));
    }

    /**
     * Sort the whole Linkedlist by products' id/code, then print to the console
     */
    private static void sortById() {
        System.out.println(ANSI_GREEN + "Sorting...");
        linkedList.sortById();
        System.out.println(ANSI_GREEN + "Sorted list:");
        linkedList.printList();

    }

    /**
     * Delete a single node by the product id
     */
    private static void deleteById() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Please input an product ID to delete: ");
        String key = sc.nextLine();

        Product p = linkedList.linearSearch(key);
        if (p == null) {
            System.out.println("Not found");
        } else {
            System.out.println(ANSI_GREEN + "Product found. About to delete... ");
            linkedList.deleteProduct(key);
            System.out.println(ANSI_CYAN + "Product " + p.getCode() + " has been deleted.");
        }

    }

    /**
     * Search a node by a product ID, then display the product details to the console
     */
    private static void searchById() {
        Scanner sc = new Scanner(System.in);

        System.out.print(ANSI_YELLOW +  "Please input an product ID to search: ");
        String key = sc.nextLine();

        Product p = linkedList.linearSearch(key);
        if (p == null) {
            System.out.println(ANSI_RESET + "Not found");
        } else {
            System.out.println(ANSI_RESET + "Product found: ");
            System.out.println("-----------------------------------------------------");
            System.out.printf("%s %15s %15s %15s %n", "ID", "Title", "Price", "Quantity");
            System.out.println("-----------------------------------------------------");
            System.out.println(p);
            System.out.println("-----------------------------------------------------");
        }

    }

    /**
     * Helps input a new product by create a new product instance,
     * then let users input the product's detail.
     * @return new product with details
     */
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
