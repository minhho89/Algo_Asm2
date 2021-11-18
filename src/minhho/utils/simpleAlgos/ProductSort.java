package minhho.utils.simpleAlgos;

import minhho.models.Product;
import minhho.utils.linkedList.Node;
import minhho.utils.linkedList.ProductLinkedList;

/**
 * Implement sorting algorithms for ProductLinkedList
 */
public class ProductSort {

    /**
     * Sort by ID using bubble sort algorithm
     * @param linkedList
     */
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

    /**
     * Sort by ID using recursion Selection Sort algorithm
     * @param linkedList
     * @param startNode
     * @param endNode
     */
    public static void recurSelectionSortById(ProductLinkedList linkedList, Node<Product> startNode, Node<Product> endNode) {

        // Return when starting node and end node is the same
        if (startNode.equals(endNode)) {
            return;
        }

        // Get min Product
        Product minProduct = minProductByCode(startNode);
        String minCode = minProduct.getCode();
        String startCode = startNode.getInfo().getCode();

        // Swapping when 'minCode' is smaller than 'startCode'
        if (minCode.compareToIgnoreCase(startCode) < 1) {
            Node<Product> minNode = linkedList.getNodeByProduct(minProduct);
            swapProducts(minNode, startNode);
        }

        // Shift startNode to right node to use for below method
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

    /**
     * Get minProduct by Product code from start node till end
     * @param start start node
     * @return minProduct
     */
    private static Product minProductByCode(Node<Product> start) {
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
