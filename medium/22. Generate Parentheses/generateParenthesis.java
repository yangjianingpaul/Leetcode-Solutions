package generateParenthesis;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class generateParenthesis {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> parenthesis = solution.generateParenthesis(3);
        System.out.println(parenthesis);
    }
}

/**
 * Problem: 22. Generate Parentheses
 * Difficulty: Medium
 * Approach: Backtracking
 * Time: O(n), Space: O(n)
 */

class Solution {
    List<String> result = new ArrayList<String>();

    public void dfs(Stack<String> stack, String str, int n) {
        if (n == 0) {
            result.add(str);
            return;
        }

        if (stack.size() == 0) {
            stack.push("(");
            str += "(";
            dfs(stack, str, n);
        } else if (stack.size() == n) {
            stack.pop();
            str += ")";
            n--;
            dfs(stack, str, n);
        } else {
            stack.push("(");
            str += "(";
            dfs(stack, str, n);

            if (stack.size() > 0) {
                stack.pop();
                str = str.substring(0, str.length() - 1);

                stack.pop();
                str += ")";
                n--;
                dfs(stack, str, n);
            }
        }

        return;
    }

    public List<String> generateParenthesis(int n) {
        Stack<String> stack = new Stack<String>();
        dfs(stack, "", n);
        return result;
    }
}