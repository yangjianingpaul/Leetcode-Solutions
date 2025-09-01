package 13. Roman to Integer;

public class romanToInt {
    
}

/**
 * Problem: 13. Roman to Integer
 * Difficulty: Easy
 * Approach: Array / String
 * Time: O(n), Space: O(n)
 */

class Solution {
    public int romanToInt(String s) {
        
        int length=s.length();
        
        HashMap<Character,Integer> map=new HashMap<>(); 
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int sum=map.get(s.charAt(length-1));
        char lastChar=s.charAt(length-1);

        for(int i=length-2;i>=0;i--){
            Character chr=s.charAt(i);
            if(map.get(lastChar)>map.get(chr)){
                sum-=map.get(chr);
            }else{
                sum+=map.get(chr);
                lastChar=chr;
            }
        }
        return sum;
    }
}