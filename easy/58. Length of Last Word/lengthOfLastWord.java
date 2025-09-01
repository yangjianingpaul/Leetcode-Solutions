package 58. Length of Last Word;

public class lengthOfLastWord {
    
}

/**
 * Problem: 58. Length of Last Word
 * Difficulty: Easy
 * Approach: Array / String
 * Time: O(n), Space: O(n)
 */

class Solution {
    public int lengthOfLastWord(String s) {
        String[] split = s.split(" ");
        for (int i = split.length - 1; i >= 0; i--) {
            if (split[i].length() > 0) {
                return split[i].length();
            }
        }
        return 0;
    }
}