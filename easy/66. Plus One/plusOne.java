package 66. Plus One;

public class plusOne {
    
}

/**
 * Problem: 66. Plus One
 * Difficulty: Easy
 * Approach: Math
 * Time: O(n), Space: O(n)
 */

class Solution {
    public int[] plusOne(int[] digits) {
        int plus=1;
        for (int i=digits.length-1;i>=0;i--) {
            int result = digits[i] + plus;
            if (result>=10) {
                digits[i]=result%10;
                plus=1;
            } else {
                digits[i]=result;
                plus=0;
            }
        }
        
        if (plus==1) {
            int[] ints = new int[digits.length + 1];
            ints[0]=1;
            for (int i=0;i<digits.length;i++) {
                ints[i+1]=digits[i];
            }
            return ints;
        }
        return digits;
    }
}