package minhho.io;

import minhho.models.Product;
import minhho.utils.ProductLinkedList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ProductIO {
    public static void readFromFile(String file, String delimiter, ProductLinkedList linkedList){
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
                linkedList.append(p);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
