/**
 * Problem: 322. Coin Change
 * Difficulty: Medium
 * Approach: 1D DP
 * Time: O(n), Space: O(n)
 */

class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        int[] arr = new int[amount + 1];
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= amount) {
                arr[coins[i]] = 1;
            }
        }

        for (int i = 0; i < amount; i++) {
            if (arr[i] > 0) {
                for (int j = 0; j < coins.length; j++) {
                    if (i + coins[j] > 0 && i + coins[j] <= amount) {
                        if (arr[i + coins[j]] > 0) {
                            arr[i + coins[j]] = Math.min(arr[i] + 1, arr[i + coins[j]]);
                        } else {
                            arr[i + coins[j]] = arr[i] + 1;
                        }
                    }
                }
            }
        }

        if (arr[amount] == 0) {
            return -1;
        } else {
            return arr[amount];
        }
    }
}