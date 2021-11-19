package minhho.utils.stack;

import minhho.models.Product;

import static minhho.utils.ConsoleTextColor.ANSI_RESET;

public class ProductStack {

    static final int MAX = 1000;
    int top;
    Product[] products = new minhho.models.Product[MAX];

    boolean isEmpty() {
        return top < 0;
    }

    public ProductStack() {
        top = -1; // make an empty stack
    }

    public boolean push(Product p) {
        if (top >= MAX - 1) {
            System.out.println("Stack Overflow");
            return  false;
        } else {
            products[++top] = p;
            return true;
        }
    }

    public Product pop() {
        if (top < 0) {
            System.out.println("Stack is empty");
            return null;
        } else {
            Product p = products[top--];
            return p;
        }
    }

    public Product peek() {
        if (top < 0) {
            System.out.println("Stack is empty");
            return null;
        } else {
            Product p = products[top];
            return p;
        }
    }

    public void printStack() {
        System.out.println(ANSI_RESET + "-----------------------------------------------------");
        System.out.printf("%s %15s %15s %15s %n", "ID", "Title", "Price", "Quantity");
        System.out.println("-----------------------------------------------------");
        for (int i = top; i > -1 ; i--) {
            System.out.println(products[i]);
        }
        System.out.println("-----------------------------------------------------");

    }

}
