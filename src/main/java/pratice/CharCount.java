package pratice;

import java.util.*;
public class CharCount{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] arr = str.toCharArray();
        HashMap<Character, Integer> hm = new HashMap<>();

        for(char ch:arr){
            if(hm.containsKey(ch))
                hm.put(ch, hm.get(ch)+1);
            else
                hm.put(ch, 1);

            //System.out.println(ch);
        }

        System.out.println(hm);
    }
}