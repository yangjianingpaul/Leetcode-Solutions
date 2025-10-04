class Solution {
    public int maxCoins(int[] nums) {
        int[] newNums = new int[nums.length + 2];
        newNums[0] = 1;
        newNums[newNums.length - 1] = 1;
        for (int i = 1; i <= nums.length; i++) {
            newNums[i] = nums[i - 1];
        }

        int[][] dp = new int[nums.length + 2][nums.length + 2];

        for (int length = 1; length <= nums.length; length++) {
            for (int left = 1; left < newNums.length - length; left++) {
                int right = left + length - 1;

                for (int k = left; k <= right; k++) {
                    dp[left][right] = Math.max(dp[left][right],
                            dp[left][k - 1] + newNums[left - 1] * newNums[k] * newNums[right + 1] + dp[k + 1][right]);
                }
            }
        }

        return dp[1][nums.length];
    }
}