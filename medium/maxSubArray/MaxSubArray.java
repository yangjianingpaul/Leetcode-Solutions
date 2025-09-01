package maxSubArray;

public class MaxSubArray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int maxSubArray = solution.maxSubArray(null);
        System.out.println(maxSubArray);
    }
}

class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int result = sum;
        for (int i = 1; i < nums.length; i++) {
            if (sum < 0) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            result = Math.max(result, sum);
        }

        return Math.max(sum, result);
    }
}