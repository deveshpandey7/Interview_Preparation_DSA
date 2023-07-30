package Recursion.backtracking;

public class SudokoSolver {
    public static void main(String[] args) {


        int[][] board = new int[][]{
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };

       if (solve(board, 0, 0)){
           display(board);
       }
       else {
           System.out.println("Not possible");
       }
    }


   static private boolean solve(int[][] board, int row, int col) {
        // Base case: If row is equal to board length, entire board has been filled
        if (row == board.length) {
            return true;
        }


        // Move to next row when current row is fully filled
        if (col == board[0].length) {
            return solve(board, row + 1, 0);
        }

        // Skip cells that are already filled
        if (board[row][col] != 0) {
            return solve(board, row, col + 1);
        }

        // Try different numbers in current cell
        for (int num = 1; num <= 9; num++) {
            if (isValidPlacement(board, row, col, num)) {
                board[row][col] = num; // Fill current cell with valid number

                // Move to next cell
                if (solve(board, row, col + 1)) {
                    return true;
                }

                // Backtrack to previous state if solution not found
                board[row][col] = 0;
            }
        }

        // No valid solution found
        return false;
    }

   static private boolean isValidPlacement(int[][] board, int row, int col, int num) {
        // Check if num is already in the same row, column or 3x3 subgrid
       for (int i = 0; i < board.length; i++) {
           // check if the number is in the row
           if (board[row][i] == num) {
               return false;
           }
       }

       // check the col
       for (int[] nums : board) {
           // check if the number is in the col
           if (nums[col] == num) {
               return false;
           }
       }

       int sqrt = (int)(Math.sqrt(board.length));
       int rowStart = row - row % sqrt;
       int colStart = col - col % sqrt;

       for (int r = rowStart; r < rowStart + sqrt; r++) {
           for (int c = colStart; c < colStart + sqrt; c++) {
               if (board[r][c] == num) {
                   return false;
               }
           }
       }
       return true;
   }
    private static void display(int[][] board) {
        for(int[] row : board) {
       //     System.out.println();
            for(int num : row) {
            //    System.out.println();
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
