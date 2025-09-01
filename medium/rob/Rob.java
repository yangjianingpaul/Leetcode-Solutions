package rob;

public class Rob {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int rob = solution.rob(null);
        System.out.println(rob);
    }
}

class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] result = new int[nums.length];
        result[0] = nums[0];
        result[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            result[i] = Math.max(nums[i] + result[i - 2], result[i - 1]);
        }

        return result[nums.length - 1];
    }
}