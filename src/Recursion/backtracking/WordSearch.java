package Recursion.backtracking;

public class WordSearch {

    public static void main(String[] args) {

        char[][] board = {{'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        boolean[][] visited = new boolean[board.length][board[0].length];

         String name = "ABCDEE";

         char[] word = name.toCharArray();

        System.out.println( search(board, visited, 0, 0,0, word));
    }

    public static boolean search(char[][] board, boolean[][] visited, int row, int col, int index, char[] word) {

        int n = word.length;
        if (index == n-1 ) {
            return true;
        }



        if (row == board.length - 1 && col == board.length) {
            return false;
        }

        if (visited[row][col] == true) {
            return false;
        }


        if (col == board[row].length - 1) {
            return search(board, visited, row + 1, 0, index, word);
        }


        if (board[row][col] != word[index]) {
            return search(board, visited, row, col + 1, index, word);
        }

        visited[row][col] = true;
        if (isString(board, visited, row, col, index, word)) {
            return true;
        }

        visited[row][col] = false;
        return search(board, visited, row, col + 1, index, word);

    }
    public static boolean isString (char[][] board, boolean[][] visited, int row, int col, int index, char[] word) {

             if (row > 0 && board[row - 1][col] == word[index + 1]) {
                return search(board, visited, row - 1, col, index + 1, word);
            }
            if (row < board.length - 1 && board[row + 1][col] == word[index + 1]) {
                return search(board, visited, row + 1, col, index + 1, word);
            }
            if (col > 0 && board[row][col - 1] == word[index + 1]) {
                return search(board, visited, row, col - 1, index + 1, word);
            }
            if (col < board[row].length - 1 && board[row][col + 1] == word[index + 1]) {
                return search(board, visited, row, col + 1, index + 1, word);
            }

            return false;
        }

}
