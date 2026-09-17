class Solution {

    public int totalNQueens(int n) {
        char[][] board = new char[n][n];

        // Fill board with empty cells
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        return solve(0, n, board);
    }

    public int solve(int row, int n, char[][] board) {

        // All queens are placed
        if (row == n) {
            return 1;
        }

        int count = 0;

        // Try every column in the current row
        for (int col = 0; col < n; col++) {

            if (isSafe(row, col, n, board)) {

                // Choose
                board[row][col] = 'Q';

                // Explore
                count += solve(row + 1, n, board);

                // Undo
                board[row][col] = '.';
            }
        }

        return count;
    }

    public boolean isSafe(int row, int col, int n, char[][] board) {

        // Check same column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0;
             i--, j--) {

            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < n;
             i--, j++) {

            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }
}