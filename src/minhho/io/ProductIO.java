package minhho.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ProductIO {
    public static void readFromFile(String file, String delimiter){
        Scanner sc = null;
        try {
            sc = new Scanner(new File(file));
            sc.useDelimiter(delimiter);

            while (sc.hasNext()) {
                // TODO: change this into adding to List
                String next = sc.next();
                System.out.print(next + " ");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
