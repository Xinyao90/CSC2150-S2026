package lec19Prep;

import java.util.ArrayDeque;
import java.util.Deque;

public class BalancedParenthesesDemo {
    /**
     * Returns true if and only if the parentheses in s are balanced.
     *
     * Rules:
     * - Use a stack
     * - Push '('
     * - Pop when ')'
     * - Must be empty at end
     *
     * Examples:
     * "()"   -> true
     * "(())" -> true
     * "(()"  -> false
     * "())(" -> false
     */
    public static boolean isBalanced(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                // A closing paren needs a matching opening paren.
                if (stack.isEmpty()) return false;
                stack.pop();
            }
            // If you want to ignore other characters, do nothing.
            // If you want to reject any non-paren characters, return false here.
        }
        // Balanced only if no unmatched '(' remain.
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
