package minhho;

import minhho.controllers.MainController;
import minhho.models.Product;
import minhho.utils.Utils;
import minhho.utils.linkedList.Node;
import minhho.utils.linkedList.ProductLinkedList;
import minhho.utils.simpleAlgos.ProductSort;
import minhho.views.MainMenu;

public class Main {

    public static void main(String[] args) {

//        MainController.run();

        // TODO: test
        ProductLinkedList linkedList = MainController.loadDataToLinkedList();
        linkedList.printList();

        System.out.println("Min product by code");
        Product min = ProductSort.minProductByCode(linkedList, linkedList.getHead(), linkedList.getLastNode());
        System.out.println(min);


    }
}
