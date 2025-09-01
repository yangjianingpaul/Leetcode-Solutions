import java.util.ArrayList;

/**
 * Problem: 56. Merge Intervals
 * Difficulty: Medium
 * Approach: Intervals
 * Time: O(n), Space: O(n)
 */

class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> arrayList = new ArrayList<int[]>();
        ArrayList<int[]> ans = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; i++) {
            arrayList.add(intervals[i]);
        }

        while (arrayList.size() > 0) {
            int[] newInterval = new int[2];
            newInterval[0] = arrayList.get(0)[0];
            newInterval[1] = arrayList.get(0)[1];

            for (int i = 1; i < arrayList.size(); i++) {
                if (!(arrayList.get(i)[0] > newInterval[1] ||
                        arrayList.get(i)[1] < newInterval[0])) {
                    newInterval[0] = Math.min(newInterval[0], arrayList.get(i)[0]);
                    newInterval[1] = Math.max(newInterval[1], arrayList.get(i)[1]);
                    arrayList.remove(i);
                    i--;
                }
            }

            for (int j = 0; j < ans.size(); j++) {
                if (!(ans.get(j)[0] > newInterval[1] ||
                        ans.get(j)[1] < newInterval[0])) {
                    newInterval[0] = Math.min(newInterval[0], ans.get(j)[0]);
                    newInterval[1] = Math.max(newInterval[1], ans.get(j)[1]);
                    ans.remove(j);
                    j--;
                }
            }

            ans.add(newInterval);
            arrayList.remove(0);
        }

        int[][] result = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            result[i][0] = ans.get(i)[0];
            result[i][1] = ans.get(i)[1];
        }

        return result;
    }
}