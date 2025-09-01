package 139. Word Break;

public class wordBreak {
    
}

/**
 * Problem: 139. Word Break
 * Difficulty: Medium
 * Approach: 1D DP
 * Time: O(n), Space: O(n)
 */

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        boolean[] flags = new boolean[length + 1];
        flags[0] = true;
        for (int i = 1; i <= length; i++) {
            int head = i - 1;
            while (head >= 0) {
                if (wordDict.contains(s.substring(head, i)) && flags[head]) {
                    flags[i] = true;
                    break;
                }
                head--;
            }
        }

        return flags[length];
    }
}