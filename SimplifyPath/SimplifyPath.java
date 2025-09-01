package SimplifyPath;

import java.util.Stack;

public class SimplifyPath {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "/home//foo/";
        String simplifyPath = solution.simplifyPath(str);
        System.out.println(simplifyPath);
    }
}

class Solution {
    public String simplifyPath(String path) {
        String[] split = path.split("/");
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < split.length; i++) {
            if (split[i].equals("..")) {
                if (stack.size() > 0) {
                    stack.pop();
                }
            } else if (split[i].length() > 0 && !split[i].equals(".")) {
                stack.push(split[i]);
            }
        }

        if (stack.isEmpty()) {
            return "/";
        }

        String result = "";
        while (stack.size() > 0) {
            result = "/" + stack.pop() + result;
        }

        return result;
    }
}