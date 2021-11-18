package minhho.utils;


import minhho.models.Product;
import minhho.utils.linkedList.Node;
import minhho.utils.linkedList.ProductLinkedList;
import minhho.utils.stack.ProductStack;

/**
 * Utilities class help handle some work
 */
public class Utils {

    /**
     * Implement algorithm of converting an int to a binary
     * @param i integer value
     * @return binary number
     */
    public static int toBinary(int i) {
        if (i == 0) {
            return 0;
        } else {
            return (i % 2 + 10 * toBinary(i / 2));
        }
    }

    /**
     * Helps pushing items from a ProductLinkedList to a ProductStack
     * @param linkedList
     * @param stack
     * @return
     */
    public static ProductStack pushToStack(ProductLinkedList linkedList, ProductStack stack) {
        Node<Product> currentNode = linkedList.getHead();
        System.out.println("Pushing items from linkedList to stack...");
        while (currentNode != null) {

            System.out.println("Pushing Product " + currentNode.getInfo().getCode() + "...");
            stack.push(currentNode.getInfo());

            currentNode = currentNode.getNext();
        }

        System.out.println("Done pushing to stack.");
        return stack;
    }

}
