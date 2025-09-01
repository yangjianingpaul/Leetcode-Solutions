/**
 * Problem: 121. Best Time to Buy and Sell Stock
 * Difficulty: Easy
 * Approach: Array / String
 * Time: O(n), Space: O(n)
 */

class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
                continue;
            }
            result = Math.max(result, prices[i] - minPrice);
        }
        return result;
    }
}