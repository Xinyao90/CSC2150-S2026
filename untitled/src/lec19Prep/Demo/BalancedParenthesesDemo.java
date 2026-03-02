package lec19Prep.Demo;

import java.util.ArrayDeque;
import java.util.Deque;

public class BalancedParenthesesDemo {
    public static boolean isBalanced(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') { // String " "; char ' ';
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
    static void main(String[] args) {
        String[] tests = {
                "()",
                "(())",
                "(()",
                "())(",
                "",
                "(((())))",
                ")(",
                "(()())()"
        };
        for (String t : tests) {
            System.out.printf("isBalanced(\"%s\") = %s%n", t, isBalanced(t));
        }
    }
}
