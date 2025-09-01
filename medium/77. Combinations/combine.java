package combine;

import java.util.ArrayList;
import java.util.List;

public class combine {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> result = solution.combine(4, 2);
        System.out.println(result);
    }
}

/**
 * Problem: 77. Combinations
 * Difficulty: Medium
 * Approach: Backtracking
 * Time: O(n), Space: O(n)
 */

class Solution {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public void dfs(int cur, int layer,int head,int end,List<Integer> list){
        if(cur==layer){
            ArrayList<Integer> arrayList = new ArrayList<Integer>(list);
            result.add(arrayList);
            return;
        }

        for(int i=head;i<end;i++){
            list.add(i+1);
            dfs(cur+1,layer,head+1,end,list);
            list.remove(list.size()-1);
            head++;
        }

        return;
    }

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> list=new ArrayList<>();
        dfs(0,k,0,n,list);
        return result;
    }
}