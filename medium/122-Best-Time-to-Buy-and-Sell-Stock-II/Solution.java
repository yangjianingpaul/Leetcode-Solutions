/**
 * Problem: 122. Best Time to Buy and Sell Stock II
 * Difficulty: Medium
 * Approach: Array / String
 * Time: O(n), Space: O(n)
 */

class Solution {
    public int maxProfit(int[] prices) {
        int[] profits=new int[prices.length];
        profits[0]=0;
        for(int i=1;i<prices.length;i++){
            int max=profits[i-1];
            for(int j=i-1;j>=0;j--){
                max=Math.max(max, profits[j]+prices[i]-prices[j]);
            }
            profits[i]=max;
        }
        return profits[profits.length-1];
    }
}