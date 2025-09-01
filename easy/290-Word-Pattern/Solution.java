import java.util.HashMap;

/**
 * Problem: 290. Word Pattern
 * Difficulty: Easy
 * Approach: HashMap for O(n) solution
 * Time: O(n), Space: O(n)
 */

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] strings = s.split(" ");
        if (pattern.length()!=strings.length) {
            return false;
        }

        HashMap<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            if (map.containsKey(pattern.charAt(i))) {
                if (!map.get(pattern.charAt(i)).equals(strings[i])) {
                    return false;
                }
            } else {
                if (map.containsValue(strings[i])) {
                    return false;
                } else {
                    map.put(pattern.charAt(i), strings[i]);
                }
            }
        }
        return true;
    }
}