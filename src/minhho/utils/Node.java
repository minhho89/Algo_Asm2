package minhho.utils;

public class Node<T> {
    T info;
    Node prev;
    Node next;


    public Node() {
    }

    public Node(T info) {
        this.info = info;
        prev = null;
        next = null;
    }

    @Override
    public String toString() {
        return info.toString();

    }

}
