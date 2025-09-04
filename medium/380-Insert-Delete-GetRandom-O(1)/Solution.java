import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Problem: 380. Insert Delete GetRandom O(1)
 * Difficulty: Medium
 * Approach: Array / String
 * Time: O(n), Space: O(n)
 */

class RandomizedSet {

    HashMap<Integer,Integer> hashMap;
    ArrayList<Integer> arrayList;
    Random random;

    public RandomizedSet() {
        hashMap = new HashMap<Integer, Integer>();
        arrayList = new ArrayList<Integer>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if (!hashMap.containsKey(val)) {
            arrayList.add(val);
            hashMap.put(val, arrayList.size()-1);
            return true;
        }

        return false;
    }
    
    public boolean remove(int val) {
        if (hashMap.containsKey(val)) {
            Integer index = hashMap.get(val);
            int size = arrayList.size();
            Integer lastVal = arrayList.get(size-1);

            hashMap.put(lastVal, index);
            hashMap.remove(val);

            arrayList.set(index, lastVal);
            arrayList.remove(size-1);
            
            return true;
        }

        return false;
    }
    
    public int getRandom() {
        int sum = arrayList.size();
        int nextInt = random.nextInt(sum);
        return arrayList.get(nextInt);
    }
}
