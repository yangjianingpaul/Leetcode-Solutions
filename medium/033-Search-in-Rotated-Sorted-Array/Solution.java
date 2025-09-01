/**
 * Problem: 33. Search in Rotated Sorted Array
 * Difficulty: Medium
 * Approach: Binary Search
 * Time: O(n), Space: O(n)
 */

class Solution {
    public int search(int[] nums, int target) {
        int head=0;
        int end=nums.length-1;

        while(head<=end){
            if(nums[head]==target){
                return head;
            }

            if(nums[end]==target){
                return end;
            }
            int mid=(head+end)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[head]>target&&nums[end]>target){
                if(nums[mid]<target){
                    end=mid-1;
                } else {
                    head=mid+1;
                }
            }else if(nums[head]<target&&nums[end]<target){
                if(nums[mid]<target){
                    head=mid+1;
                } else {
                    end=mid-1;
                }
            }else if(nums[head]>target && nums[end]<target){
                return -1;
            }else{
                if(nums[mid]>target){
                    end=mid-1;
                }else if(nums[mid]<target){
                    head=mid+1;
                }
            }
        }

        return -1;
    }
}