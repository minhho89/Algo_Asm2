package minhho.utils.queue;

import minhho.models.Product;

import static minhho.utils.ConsoleTextColor.ANSI_RESET;

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
     * @param product Product to add to queue
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
        System.out.println(ANSI_RESET + "-----------------------------------------------------");
        System.out.printf("%s %15s %15s %15s %n", "ID", "Title", "Price", "Quantity");
        System.out.println("-----------------------------------------------------");
        for (int i = 0; i < size; i++) {
            System.out.println(products[i]);
        }
        System.out.println("-----------------------------------------------------");
    }
}
