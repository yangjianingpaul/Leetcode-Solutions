package isValid;

import java.util.Stack;

public class IsValid {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean valid = solution.isValid("()[]{}");
        System.out.println(valid);
    }
}

/**
 * Problem: 20. Valid Parentheses
 * Difficulty: Easy
 * Approach: Stack
 * Time: O(n), Space: O(n)
 */

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else {
                if (s.charAt(i) == ')') {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                }

                if (s.charAt(i) == ']') {
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                }

                if (s.charAt(i) == '}') {
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                }
            }
        }

        if (stack.size() > 0) {
            return false;
        } else {
            return true;
        }
    }
}