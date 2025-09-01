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