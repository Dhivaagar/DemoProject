package DSA.LeetCode;


import DSA.List.LinkedList;

public class LeetCodeLinkedList<K> extends LinkedList<K> {

    public boolean isPalindrome() {
        Node temp = head;
        StringBuilder normal = new StringBuilder();
        StringBuilder reverse = new StringBuilder();
        while (temp != null) {
            normal.insert(0, temp.getData());
            reverse.append(temp.getData());
            temp = temp.getNext();
        }
        return normal.toString().contentEquals(reverse);
    }
    public int getDecimalValue() {
        int binaryConvert = 1;
        int binaryValue = 0;
        StringBuilder str = new StringBuilder();
        Node node = head;
        while (node != null) {
            str.insert(0, node.getData());
            node = node.getNext();
        }
        for (int i=0; i<str.length(); i++) {
            if(str.charAt(i) == '1') {
                binaryValue += binaryConvert;
            }
            binaryConvert = binaryConvert * 2;
        }
        return binaryValue;
    }

    public int numComponents(int[] nums) {
        int result = 0;
        Node node = head;
        while (node != null) {
            for (int i = 0; i < nums.length; i++) {
                if (node.getData().equals(nums[i])) {
                    for (int j = 0; j < nums.length; j++) {
                        if (i!=j && node.getNext()!= null && node.getNext().getData().equals(nums[j])) {
                            result++;
                        }
                    }
                }
            }
            node = node.getNext();
        }
        return result;
    }
}
