package StacksAndQueues;

import java.util.Stack;

public class MaxRectangle {
    public static void main(String[] args) {

        int[][] M = {
                {0,1,1,0},
                {1,1,1,1},
                {1,1,1,1},
                {1,1,0,0}
        };

        int answer = maxRectangle(M);
        System.out.println(answer);

    }
    public static int maxRectangle(int[][] M){

        int n = M.length;
        int m = M[0].length;

        // find area for 1st row
        int area =  largestAreaHistogram(M[0]);

        // for remaining rows find area
        for( int i = 1; i<n; i++){
            for ( int j = 0; j<m; j++){

                // row 1 values will add values of row 0 and so on
                // new row = row + values of above row ie. new histogram row
                if ( M[i][j] != 0 ) // if row value is 0 then upper rows value wont be added
                    M[i][j]  = M[i][j] + M[i-1][j];
                else
                    M[i][j] = 0;

                // entire row is updates find area for row
                int newArea = largestAreaHistogram(M[i]);
                area = Math.max(area,newArea);
            }
        }
        return area;
    }


    public static int largestAreaHistogram(int[] height) {

        int n = height.length;
        int[] next = new int[n];

        next = nextSmallerElement(height);

        int[] before = new int[n];

        before = prevSmallerElement(height);

        int area = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int l = height[i];

            if (next[i] == -1) {
                next[i] = n;
            }

            int b = next[i] - before[i] - 1;
            int newArea = l * b;
            area = Math.max(area, newArea);
        }

        return area;
    }
    public static int[] nextSmallerElement(int[] height ){

        int n = height.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for( int i = n-1; i>=0; i--){
            int cur = height[i];
            while( stack.peek() != -1 && height[stack.peek()] >= cur){
                stack.pop();
            }
            ans[i] = stack.peek();
            stack.push(i);
        }
        return ans;

    }
    public static int[] prevSmallerElement(int[] height ){

        int n = height.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for( int i =0; i<n; i++){
            int cur = height[i];
            while( stack.peek() != -1 && height[stack.peek()] >= cur){
                stack.pop();
            }
            ans[i] = stack.peek();
            stack.push(i);
        }
        return ans;

    }
}
