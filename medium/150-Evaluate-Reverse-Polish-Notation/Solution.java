import java.util.Stack;

/**
 * Problem: 150. Evaluate Reverse Polish Notation
 * Difficulty: Medium
 * Approach: Stack
 * Time: O(n), Space: O(n)
 */

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<tokens.length;i++){
            if(tokens[i].equals("+")){
                int a=stack.pop();
                int b=stack.pop();
                a+=b;
                stack.push(a);
            } else if(tokens[i].equals("-")){
                int a=stack.pop();
                int b=stack.pop();
                b-=a;
                stack.push(b);
            } else if(tokens[i].equals("*")){
                int a=stack.pop();
                int b=stack.pop();
                a*=b;
                stack.push(a);
            }else if(tokens[i].equals("/")){
                int a=stack.pop();
                int b=stack.pop();
                b/=a;
                stack.push(b);
            }else{
                int a=Integer.parseInt(tokens[i]);
                stack.push(a);
            }
        }
        return stack.pop();
    }
}