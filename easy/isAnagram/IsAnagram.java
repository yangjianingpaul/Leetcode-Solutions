package isAnagram;
import java.util.HashMap;

public class IsAnagram {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean anagram = solution.isAnagram(null, null);
    }
}

class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.containsKey(s.charAt(i))) {
                hashMap.put(s.charAt(i), hashMap.get(s.charAt(i)) + 1);
            } else {
                hashMap.put(s.charAt(i), 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            if (hashMap.containsKey(t.charAt(i))) {
                if (hashMap.get(t.charAt(i)) == 1) {
                    hashMap.remove(t.charAt(i));
                } else {
                    hashMap.put(t.charAt(i), hashMap.get(t.charAt(i)) - 1);
                }
            } else {
                return false;
            }
        }

        if (hashMap.size() > 0) {
            return false;
        } else {
            return true;
        }
    }
}