package backtracking;

import java.util.*;

public class Nqueens {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] board = new int[n][n];

        int count = solve(board, 0);
        System.out.println(count);
    }

    static int solve(int[][] board, int col) {
        if (col == board.length) {
            // Found a valid configuration
            return 1;
        }

        int count = 0;
        for (int row = 0; row < board.length; row++) {
            if (safe(board, row, col)) {
                board[row][col] = 1;
                count += solve(board, col + 1);
                board[row][col] = 0; // backtrack
            }
        }
        return count;
    }

    static boolean safe(int[][] board, int row, int col) {
        // Check left side of the current row
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1)
                return false;
        }

        // Check upper-left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1)
                return false;
        }

        // Check lower-left diagonal
        for (int i = row, j = col; i < board.length && j >= 0; i++, j--) {
            if (board[i][j] == 1)
                return false;
        }

        return true;
    }
}
