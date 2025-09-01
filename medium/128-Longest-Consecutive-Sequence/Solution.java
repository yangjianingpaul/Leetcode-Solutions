import java.util.HashSet;

/**
 * Problem: 128. Longest Consecutive Sequence
 * Difficulty: Easy
 * Approach: HashMap for O(n) solution
 * Time: O(n), Space: O(n)
 */

class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        int result=0;
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }

        for(int i=0;i<nums.length;i++){
            int num=nums[i];
            if(!set.contains(num-1)){
                int length=1;
                num++;
                while(set.contains(num)){
                    length++;
                    num++;
                }
                result=Math.max(result,length);
            }
        }
        return result;
    }
}