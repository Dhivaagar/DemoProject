package DSA.LeetCode;

import DSA.LeetCode.LeetCodeLinkedList;

public class LeetCodeSolution {
    public static void main(String[] args) {
        LeetCodeLinkedList<Integer> list = new LeetCodeLinkedList<>();
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(0);
        list.display();
        System.out.println(list.numComponents(new int[]{0, 3, 1, 4}));
    }
}
