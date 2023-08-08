package StacksAndQueues;

import java.util.ArrayList;
import java.util.Stack;

public class NextSmallerElement {

    public static void main(String[] args) {

//        ArrayList<Integer> A = new ArrayList<Integer>();
//        A.add(4);
//        A.add(5);
//        A.add(2);
//        A.add(10);
//        A.add(8);

        int[] A = {4, 5, 2, 10, 8};

        int[] ans = prevSmaller(A);
        for (int n : ans) {
            System.out.println(n + " ");
        }
    }

    public static int[] prevSmaller(int[] A) {
//        Stack<Integer> stack = new Stack<>();
//        int[] arr=new int[A.length];
//        for(int i=0;i<A.length;i++){
//            int x=-1;
//            while(!stack.isEmpty() && stack.peek()>=A[i]){
//                stack.pop();
//            }
//            if(!stack.isEmpty()){
//                x=stack.peek();
//            }
//            arr[i]=x;
//            stack.push(A[i]);
//        }
//        return arr;
//    }
//}

        int n = A.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<Integer>();
        st.push(-1);


        for (int i = 0; i < A.length; i++) {
            int element = A[i];
            while (st.peek() >= element) {
                st.pop();
            }
            res[i] = st.peek();
            st.push(element);
        }
        return res;
    }
}

//         for( int i = 0; i<A.length; i++){
//         while( st.peek() != -1 && A[st.peek()] >= A[i]){
//                  if( st.peek() > A[i] ){
//                      st.pop();
//                  }
//                 st.pop();
//              }
//              res[i] = st.peek();
//              st.push(i);
//       }
//        return res;
//    }
//}
