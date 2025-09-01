package isPalindrome;
public class IsPalindrome {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean palindrome = solution.isPalindrome(null);
        System.out.println(palindrome);
    }
}

class Solution {
    public boolean isPalindrome(String s) {
        String lowerCase = s.toLowerCase();
        int head = 0;
        int end = lowerCase.length() - 1;
        while (head <= end) {
            if (!((lowerCase.charAt(head) >= 'a' && lowerCase.charAt(head) <= 'z') ||
                    (lowerCase.charAt(head) >= '0' && lowerCase.charAt(head) <= '9'))) {
                head++;
                continue;
            }

            if (!((lowerCase.charAt(end) >= 'a' && lowerCase.charAt(end) <= 'z') ||
                    (lowerCase.charAt(end) >= '0' && lowerCase.charAt(end) <= '9'))) {
                end--;
                continue;
            }

            if (lowerCase.charAt(head) == lowerCase.charAt(end)) {
                head++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }
}