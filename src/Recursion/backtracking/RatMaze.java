package Recursion.backtracking;

import java.util.ArrayList;

public class RatMaze {
    public static void main(String args[]) {

        int[][] m =
                {{1, 0, 0, 0},
                        {1, 1, 0, 1},
                        {1, 1, 0, 0},
                        {0, 1, 1, 1}
        };

        int n = 4;

        String p = "";
        ArrayList<String> res = new ArrayList<>();

        path(m, n, 0, 0, p, res);
     //   System.out.println(res);

    }



    public static  void path(int[][] m, int n, int row, int col, String p, ArrayList<String> res ){

        if(row == n-1 && col == n-1){
            System.out.println(p);
            return;
        }

        if (m[row][col] == 0){
            return;
        }

        m[row][col] = 0;

        if( row > 0  ){
            path(m, n, row-1, col, p + 'U', res );
        }

        if( row < n-1 ){
            path(m, n, row+1, col, p + 'D', res );
        }

        if( col > 0 ){
            path(m, n, row, col-1, p + 'L', res );
        }

        if( col < n-1 ){
            path(m, n, row, col+1, p + 'R', res );
        }

        m[row][col] = 1;

     //   return res;
    }
}

