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

    boolean isFull()
    {
        return (this.size == this.capacity);
    }

    // Queue is empty when size is 0
    boolean isEmpty()
    {
        return (this.size == 0);
    }

    public void enqueue(Product product) {
        if (isFull()) {
            return;
        }
        this.rear = (this.rear + 1)
                % this.capacity;
        this.products[this.rear] = product;
        this.size = this.size + 1;
    }

}
