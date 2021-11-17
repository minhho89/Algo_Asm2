package minhho.utils;

import minhho.models.Product;

public class ProductLinkedList {

    Node<Product> head;
    Node<Product> tail;

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

    }

    public void printList() {
        Node<Product> currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode);
            currentNode = currentNode.next;
        }
    }
}
