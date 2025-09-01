package canConstruct;
import java.util.HashMap;

public class CanConstruct {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean canConstruct = solution.canConstruct(null, null);
    }
}

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        for (int i = 0; i < magazine.length(); i++) {
            if (!hashMap.containsKey(magazine.charAt(i))) {
                hashMap.put(magazine.charAt(i), 1);
            } else {
                hashMap.put(magazine.charAt(i), hashMap.get(magazine.charAt(i)) + 1);
            }
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (hashMap.containsKey(ransomNote.charAt(i))) {
                if (hashMap.get(ransomNote.charAt(i)) == 1) {
                    hashMap.remove(ransomNote.charAt(i));
                } else {
                    hashMap.put(ransomNote.charAt(i), hashMap.get(ransomNote.charAt(i)) - 1);
                }
            } else {
                return false;
            }
        }
        return true;
    }
}