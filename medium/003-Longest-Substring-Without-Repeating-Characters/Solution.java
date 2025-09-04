import java.util.HashSet;

/**
 * Problem: 3. Longest Substring Without Repeating Characters
 * Difficulty: Medium
 * Approach: Sliding Window
 * Time: O(n), Space: O(n)
 */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int head = 0;
        int end = 1;
        int result = 1;

        if (s.equals("")) {
            return 0;
        }

        HashSet<Character> hashSet = new HashSet<Character>();
        hashSet.add(s.charAt(head));
        while (head <= end && end < s.length()) {
            if (!hashSet.contains(s.charAt(end))) {
                hashSet.add(s.charAt(end));
                end++;
                result = Math.max(result, end - head);
            } else {
                hashSet.remove(s.charAt(head));
                head++;
            }
        }

        return result;
    }
}