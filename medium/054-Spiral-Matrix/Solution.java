import java.util.ArrayList;
import java.util.List;

/**
 * Problem: 54. Spiral Matrix
 * Difficulty: Medium
 * Approach: Matrix
 * Time: O(n), Space: O(n)
 */

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int flag=0;
        int row=matrix.length;
        int vol=matrix[0].length;
        int rowHead=0;
        int rowEnd=vol-1;
        int volHead=0;
        int volEnd=row-1;

        int rowIndex=0;
        int volIndex=0;

        List<Integer> list=new ArrayList<>();

        while(list.size()<row*vol){
            if(flag==0){
                list.add(matrix[rowIndex][volIndex]);
                if(volIndex==rowEnd){
                    flag=1;
                    rowHead++;
                    rowIndex++;
                    continue;
                }else{
                    volIndex++;
                }
            }

            if(flag==1){
                list.add(matrix[rowIndex][volIndex]);
                if(rowIndex==volEnd){
                    flag=2;
                    volEnd--;
                    volIndex--;
                    continue;
                }else{
                    rowIndex++;
                }
            }

            if(flag==2){
                list.add(matrix[rowIndex][volIndex]);
                if(volIndex==volHead){
                    flag=3;
                    rowEnd--;
                    rowIndex--;
                    continue;
                }else{
                    volIndex--;
                }
            }

            if(flag==3){
                list.add(matrix[rowIndex][volIndex]);
                if(rowIndex==rowHead){
                    flag=0;
                    volHead++;
                    volIndex++;
                }else{
                    rowIndex--;
                }
            }
        }
        return list;
    }
}