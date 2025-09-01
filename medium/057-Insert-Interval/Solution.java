import java.util.ArrayList;

/**
 * Problem: 57. Insert Interval
 * Difficulty: Medium
 * Approach: Intervals
 * Time: O(n), Space: O(n)
 */

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            int[][] ans = new int[1][2];
            ans[0][0] = newInterval[0];
            ans[0][1] = newInterval[1];
            return ans;
        }

        int index;
        boolean flag = true;
        ArrayList<int[]> arrayList = new ArrayList<int[]>();
        for (index = 0; index < intervals.length; index++) {
            if (newInterval[0] > intervals[index][1]) {
                arrayList.add(intervals[index]);
            } else if (newInterval[1] < intervals[index][0]) {
                arrayList.add(newInterval);
                flag = false;
                break;
            } else {
                newInterval[0] = Math.min(newInterval[0], intervals[index][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[index][1]);

            }
        }

        if (flag) {
            arrayList.add(newInterval);
        }

        for (int i = index; i < intervals.length; i++) {
            arrayList.add(intervals[i]);
        }

        int[][] ans = new int[arrayList.size()][2];
        for (int i = 0; i < arrayList.size(); i++) {
            ans[i][0] = arrayList.get(i)[0];
            ans[i][1] = arrayList.get(i)[1];
        }

        return ans;
    }
}