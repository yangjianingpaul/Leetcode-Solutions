package merge;
import java.util.Arrays;

public class Merge {
    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 3, 0, 0, 0 };
        int[] nums2 = { 2, 5, 6 };
        Solution solution = new Solution();
        solution.merge(nums1, 3, nums2, 3);
    }
}

// class Solution {
//     public void merge(int[] nums1, int m, int[] nums2, int n) {
//         for (int i = m; i < nums1.length; i++) {
//             nums1[i] = nums2[i - m];
//         }
//         Arrays.sort(nums1);
//     }
// }

// class Solution {
//     public void merge(int[] nums1, int m, int[] nums2, int n) {
//         int index1=m-1;
//         int index2=n-1;
//         for(int i=nums1.length-1;i>=0;i--){
//             if(index1>=0&&index2>=0){
//                 if(nums1[index1]>nums2[index2]){
//                     nums1[i]=nums1[index1];
//                     index1--;
//                 }else{
//                     nums1[i]=nums2[index2];
//                     index2--;
//                 }
//             } else {
//                 if(index1>=0){
//                     nums1[i]=nums1[index1];
//                     index1--;
//                 }

//                 if(index2>=0){
//                     nums1[i]=nums2[index2];
//                     index2--;
//                 }
//             }
//         }
//     }
// }


/**
 * Problem: 88. Merge Sorted Array
 * Difficulty: Easy
 * Approach: Array / String
 * Time: O(n), Space: O(n)
 */

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = nums1.length - 1;
        int index1 = m - 1;
        int index2 = n - 1;

        while (index1 >= 0 && index2 >= 0) {
            if (nums1[index1] > nums2[index2]) {
                nums1[index] = nums1[index1];
                index1--;
            } else {
                nums1[index] = nums2[index2];
                index2--;
            }
            index--;
        }

        if (index1 >= 0) {
            for (int i = index; i >= 0; i--) {
                nums1[i] = nums1[index1];
                index1--;
            }
        }

        if (index2 >= 0) {
            for (int i = index; i >= 0; i--) {
                nums1[i] = nums2[index2];
                index2--;
            }
        }
        
        return;
    }
}