package minhho.io;

import minhho.models.Product;
import minhho.utils.linkedList.Node;
import minhho.utils.linkedList.ProductLinkedList;
import minhho.utils.queue.ProductQueue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ProductIO<T> {
    public void readFromFile(String file, String delimiter, T collection){
        Scanner sc = null;
        try {
            sc = new Scanner(new File(file));
            sc.useDelimiter(delimiter);

            while (sc.hasNext()) {
                String code = sc.next().trim();
                String name = sc.next().trim();
                int qty = Integer.valueOf(sc.next().trim());
                Double price = Double.valueOf(sc.next().trim());

                // Add to Product linklist
                Product p = new Product(code, name, price, qty);
                if (collection instanceof ProductLinkedList) {
                    ((ProductLinkedList)collection).append(p);
                } else if (collection instanceof ProductQueue) {
                    ((ProductQueue)collection).enqueue(p);
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void saveToFile(String file, String delimiter, ProductLinkedList linkedList) {
        System.out.println("About to save...");
        PrintWriter printWriter = null;
        int counter = 0;

        try {
            printWriter = new PrintWriter(file);

            Node<Product> currentNode = linkedList.getHead();
            System.out.println("Saving... ");

            // Traverse till last node
            while (currentNode != null) {
                counter++;

                Product p = currentNode.getInfo();
                String code = p.getCode();
                String name = p.getName();
                double price = p.getUnitPrice();
                int qty = p.getQty();

                // If current node is not the first node,
                // then add line break for next record
                if (counter > 1) {
                    printWriter.println();
                }

                printWriter.print(code + delimiter);
                printWriter.print(name + delimiter);
                printWriter.print(qty + delimiter);
                printWriter.print(price + delimiter);

                System.out.println("Saving product: " + code + "; " + name + "; " + qty + "; " + price + "...");

                currentNode = currentNode.getNext();
            }
            System.out.println("File saved.");
        } catch (FileNotFoundException e) {
            System.out.println("File save error");
            e.printStackTrace();
        } finally {

            printWriter.close();
        }
    }
}
