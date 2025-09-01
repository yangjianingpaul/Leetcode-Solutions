package summaryRanges;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 0, 1, 2, 4, 5, 7 };
        List<String> summaryRanges = solution.summaryRanges(nums);
        System.out.println(summaryRanges);
    }
}

/**
 * Problem: 228. Summary Ranges
 * Difficulty: Easy
 * Approach: Intervals
 * Time: O(n), Space: O(n)
 */

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        if (nums.length == 0) {
            return result;
        }
        int head = 0;
        int i = 0;
        for (; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] != 1) {
                if (head == i) {
                    result.add(nums[head] + "");
                } else {
                    result.add(nums[head] + "->" + nums[i]);
                }
                head = i + 1;
            }
        }

        if (head == i) {
            result.add(nums[head] + "");
        } else {
            result.add(nums[head] + "->" + nums[i]);
        }
        return result;
    }
}