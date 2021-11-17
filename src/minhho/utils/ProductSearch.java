package minhho.utils;

import minhho.models.Product;

public class ProductSearch {

    private static ProductLinkedList linkedList;

    public ProductSearch(ProductLinkedList linkedList) {
        this.linkedList = linkedList;
    }

    public static Product linearSearch(String code) {

        Node<Product> currentNode = linkedList.getHead();

        while (currentNode != null) {
            if (code.equalsIgnoreCase(currentNode.getInfo().getCode())) {
                return currentNode.getInfo();
            }
            currentNode = currentNode.getNext();
        }

        return null;
    }

}
