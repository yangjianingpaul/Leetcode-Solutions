import java.util.HashSet;

/**
 * Problem: 36. Valid Sudoku
 * Difficulty: Medium
 * Approach: Matrix
 * Time: O(n), Space: O(n)
 */

class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            HashSet<Character> row = new HashSet<Character>();
            HashSet<Character> col = new HashSet<Character>();

            for (int j = 0; j < board[0].length; j++) {
                char rowChar = board[i][j];
                char colChar = board[j][i];
                if (rowChar != '.') {
                    if (row.contains(rowChar)) {
                        return false;
                    } else {
                        row.add(rowChar);
                    }
                }

                if (colChar != '.') {
                    if (col.contains(colChar)) {
                        return false;
                    } else {
                        col.add(colChar);
                    }
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int rowIndex = i * 3;
                int colIndex = j * 3;
                HashSet<Character> matrixSet = new HashSet<Character>();
                for (int p = 0; p < 3; p++) {
                    for (int q = 0; q < 3; q++) {
                        char chr = board[p + rowIndex][q + colIndex];
                        if (chr != '.') {
                            if (matrixSet.contains(chr)) {
                                return false;
                            } else {
                                matrixSet.add(chr);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}