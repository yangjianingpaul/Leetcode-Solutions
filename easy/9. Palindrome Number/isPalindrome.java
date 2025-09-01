package 9. Palindrome Number;

public class isPalindrome {
    
}

/**
 * Problem: 9. Palindrome Number
 * Difficulty: Easy
 * Approach: Math
 * Time: O(n), Space: O(n)
 */

class Solution {
    public boolean isPalindrome(int x) {
        String s = Integer.toString(x);
        StringBuilder stringBuilder = new StringBuilder(s);
        StringBuilder reverse = stringBuilder.reverse();
        String s1 = reverse.toString();
        return s.equals(s1);
    }
}