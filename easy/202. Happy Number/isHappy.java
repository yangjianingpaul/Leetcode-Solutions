package 202. Happy Number;

public class isHappy {
    
}

/**
 * Problem: 202. Happy Number
 * Difficulty: Easy
 * Approach: HashMap for O(n) solution
 * Time: O(n), Space: O(n)
 */

class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> hashSet = new HashSet<Integer>();
        while (!hashSet.contains(n)) {
            hashSet.add(n);
            int sum = 0;
            while (n > 0) {
                int bit = n % 10;
                sum += bit * bit;
                n = n / 10;
            }
            if (sum == 1) {
                return true;
            }
            n = sum;
        }

        return false;
    }
}