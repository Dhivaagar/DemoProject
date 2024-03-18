package pratice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Name {
    public static void main(String[] args) {
        String sentence1 = "Hey first last,";
        String sentence2 = "Hey first,";
        String sentence3 = "Hey,";

        String[] arr1 = sentence1.replaceAll(",", "").replaceAll("Hey ", "").split(" ");
        String[] arr2 = {"First", "hello"};
        List<String> l = new ArrayList<>(Arrays.asList(arr1));
        l.set(0, arr2[0]);
        l.add(1, arr2[1]);

        System.out.println(l);

        List<String> list1 = Arrays.asList("test autostorage", "910-456-3240");
        List<String> list2 = Arrays.asList("test autostorage", "910-456-3240");

        if (list1.containsAll(list2)) {
            System.out.println("List1 contains all elements of list2");
        } else {
            System.out.println("List1 does not contain all elements of list2");
        }


    }
}
