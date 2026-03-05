package cn.itscloudy.mylc.hard;

import java.util.ArrayList;
import java.util.List;

// LeetCode 52
// Solution: Backtracking
public class NQueue {

    public List<List<String>> solveNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        List<List<String>> solutions = new ArrayList<>();
        placeAtRow(solutions, new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1], board,
                0);
        return solutions;
    }

    private void placeAtRow(List<List<String>> solutions, boolean[] cols, boolean[] slashes,
                            boolean[] backSlashes, boolean[][] board, int row) {
        int n = board.length;
        if (row == n) {
            solutions.add(boardToSolution(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            int s = n - 1 - col + row;
            int bs = col + row;
            if (!cols[col] && !slashes[s] && !backSlashes[bs]) {
                cols[col] = true;
                slashes[s] = true;
                backSlashes[bs] = true;
                board[row][col] = true;
                placeAtRow(solutions, cols, slashes, backSlashes, board, row + 1);
                cols[col] = false;
                slashes[s] = false;
                backSlashes[bs] = false;
                board[row][col] = false;
            }
        }
    }

    private List<String> boardToSolution(boolean[][] board) {
        List<String> solution = new ArrayList<>();
        for (boolean[] row : board) {
            StringBuilder s = new StringBuilder();
            for (boolean colInRow : row) {
                s.append(colInRow ? "Q" : ".");
            }
            solution.add(s.toString());
        }
        return solution;
    }
}
