package maxProfit;
public class MaxProfit {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int maxProfit = solution.maxProfit(null);
        System.out.println(maxProfit);
    }
}

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