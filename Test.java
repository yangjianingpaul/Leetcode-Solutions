import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] coins = { 1 };
        int coinChange = solution.coinChange(coins, 0);
        System.out.println(coinChange);
    }
}

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