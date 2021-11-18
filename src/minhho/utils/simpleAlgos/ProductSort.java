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

    public static void recurSelectionSortById(ProductLinkedList linkedList, Node<Product> startNode, Node<Product> endNode) {

        // Return when starting and end is the same
        if (startNode.equals(endNode)) {
            return;
        }

        // Get min Product
        Product minProduct = minProductByCode(linkedList, startNode, endNode.getPrev());
        String minCode = minProduct.getCode();
        String startCode = startNode.getInfo().getCode();

        // Swapping when 'minCode' is smaller than 'startCode'
        if (minCode.compareToIgnoreCase(startCode) < 1) {
            Node<Product> minNode = linkedList.getNodeByProduct(minProduct);
            swapProducts(minNode, startNode);
        }

        // Shift startNode to right to use for below method
        startNode = startNode.getNext();

        // Recursively calling selection
        recurSelectionSortById(linkedList, startNode, endNode);

    }

    /**
     * Swap products between nodes
     * @param nodeX
     * @param nodeY
     */
    private static void swapProducts(Node<Product> nodeX, Node<Product> nodeY) {
        Product temp = nodeY.getInfo();
        nodeY.setInfo(nodeX.getInfo());
        nodeX.setInfo(temp);
    }

    private static Product minProductByCode(ProductLinkedList linkedList,Node<Product> start, Node<Product> end) {
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
