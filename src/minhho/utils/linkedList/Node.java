package minhho.utils.linkedList;

/**
 * A node for LinkedList
 * @param <T> Generics form for data that node holds
 */
public class Node<T> {
    T info;
    Node prev;
    Node next;

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

    public Node getNext() {
        return next;
    }

    @Override
    public String toString() {
        return info.toString();

    }

}
