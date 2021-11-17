package minhho.utils.simpleAlgos;

import minhho.models.Product;
import minhho.utils.linkedList.Node;
import minhho.utils.linkedList.ProductLinkedList;

public class ProductSort {

    public static void sortById(ProductLinkedList linkedList) {
        Node<Product> outerNode = linkedList.getHead();

        while(outerNode != null) {
            Node<Product> innerNode = linkedList.getHead();

            while (!innerNode.getInfo().getCode().equalsIgnoreCase(outerNode.getInfo().getCode())) {

                String nextId = ((Product) innerNode.getNext().getInfo()).getCode();

                if (innerNode.getInfo().getCode()
                        .compareToIgnoreCase(nextId) > 0) {
                    Product temp = (Product) innerNode.getNext().getInfo();
                    innerNode.getNext().setInfo(innerNode.getInfo());
                    innerNode.setInfo(temp);
                }
                innerNode = innerNode.getNext();
            }
            outerNode = outerNode.getNext();
        }

    }

}
