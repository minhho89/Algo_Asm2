package minhho.utils.simpleAlgos;

import minhho.models.Product;
import minhho.utils.linkedList.Node;
import minhho.utils.linkedList.ProductLinkedList;

/**
 * Implement searching algorithms for ProductLinkedList
 */
public class ProductSearch {

    private static ProductLinkedList linkedList;

    public ProductSearch(ProductLinkedList linkedList) {
        this.linkedList = linkedList;
    }

    /**
     * Using linear search algorithm to search for a product by its code
     * @param code
     * @return product if found, if not return null
     */
    public static Product linearSearch(String code) {

        Node<Product> currentNode = linkedList.getHead();
        // Traverse till last node to check if there is the desire product or not
        while (currentNode != null) {
            if (code.equalsIgnoreCase(currentNode.getInfo().getCode())) {
                return currentNode.getInfo();
            }
            // Shift to next node
            currentNode = currentNode.getNext();
        }
        return null;
    }

}
