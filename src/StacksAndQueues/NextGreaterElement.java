package StacksAndQueues;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement {

    public static void main(String[] args) {


        int[] A = { 1,2,3,4,3 };

        int n = A.length;
        int[] ans = CircularnextGreaterElements(A);
        for (int an : ans) {
            System.out.println( an+ " ");

        }
    }


    public static int[] nextGreaterElement(int[] arr, int n) {

        int[] res = new int[n];
        Stack<Integer> st = new Stack<Integer>();
        st.push(-1);


        for (int i = n - 1; i >= 0; i--) {
            int element = arr[i];
            while ( st.peek() != -1 && st.peek() <= element) {
                st.pop();
            }
            res[i] = st.peek();
            st.push(element);
        }
        return res;
    }


    // leetcode question
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int n = nums2.length;
        //   int[] res = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<Integer>();
        st.push(-1);
        map.put(nums2[n-1],-1);


        for(int i = nums2.length-1; i>=0; i--) {
            int element = nums2[i];
            while ( st.peek() != -1 && st.peek() <= element) {
                st.pop();
            }
            //   res[i] = st.peek();
            map.put(nums2[i], st.peek());
            st.push(element);
        }

        int ans[] = new int[nums1.length];
        for(int i=0; i<nums1.length; i++){
            ans[i] = map.get(nums1[i]);
        }
        return ans;

    }

// circular queue
    public static int[] CircularnextGreaterElements(int[] nums) {

        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<Integer>();
        st.push(-1);


        for (int i = (2*n)-1 ; i >= 0; i--) {

            int element = nums[i%n];
            while ( st.peek() != -1 && st.peek() <= element) {
                st.pop();
            }
            res[i%n] = st.peek();
            st.push(element);
        }
        return res;
    }
}



