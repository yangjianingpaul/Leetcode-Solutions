
 /**
 * Problem: 76. Minimum Window Substring
 * Difficulty: hard
 * Approach: slid window
 * Time: O(n), Space: O(n)
 */

class Solution {
    public boolean containAllCharacter(HashMap<Character, Integer> hashMap) {
        boolean result = true;
        Set<Character> keySet = hashMap.keySet();
        for (Character character : keySet) {
            if (hashMap.get(character) > 0) {
                result = false;
                break;
            }
        }

        return result;
    }

    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        String result = "";
        int length = Integer.MAX_VALUE;

        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            if (hashMap.containsKey(t.charAt(i))) {
                Integer keyNum = hashMap.get(t.charAt(i));
                hashMap.put(t.charAt(i), keyNum + 1);
            } else {
                hashMap.put(t.charAt(i), 1);
            }
        }

        int head = 0;
        int end = 0;

        for (end = 0; end < s.length(); end++) {
            if (hashMap.containsKey(s.charAt(end))) {
                Integer endKey = hashMap.get(s.charAt(end));
                endKey--;
                hashMap.put(s.charAt(end), endKey);

                while (endKey == 0 && containAllCharacter(hashMap) && head <= end) {
                    if (hashMap.containsKey(s.charAt(head))) {
                        Integer headKey = hashMap.get(s.charAt(head));
                        if (headKey == 0) {
                            if (end - head < length) {
                                length = end - head;
                                result = s.substring(head, end + 1);
                            }
                        }

                        headKey++;
                        hashMap.put(s.charAt(head), headKey);
                        head++;
                    } else {
                        head++;
                    }
                }
            }
        }

        return result;
    }
}