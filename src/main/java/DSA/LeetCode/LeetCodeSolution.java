package DSA.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LeetCodeSolution {

    public static void main (String[] args) {
        System.out.println(longestPalindrome("ac"));
    }

    public static String longestPalindrome(String s) {

        if(s.length() < 2)
            return s;

        String result = "";
        int max = Integer.MIN_VALUE;
        for(int i=0; i<s.length(); i++) {

            int l = i, r = i;
            r = s.length()%2 == 0 ? r+1 : r;
            while(l >= 0 && r < s.length() && (s.charAt(l) == s.charAt(r))) {

                if(max < (r - l + 1)) {

                    result = s.substring(l, r+1);
                    max = r - l + 1;
                }

                l--; r++;
            }
        }

        return result;
    }
}
