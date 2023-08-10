package StacksAndQueues;

import java.util.Stack;

public class CelebrityProblem {
    public static void main(String[] args) {

        int[][] M = {
                {0,1,0},
                {0,0,0},
                {0,1,0}
        };

        int res = celebrity(M);

        System.out.println(res);
    }


    public static int celebrity(int[][] M){

        int n = M.length;
        Stack<Integer> stack = new Stack<>();

        // step 1 push every one in stack
        for ( int i=0; i<n; i++){
            stack.push(i);
        }
        // step 2 take top two element out
        while( stack.size() > 1 ){
            int a = stack.pop();
            int b = stack.pop();

        //  check if a know b then discard a and push b as a cant be celebrity
         if( M[a][b] == 1 ){
             stack.push(b);
         }
         // else if b knowsa discard b ans push a as b cant be celebrity
            else {
                stack.push(a);
         }
        }
        // only element is left in stack
        // might be an potencial celebrity so check seperately
        int ans  = stack.peek();
        // step 3 check the potencial answer

        // checking for row
        int zerocount = 0;
        for( int i = 0; i<n; i++){ // celebrity knows noone so row should be all 0's
            if( M[ans][i] == 0 ){
                zerocount++;
            }
        }
        if ( zerocount != n )
            return -1;

        // checking for column
        int onecount = 0;
        for( int i = 0; i<n; i++){ // everyone knows celebrity so all column shld be 1's except diagonal
            if( M[i][ans] == 1 ){
                onecount++;
            }
        }
        if ( onecount != n-1 ) // we dont take diagonal column coz celebrity knows himself obviously
            return -1;

        // if here means we have our celebrity
        return ans;
    }
}
