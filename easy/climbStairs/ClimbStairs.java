package climbStairs;

import java.util.ArrayList;

public class ClimbStairs {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int climbStairs = solution.climbStairs(0);
        System.out.println(climbStairs);
    }
}

class Solution {
    public int climbStairs(int n) {
        int[] result = new int[n + 1];
        result[0] = 1;
        result[1] = 1;
        for (int i = 2; i <= n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result[n];
    }
}