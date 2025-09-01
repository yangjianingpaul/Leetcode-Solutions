/**
 * Problem: 17. Letter Combinations of a Phone Number
 * Difficulty: Medium
 * Approach: Backtracking
 * Time: O(n), Space: O(n)
 */

class Solution {

    public List<String> result = new ArrayList<>();

    public void dfs(String str, int layer, String digits, HashMap<Character, String> map) {
        if (layer == digits.length()) {
            result.add(str);
            return;
        }

        String strDigits = map.get(digits.charAt(layer));
        for (int i = 0; i < strDigits.length(); i++) {
            str = str + strDigits.charAt(i);
            dfs(str, layer + 1, digits, map);
            str = str.substring(0, str.length() - 1);
        }

        return;
    }

    public List<String> letterCombinations(String digits) {
        HashMap<Character, String> map = new HashMap<Character, String>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        dfs("", 0, digits, map);
        return result;
    }
}