package minhho;

import minhho.controllers.MainController;
import minhho.io.MultiPrintStream;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        // Print to console and also print to file
        MultiPrintStream multiPrintStream = new MultiPrintStream("console_output.txt");

        // Run main app
        MainController.run();
    }
}
