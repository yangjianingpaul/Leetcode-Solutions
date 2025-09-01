package 205. Isomorphic Strings;

public class isIsomorphic {
    
}

/**
 * Problem: 205. Isomorphic Strings
 * Difficulty: Easy
 * Approach: HashMap for O(n) solution
 * Time: O(n), Space: O(n)
 */

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }

        HashMap<Character,Character> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char chrS=s.charAt(i);
            char chrT=t.charAt(i);

            if(map.containsKey(chrS)){
                if(map.get(chrS)!=chrT){
                    return false;
                }
            }else{
                if(map.containsValue(chrT)){
                    return false;
                }
                map.put(chrS,chrT);
            }
        }
        return true;
    }
}