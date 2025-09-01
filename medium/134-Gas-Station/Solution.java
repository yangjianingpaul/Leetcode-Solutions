/**
 * Problem: 134. Gas Station
 * Difficulty: Medium
 * Approach: Array / String
 * Time: O(n), Space: O(n)
 */

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length=gas.length;
        for(int i=0;i<length;i++){
            int sum=0;
            for(int j=0;j<length;j++){
                int index=0;
                if(i+j<length){
                    index=i+j;
                } else {
                    index=(i+j)%length;
                }

                sum+=gas[index];
                if(sum<cost[index]){
                    if(i+j<length){
                        i=index;
                    }else{
                        return -1;
                    }
                    break;
                }else{
                    sum-=cost[index];
                }
                if(j==length-1&&sum>=0){
                    return i;
                }
            }
        }
        return -1;
    }
}