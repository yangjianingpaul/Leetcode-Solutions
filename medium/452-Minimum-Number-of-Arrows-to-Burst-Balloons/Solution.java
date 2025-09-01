import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Problem: 452. Minimum Number of Arrows to Burst Balloons
 * Difficulty: Medium
 * Approach: Intervals
 * Time: O(n), Space: O(n)
 */

class Solution {
    public int findMinArrowShots(int[][] points) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> pointsList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < points.length; i++) {
            ArrayList<Integer> arrayList = new ArrayList<Integer>();
            arrayList.add(points[i][0]);
            arrayList.add(points[i][1]);
            pointsList.add(arrayList);
        }

        Collections.sort(pointsList, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o2.get(1).compareTo(o1.get(1));
            }
        });

        for (int i = 0; i < pointsList.size(); i++) {
            for (int j = 0; j < result.size(); j++) {
                if ((result.get(j).get(0) <= pointsList.get(i).get(0)
                        && result.get(j).get(1) >= pointsList.get(i).get(0)) ||
                        (result.get(j).get(0) <= pointsList.get(i).get(1)
                                && result.get(j).get(1) >= pointsList.get(i).get(1))
                        ||
                        (result.get(j).get(0) <= pointsList.get(i).get(0)
                                && result.get(j).get(1) >= pointsList.get(i).get(1))
                        ||
                        (result.get(j).get(0) >= pointsList.get(i).get(0)
                                && result.get(j).get(1) <= pointsList.get(i).get(1))) {
                    ArrayList<Integer> arrayList = pointsList.get(i);
                    arrayList.set(0, Math.max(pointsList.get(i).get(0), result.get(j).get(0)));
                    arrayList.set(1, Math.min(pointsList.get(i).get(1), result.get(j).get(1)));
                    pointsList.set(i, arrayList);
                    result.remove(j);
                    j--;
                }
            }

            ArrayList<Integer> list = new ArrayList<>();
            list.add(pointsList.get(i).get(0));
            list.add(pointsList.get(i).get(1));
            result.add(list);
        }
        return result.size();
    }
}