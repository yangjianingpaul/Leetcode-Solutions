package permute;

import java.util.ArrayList;
import java.util.List;

public class permute {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 1, 2, 3 };
        solution.permute(nums);
    }
}

class Solution {
    List<List<Integer>> result = new ArrayList<List<Integer>>();

    public void dfs(List<Integer> list, List<Integer> rest) {
        if (rest.size() == 0) {
            List<Integer> arrayList = new ArrayList<Integer>(list);
            result.add(arrayList);
            return;
        }

        for (int i = 0; i < rest.size(); i++) {
            list.add(rest.get(i));
            rest.remove(i);
            dfs(list, rest);
            rest.add(0, list.get(list.size() - 1));
            list.remove(list.size() - 1);
        }

        return;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<Integer> rest = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            rest.add(nums[i]);
        }

        dfs(list, rest);
        return result;
    }
}