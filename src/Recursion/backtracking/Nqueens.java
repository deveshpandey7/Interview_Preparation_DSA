package Recursion.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Nqueens {
    public static void main(String[] args) {

        int n = 4;
        // Initialize the chessboard with empty cells - '.' in this case
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        // List to store all valid solutions
        List<List<String>> res = new ArrayList<>();
        // Start the recursive backtracking process
        List<List<String>> ans =  placeQueens(board, 0, res);

        for(List<String> row : ans) {
            for(String num : row)
                System.out.print(num + " ");
            }
            System.out.println();
        }



        // Recursive function to place queens on the board
        private static List<List<String>> placeQueens ( char[][] board, int rowIndex, List<List<String>>res){
            // Base case: If all queens are placed successfully, add the current configuration to the result
            if (rowIndex == board.length) {
                res.add(construct(board));
                return res;
            }

            // Try placing a queen in each column of the current row
            for (int colIndex = 0; colIndex < board.length; colIndex++) {
                if (isSafe(board, rowIndex, colIndex)) {
                    board[rowIndex][colIndex] = 'Q';  // Place the queen

                    // Recursively try placing the queens in the next row
                    placeQueens(board, rowIndex + 1, res);

                    board[rowIndex][colIndex] = '.';  // Remove the queen to backtrack and explore other possibilities
                }
            }
            return res;
        }

        // Function to check if placing a queen at the given position is safe
        private static boolean isSafe ( char[][] board, int row, int col){
            // Check if there is a queen in the same column or in any of the previous rows
            for (int prevRow = 0; prevRow < row; prevRow++) {
                if (board[prevRow][col] == 'Q') {
                    return false;
                }
            }

            // Check if there is a queen in the upper-left diagonal
            for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
                if (board[i][j] == 'Q') {
                    return false;
                }
            }

            // Check if there is a queen in the upper-right diagonal
            for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
                if (board[i][j] == 'Q') {
                    return false;
                }
            }

            return true;  // It is safe to place a queen at the given position
        }

        // Function to construct the final solution from the board configuration
        private static List<String> construct ( char[][] board){
            List<String> res = new LinkedList<>();

            for (int i = 0; i < board.length; i++) {
                String row = new String(board[i]);
                res.add(row);
            }

            return res;
        }
    }



