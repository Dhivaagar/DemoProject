package DSA.List;

import java.util.Iterator;

public class DoublyLinkedList<K> implements List<K>, Iterable<K> {

    class Node{
        Node pre, next;
        K data;
        Node(K data) {
            this.data = data;
            next = pre = null;
        }
    }

    Node head, tail;
    int length = 0;
    public DoublyLinkedList() { head = tail = null; }

    @Override
    public void add(K data) {
        Node newNode = new Node(data);
        newNode.pre = tail;
        if(tail==null)
            head = newNode;
        else 
            tail.next = newNode;
        tail = newNode;
        length++;
    }

    @Override
    public void display() {
        if(head==null)
            System.out.println("List is empty");
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
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
        preNode.next.pre = newNode;
        newNode.next = preNode.next;
        newNode.pre = preNode;
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
        for (int i = 1; i<pos; i++) {
            preNode = preNode.next;
        }
        preNode.next.next.pre = preNode.next.pre;
        preNode.next = preNode.next.next;
    }

    private void deleteAtBeginning() {
        head = head.next;
        head.pre = null;
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
        tail = tail.pre;
        tail.next = null;
    }

    @Override
    public void insertAtEnd(K value) {
        Node newNode = new Node(value);
        newNode.pre = tail;
        tail.next = tail = newNode;
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
        if(head==null)
            System.out.println("List is empty");
        Node node = tail;
        while(node != null) {
            System.out.print(node.data + " ");
            node = node.pre;
        }
        System.out.print("\n");
    }

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
