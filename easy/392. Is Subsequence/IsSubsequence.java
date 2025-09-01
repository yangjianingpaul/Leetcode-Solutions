package isSubsequence;
public class IsSubsequence {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean subsequence = solution.isSubsequence("abc", "ahbgdc");
        System.out.println(subsequence);
    }
}

/**
 * Problem: 392. Is Subsequence
 * Difficulty: Easy
 * Approach: Two Pointers
 * Time: O(n), Space: O(n)
 */

class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        
        int index = 0;
        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(index) == t.charAt(i)) {
                if (index == s.length() - 1) {
                    return true;
                } else {
                    index++;
                }
            }
        }

        return false;
    }
}