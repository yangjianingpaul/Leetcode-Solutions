package jump;
public class Jump {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int jump = solution.jump(null);
        System.out.println(jump);
    }
}

class Solution {
    int result = 0;

    public int jump(int[] nums) {
        dfs(nums, nums.length - 1);
        return result;
    }

    public void dfs(int[] nums, int index) {
        if (index == 0) {
            return;
        }
        for (int i = 0; i <= index - 1; i++) {
            if (nums[i] >= index - i) {
                result++;
                dfs(nums, i);
                break;
            }
        }

        return;
    }
}