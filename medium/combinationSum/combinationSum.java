package combinationSum;

import java.util.ArrayList;
import java.util.List;

public class combinationSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] candidates = { 2, 3, 6, 7 };
        List<List<Integer>> combinationSum = solution.combinationSum(candidates, 7);
        System.out.println(combinationSum);
    }
}

class Solution {
    List<List<Integer>> result = new ArrayList<List<Integer>>();

    public void dfs(int[] candidates, int index, int target, List<Integer> list, int sum) {
        for (int i = index; i < candidates.length; i++) {
            sum += candidates[i];
            if (sum == target) {
                list.add(candidates[i]);
                List<Integer> arrayList = new ArrayList<>(list);
                result.add(arrayList);
                list.remove(list.size() - 1);
                return;
            } else if (sum > target) {
                return;
            }

            list.add(candidates[i]);
            dfs(candidates, i, target, list, sum);
            sum -= list.get(list.size() - 1);
            list.remove(list.size() - 1);
        }
        return;
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        dfs(candidates, 0, target, list, 0);
        return result;
    }
}