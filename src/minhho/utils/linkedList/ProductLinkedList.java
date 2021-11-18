package minhho.utils.linkedList;

import minhho.models.Product;
import minhho.utils.simpleAlgos.ProductSearch;
import minhho.utils.simpleAlgos.ProductSort;

/**
 * LinkedList that designed to hold Product instances
 */
public class ProductLinkedList {

    private Node<Product> head;

    private int length = 0;

    public Node<Product> getHead() {
        return head;
    }

    /**
     * Adding a node at the front of the list
     * @param product
     */
    public void push(Product product) {
        Node<Product> newNode = new Node<>(product);

        // Make new node as head
        newNode.next = head;
        newNode.prev = null;

        if (head != null) {
            head.prev = newNode;
        }

        head = newNode;

        length++;
    }

    /**
     * Add a node at the back of the list
     * @param product
     */
    public void append(Product product) {
        Node<Product> newNode = new Node<>(product);

        // Make new node as tail
        newNode.next = null;

        // If the list is empty, make the new node as head
        if (head == null) {
            newNode.prev = null;
            head = newNode;
            length++;

            return;
        }

        // Else traverse till the last node
        Node<Product> last = head;
        while (last.next != null) {
            last = last.next;
        }

        // Change the next of the last node
        last.next = newNode;
        newNode.prev = last;

        length++;
    }

    /**
     * Delete a product by product code/id
     * @param code
     */
    public void deleteProduct(String code) {
        Node<Product> temp = head;
        Node<Product> prev = null;

        // If code belongs to head node, set the next node to head
        if (temp != null && temp.getInfo().getCode().equalsIgnoreCase(code)) {
            head = temp.next; // change head
            head.prev = null;
        }

        // Else, search for the code to delete
        while (temp != null && !temp.getInfo().getCode().equalsIgnoreCase(code)) {
            prev = temp;
            temp = temp.next;
        }

        // If code was not present in the list
        if (temp == null) {
            return;
        }

        // Unlink the node from list
        prev.next = temp.next;

    }

    /**
     * Search a product by code using linear search algorithms
     * @param code
     * @return product if found, if not return null
     */
    public Product linearSearch(String code) {
        new ProductSearch(this); // Initialize ProductSearch
        return ProductSearch.linearSearch(code);
    }

    /**
     * Sort the LinkedList by product id
     */
    public void sortById() {
        ProductSort.recurSelectionSortById(this, head, getLastNode());
    }

    /**
     * Search a node by a particular product
     * @param p product
     * @return product if found, if not return null
     */
    public Node<Product> getNodeByProduct(Product p) {
        Node<Product> node = head;
        while (node != null) {
            if (node.getInfo().equals(p)) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    /**
     * @return the last node of the LinkedList
     */
    public Node<Product> getLastNode() {
        Node<Product> node = head;
        while(node.next != null) {
            node = node.next;
        }
        return node;
    }

    /**
     * Print the entire list
     */
    public void printList() {
        Node<Product> currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode);
            currentNode = currentNode.next;
        }
    }
}
