import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Problem: 49. Group Anagrams
 * Difficulty: Medium
 * Approach: HashMap for O(n) solution
 * Time: O(n), Space: O(n)
 * charArray to String=>new String(charArray)
 */

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<String, List<String>>();
        for (int i = 0; i < strs.length; i++) {
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            String string = new String(charArray);
            List<String> list = new ArrayList<String>();

            if (hashMap.containsKey(string)) {
                list = hashMap.get(string);

            }

            list.add(strs[i]);
            hashMap.put(string, list);
        }

        List<List<String>> result = new ArrayList<List<String>>();
        for (List<String> list : hashMap.values()) {
            result.add(list);
        }
        return result;
    }
}