// class Solution {
// public int removeElement(int[] nums, int val) {
// List<Integer> arrayList = new ArrayList<Integer>();
// for (int i = 0; i < nums.length; i++) {
// if (nums[i] != val) {
// arrayList.add(nums[i]);
// }
// }
// for (int i = 0; i < arrayList.size(); i++) {
// nums[i] = arrayList.get(i);
// }
// return arrayList.size();
// }
// }

// class Solution {
//     public int removeElement(int[] nums, int val) {
//         int index = 0;
//         for (int i = 0; i < nums.length; i++) {
//             if (nums[i] != val) {
//                 nums[index] = nums[i];
//                 index++;
//             }
//         }

//         return index;
//     }
// }


/**
 * Problem: 27. Remove Element
 * Difficulty: Easy
 * Approach: Array / String
 * Time: O(n), Space: O(n)
 */

class Solution {
    public int removeElement(int[] nums, int val) {
        int indexRemove = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[indexRemove] = nums[i];
                indexRemove++;
            }
        }
        return indexRemove;
    }
}