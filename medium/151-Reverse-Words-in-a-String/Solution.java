/**
 * Problem: 151. Reverse Words in a String
 * Difficulty: Medium
 * Approach: Array / String
 * Time: O(n), Space: O(n)
 */

class Solution {
    public String reverseWords(String s) {
        String[] split = s.split(" ");
        String result = "";
        for (int i = split.length - 1; i >= 0; i--) {
            if (split[i].length() > 0) {
                result = result + split[i] + " ";
            }
        }
        return result.trim();
    }
}