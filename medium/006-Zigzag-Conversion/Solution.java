import java.util.ArrayList;

/**
 * Problem: 6. Zigzag Conversion
 * Difficulty: Medium
 * Approach: Array / String
 * Time: O(n), Space: O(n)
 */

class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        List<String> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            String str = "";
            list.add(str);
        }
        int index = 0;
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            if (index == 0) {
                flag = true;
            }

            if (index == numRows - 1) {
                flag = false;
            }

            String s1 = list.get(index) + s.charAt(i);
            list.set(index, s1);

            if (flag) {
                index++;
            } else {
                index--;
            }
        }
        String result = "";
        for (int i = 0; i < list.size(); i++) {
            result += list.get(i);
        }
        return result;
    }
}