package minhho;

import minhho.controllers.MainController;
import minhho.io.MultiPrintStream;
import minhho.models.Product;
import minhho.utils.Utils;
import minhho.utils.linkedList.Node;
import minhho.utils.linkedList.ProductLinkedList;
import minhho.utils.simpleAlgos.ProductSort;
import minhho.views.MainMenu;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        // Print to console and also print to file
        MultiPrintStream multiPrintStream = new MultiPrintStream("console_output.txt");

        MainController.run();



    }
}
