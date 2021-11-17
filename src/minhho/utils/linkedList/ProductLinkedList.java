package minhho.utils.linkedList;

import minhho.models.Product;
import minhho.utils.simpleAlgos.ProductSearch;
import minhho.utils.simpleAlgos.ProductSort;

public class ProductLinkedList {

    private Node<Product> head;
    private Node<Product> tail;
    private int length = 0;

    public Node<Product> getHead() {
        return head;
    }

    public void setHead(Node<Product> head) {
        this.head = head;
    }

    public Node<Product> getTail() {
        return tail;
    }

    public void setTail(Node<Product> tail) {
        this.tail = tail;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
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

    public void deleteProduct(String code) {
        Node<Product> temp = head;
        Node<Product> prev = null;

        // If code belongs to head node
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

    public Product linearSearch(String code) {
        new ProductSearch(this); // Initialize ProductSearch
        return ProductSearch.linearSearch(code);
    }

    public void sortById() {
        ProductSort.sortById(this);
    }

    public void printList() {
        Node<Product> currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode);
            currentNode = currentNode.next;
        }
    }
}
