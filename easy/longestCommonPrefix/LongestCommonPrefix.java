package longestCommonPrefix;
public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String longestCommonPrefix = solution.longestCommonPrefix(args);
        System.out.println(longestCommonPrefix);
    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String result = "";
        for (int i = 0; i < strs[0].length(); i++) {
            char cur = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() <= i || strs[j].charAt(i) != cur) {
                    return result;
                }
            }
            result += cur;
        }
        return result;
    }
}