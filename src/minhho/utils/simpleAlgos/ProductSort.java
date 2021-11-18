package minhho.utils.simpleAlgos;

import minhho.models.Product;
import minhho.utils.linkedList.Node;
import minhho.utils.linkedList.ProductLinkedList;

public class ProductSort {

    public static void bubbleSortById(ProductLinkedList linkedList) {
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

    public static void recurSelectionSortById(ProductLinkedList linkedList) {

    }

    // TODO: set to private
    public static Product minProductByCode(ProductLinkedList linkedList,Node<Product> start, Node<Product> end) {
        Product minProduct = start.getInfo();
        Node<Product> n = start;

        while (n != null) {
            String code = n.getInfo().getCode();

            if (code.compareToIgnoreCase(minProduct.getCode()) < 0) {
                minProduct = n.getInfo();
            }
            n = n.getNext();
        }

        return minProduct;

    }



}
