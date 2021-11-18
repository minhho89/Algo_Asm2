package minhho.utils.queue;

import minhho.models.Product;

/**
 * Custom Queue for Product instances
 */
public class ProductQueue {

    private int front;
    private int rear;
    private int size;
    private int capacity;
    private Product[] products;

    public ProductQueue(int capacity) {
        this.capacity = capacity;
        this.front = 0;
        this.size = 0;
        this.rear = capacity - 1;
        products = new Product[this.capacity];
    }

    boolean isFull()
    {
        return (this.size == this.capacity);
    }

    /**
     * Adding a new product to last position of queue
     * @param product
     */
    public void enqueue(Product product) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        this.rear = (this.rear + 1) % this.capacity;

        System.out.println("Adding " + product.getCode() + " to queue...");

        this.products[this.rear] = product;
        this.size = this.size + 1;
    }

    public void printQueue() {
        for (int i = 0; i < size; i++) {
            System.out.println(products[i]);
        }
    }
}
