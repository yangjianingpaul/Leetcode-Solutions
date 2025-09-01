package 79. Word Search;

public class exist {
    
}

/**
 * Problem: 79. Word Search
 * Difficulty: Medium
 * Approach: Backtracking
 * Time: O(n), Space: O(n)
 */

class Solution {
    boolean flag=false;
    public void dfs(char[][] board, String word, int row,int vol, int index){
        if(word.length()==index){
            flag=true;
            return;
        }

        if(row-1>=0 && board[row-1][vol]==word.charAt(index)){
            board[row-1][vol]='-';
            dfs(board,word,row-1,vol,index+1);
            if(flag){
                return;
            }
            board[row-1][vol]=word.charAt(index);
        }

        if(row+1<board.length && board[row+1][vol]==word.charAt(index)){
            board[row+1][vol]='-';
            dfs(board,word,row+1,vol,index+1);
            if(flag){
                return;
            }
            board[row+1][vol]=word.charAt(index);
        }
        

        if(vol-1>=0 && board[row][vol-1]==word.charAt(index)){
            board[row][vol-1]='-';
            dfs(board,word,row,vol-1,index+1);
            if(flag){
                return;
            }
            board[row][vol-1]=word.charAt(index);
        }
        

        if(vol+1<board[0].length && board[row][vol+1]==word.charAt(index)){
            board[row][vol+1]='-';
            dfs(board,word,row,vol+1,index+1);
            if(flag){
                return;
            }
            board[row][vol+1]=word.charAt(index);
        }

        return;
    }
    public boolean exist(char[][] board, String word) {
        if(word.length()>(board.length*board[0].length)){
            return false;
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    board[i][j]='-';
                    dfs(board,word, i, j, 1);
                    if(flag){
                        return true;
                    }
                    board[i][j]=word.charAt(0);
                }
            }
        }

        return false;
    }
}