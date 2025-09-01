package 15. 3Sum;

public class threeSum {
    
}

/**
 * Problem: 15. 3Sum
 * Difficulty: Medium
 * Approach: Two Pointers
 * Time: O(n), Space: O(n)
 */

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int p = i + 1;
            int q = nums.length - 1;

            if (nums[i] + nums[p] + nums[p + 1] > 0) {
                continue;
            }

            if (nums[i] + nums[q] + nums[q - 1] < 0) {
                continue;
            }

            while (p < q) {
                if (nums[i] + nums[p] + nums[q] > 0) {
                    q--;
                } else if (nums[i] + nums[p] + nums[q] < 0) {
                    p++;
                } else {
                    List<Integer> list = new LinkedList<>();
                    list.add(nums[i]);
                    list.add(nums[p]);
                    list.add(nums[q]);
                    set.add(list);
                    p++;
                    q--;
                }
            }
        }
        List<List<Integer>> result = new LinkedList<>(set);
        return result;
    }
}