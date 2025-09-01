/**
 * Problem: 49. Group Anagrams
 * Difficulty: Medium
 * Approach: HashMap for O(n) solution
 * Time: O(n), Space: O(n)
 */

class Solution {
    ArrayList<HashMap<Character, Integer>> arrayList = new ArrayList<HashMap<Character, Integer>>();

    public void addHashMap(String str) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (hashMap.containsKey(str.charAt(i))) {
                hashMap.put(str.charAt(i), hashMap.get(str.charAt(i)) + 1);
            } else {
                hashMap.put(str.charAt(i), 1);
            }
        }
        arrayList.add(hashMap);
    }

    public boolean judgeHashMap(HashMap<Character, Integer> map, String str) {
        HashMap<Character,Integer> hashMap = new HashMap<>(map);
        for (int i = 0; i < str.length(); i++) {
            if (hashMap.containsKey(str.charAt(i))) {
                if (hashMap.get(str.charAt(i)) == 1) {
                    hashMap.remove(str.charAt(i));
                } else {
                    hashMap.put(str.charAt(i), hashMap.get(str.charAt(i)) - 1);
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

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        addHashMap(strs[0]);
        List<String> firstNode = new ArrayList<String>();
        firstNode.add(strs[0]);
        result.add(firstNode);

        for (int i = 1; i < strs.length; i++) {
            boolean flag = false;
            for (int j = 0; j < arrayList.size(); j++) {
                HashMap<Character, Integer> hashMap = arrayList.get(j);
                boolean judgeHashMap = judgeHashMap(hashMap, strs[i]);
                if (judgeHashMap) {
                    List<String> list = result.get(j);
                    list.add(strs[i]);
                    result.set(j, list);
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                addHashMap(strs[i]);
                List<String> strList = new ArrayList<String>();
                strList.add(strs[i]);
                result.add(strList);
            }
        }
        return result;
    }
}