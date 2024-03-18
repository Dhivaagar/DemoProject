package DSA.List;

public interface List<K> {
    void add(K data);
    void display();
    void insertAtPos(K data, int pos);
    void deleteAtPos(int pos);
    K get(int index);
    void update(K data, int index);
    void deleteAtEnd();
    void insertAtEnd(K value);
    int search(K value);
    boolean contains(K value);
    void reverse();
}
