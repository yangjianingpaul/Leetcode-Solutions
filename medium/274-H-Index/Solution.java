import java.util.Arrays;

/**
 * Problem: 274. H-Index
 * Difficulty: Medium
 * Approach: Array / String
 * Time: O(n), Space: O(n)
 */

class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int length = citations.length;
        for (int i = 0; i < length; i++) {
            if (citations[i] >= length - i) {
                return length - i;
            }
        }
        return 0;
    }
}