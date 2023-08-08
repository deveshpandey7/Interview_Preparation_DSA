package StacksAndQueues;

import java.util.Stack;

public class ValidParanthesis {

    public static void main(String[] args) {

    }


    public boolean isValid(String s) {

        Stack<Character> s1 = new Stack<Character>();

        for( char ch : s.toCharArray()){

            if( ch == '(' || ch == '[' || ch == '{'){
                s1.push(ch);
            }

            else{

                if ( ch == ')' ){

                    if( s1.isEmpty() || s1.pop() != '(' ){
                        return false;
                    }
                }

                if ( ch == ']' ){

                    if( s1.isEmpty() || s1.pop() != '[' ){
                        return false;
                    }
                }

                if ( ch == '}' ){

                    if( s1.isEmpty() || s1.pop() != '{' ){
                        return false;
                    }
                }
            }

        }
        return s1.isEmpty();
    }
}

