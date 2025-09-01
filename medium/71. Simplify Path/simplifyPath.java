package 71. Simplify Path;

public class simplifyPath {
    
}

/**
 * Problem: 71. Simplify Path
 * Difficulty: Medium
 * Approach: Stack
 * Time: O(n), Space: O(n)
 */

class Solution {
    public String simplifyPath(String path) {
        String[] strs = path.split("/");
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if ((!strs[i].equals(".")) && strs[i].length() > 0) {
                stack.push(strs[i]);
            }
        }

        String result = "";
        while (!stack.isEmpty()) {
            result = stack.pop() + result;
            result = "/" + result;
        }
        if (result.length() == 0) {
            return "/";
        } else {
            return result;
        }

    }
}