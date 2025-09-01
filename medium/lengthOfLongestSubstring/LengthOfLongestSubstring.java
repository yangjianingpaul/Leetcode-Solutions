package lengthOfLongestSubstring;
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int lengthOfLongestSubstring = solution.lengthOfLongestSubstring(null);
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int head = 0;
        int end = head + 1;
        int result = 1;
        while (head <= end && end < s.length()) {
            if (!s.substring(head, end).contains(s.charAt(end) + "")) {
                end++;
                result = Math.max(end - head, result);
            } else {
                head++;
            }
        }
        return result;
    }
}