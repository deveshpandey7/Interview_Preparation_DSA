package StacksAndQueues;

import java.util.Stack;

public class LargestAreaHistogram {

    public static void main(String[] args) {

        int[] height = {2, 3, 4, 5, 7, 0, 1};

        int n = height.length;

        System.out.println( largestAreaHistogram(height));
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
