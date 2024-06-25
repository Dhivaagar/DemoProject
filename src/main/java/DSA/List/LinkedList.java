package DSA.List;

import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Iterator;
public class LinkedList<K> implements Iterable<K>, List<K> {
    @Setter
    @Getter
    protected class Node {
        K data;
        Node next;
        Node(K data) {
            this.data = data;
            next = null;
        }
    }
    protected int length = 0;
    protected Node head;
    public LinkedList() { head = null; }

    @Override
    public void add(K data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        length++;
    }

    @Override
    public void display() {
        Node node = head;
        while(node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.print("\n");
    }

    @Override
    public void insertAtPos(K data, int pos) {
        if(pos>length-1){
            System.out.println("Index out of bounder(0 to " + (length-1) + ")!!...");
            return;
        }
        if (pos == 0){
            add(data);
            return;
        }
        Node newNode = new Node(data);
        Node preNode = head;
        for (int i = 1; i<pos; i++) {
            preNode = preNode.next;
        }
        newNode.next = preNode.next;
        preNode.next = newNode;
    }

    @Override
    public void deleteAtPos(int pos) {
        if(pos>length-1){
            System.out.println("Index out of bounder(0 to " + (length-1) + ")!!...");
            return;
        }
        if (pos == 0){
            deleteAtBeginning();
            return;
        }
        Node preNode = head;
        for (int i = 1; i<=pos; i++) {
            preNode = preNode.next;
        }
        preNode.next = preNode.next.next;
    }

    @Override
    public K get(int index) {
        Node node = head;
        if (index > length-1){
            System.out.println("Index out of bounder(0 to " + (length-1) + ")!!...");
            return null;
        }
        if (index == 0){
            return head.data;
        }
        for (int i = 1; i<=index; i++) {
            node = node.next;
        }
        return node.data;
    }

    @Override
    public void update(K data, int index) {
        Node node = head;
        if (index > length-1){
            System.out.println("Index out of bounder(0 to " + (length-1) + ")!!...");
            return;
        }
        if (index == 0){
            head.data = data;
            return;
        }
        for (int i = 1; i<=index; i++) {
            node = node.next;
        }
        node.data = data;
    }

    @Override
    public void deleteAtEnd() {
        Node node = head;
        if(head.next == null) {
            head = null;
            return;
        }
        for (int i = 1; i<length-1; i++) {
            node = node.next;
        }
        node.next = null;
    }

    @Override
    public void insertAtEnd(K value) {
        Node newNode = new Node(value);
        Node node = head;
        if(head == null) {
            head = newNode;
            return;
        }
        if(node.next == null) {
            head.next = newNode;
            return;
        }
        for (int i = 1; i<length-1; i++) {
            node = node.next;
        }
        node.next = newNode;
    }

    @Override
    public int search(K value) {
        Node node = head;
        int index = 0;
        while(node != null) {
            if (node.data.equals(value)){
                return index;
            }
            index++;
            node = node.next;
        }
        return -1;
    }

    @Override
    public boolean contains(K value) {
        Node node = head;
        while(node != null) {
            if (node.data.equals(value)){
                return true;
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public void reverse() {
        Node pre = null;
        Node crr = head;
        Node next;
        while (crr != null) {
            next = crr.next;
            crr.next = pre;
            pre = crr;
            crr = next;
        }
        head = pre;
    }

    public void removeAll(K value) {
        if (head == null) {
            return;
        }
        Node node = head;
        Node preNode;
        while(node.next != null) {
            if (head.data.equals(value)) {
                head = head.next;
                node = head;
                continue;
            }
            preNode = node;
            node = node.next;
            if (node.data.equals(value)){
                node = preNode;
                node.next = node.next.next;
            }
        }
        if (head.data.equals(value)) {
            head = head.next;
        }
    }

    private void deleteAtBeginning() { head = head.next; }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<K> iterator() {
        return new Iterator<>() {
            Node temp = head;
            @Override
            public boolean hasNext() {
                return temp != null;
            }

            @Override
            public K next() {
                K val = temp.data;
                temp = temp.next;
                return val;
            }
        };
    }
}
