package search;

public class search {
    public static void main(String[] args) {
       Solution solution = new Solution();
       int[] nums={4,5,6,7,0,1,2};
       int search = solution.search(nums, 0);
       System.out.println(search);
    }
}

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