package reverseWords;
public class ReverseWords {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String reverseWords = solution.reverseWords(null);
        System.out.println(reverseWords);
    }
}

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