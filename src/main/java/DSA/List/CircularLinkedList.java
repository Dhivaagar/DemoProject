package DSA.List;

import java.util.Iterator;

public class CircularLinkedList<K> implements Iterable<K>, List<K> {

    class Node {
        K data;
        Node pre, next;
        Node (K data) {
            this.data = data;
            pre = next = null;
        }
    }

    Node last;
    CircularLinkedList() {
        last = null;
    }
    @Override
    public void add(K data) {
        Node newNode = new Node(data);

    }

    @Override
    public void display() {

    }

    @Override
    public void insertAtPos(K data, int pos) {

    }

    @Override
    public void deleteAtPos(int pos) {

    }

    @Override
    public K get(int index) {
        return null;
    }

    @Override
    public void update(K data, int index) {

    }

    @Override
    public void deleteAtEnd() {

    }

    @Override
    public void insertAtEnd(K value) {

    }

    @Override
    public int search(K value) {
        return 0;
    }

    @Override
    public boolean contains(K value) {
        return false;
    }

    @Override
    public void reverse() {

    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<K> iterator() {
        return null;
    }
}
