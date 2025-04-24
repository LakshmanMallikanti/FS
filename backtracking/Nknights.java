package backtracking;

import java.util.Scanner;

public class Nknights {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[][] board = new boolean[n][n];
        System.out.println(countKnights(board, 0, 0, n));
    }

    static int countKnights(boolean[][] board, int row, int col, int knights) {
        if (knights == 0) {
            return 1;
        }
        if (row == board.length) {
            return 0;
        }
        if (col == board.length) {
            return countKnights(board, row + 1, 0, knights);
        }

        int count = 0;

        if (isSafe(board, row, col)) {
            board[row][col] = true;
            count += countKnights(board, row, col + 1, knights - 1);
            board[row][col] = false; // backtrack
        }

        count += countKnights(board, row, col + 1, knights);

        return count;
    }

    static boolean isSafe(boolean[][] board, int row, int col) {
        int[] rowMoves = { -2, -1, 1, 2, 2, 1, -1, -2 };
        int[] colMoves = { 1, 2, 2, 1, -1, -2, -2, -1 };
        for (int i = 0; i < rowMoves.length; i++) {
            int newRow = row + rowMoves[i];
            int newCol = col + colMoves[i];
            if (newRow >= 0 && newRow < board.length &&
                    newCol >= 0 && newCol < board.length &&
                    board[newRow][newCol]) {
                return false;
            }
        }
        return true;
    }
}
