package minhho.utils;

public class Node<T> {
    T info;
    Node next;

    public Node() {
    }

    public Node(T info) {
        this.info = info;
        next = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "info=" + info +
                ", next=" + next.info +
                '}';
    }

}
