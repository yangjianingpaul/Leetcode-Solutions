package 380. Insert Delete GetRandom O(1);

public class insert {
    
}

/**
 * Problem: 380. Insert Delete GetRandom O(1)
 * Difficulty: Medium
 * Approach: Array / String
 * Time: O(n), Space: O(n)
 */

class RandomizedSet {

    List<Integer> list;

    public RandomizedSet() {
        list = new ArrayList<Integer>();
    }

    public boolean insert(int val) {
        if (!list.contains(val)) {
            list.add(val);
            return true;
        } else {
            return false;
        }
    }

    public boolean remove(int val) {
        if (list.contains(val)) {
            HashSet<Integer> set = new HashSet<>(list);
            set.remove(val);
            list = new ArrayList<Integer>(set);
            return true;
        } else {
            return false;
        }
    }

    public int getRandom() {
        int size = list.size();
        Random random = new Random();
        return list.get(random.nextInt(size));
    }
}