/**
 * Problem: 70. Climbing Stairs
 * Difficulty: Easy
 * Approach: 1D DP
 * Time: O(n), Space: O(n)
 */

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