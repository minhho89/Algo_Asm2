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

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }



    @Override
    public String toString() {
        return info.toString();

    }


}
