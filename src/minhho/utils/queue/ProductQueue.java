package minhho.utils.queue;

import minhho.models.Product;

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

}
