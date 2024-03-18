package pratice;

import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[')
                stack.push(ch);
            else {
                if (stack.isEmpty()) return false;
                else if (ch == ')') {
                    if (stack.peek() == '(')
                        stack.pop();
                    else return false;
                } else if (ch == '}') {
                    if (stack.peek() == '{')
                        stack.pop();
                    else return false;
                } else if (ch == ']') {
                    if (stack.peek() == '{')
                        stack.pop();
                    else return false;
                }
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        System.out.println(isValid("{(})"));
        int i=5;
        System.out.printf("%d %d %d %d %d", i++, i--, ++i, --i, i);
        //code for print 1 to 10
        for (int j = 1; j <= 10; j++) {
            System.out.println(j);
        }
    }
}
