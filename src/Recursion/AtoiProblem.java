package Recursion;

import java.util.Collections;

public class AtoiProblem {

   public static int atoi( String str) {

        int len = str.length();

        if (len == 0)
        {
            return 0; // Handle empty string case
        }

        double num = 0;
        int i = 0;

        while (i < len && str.charAt(i) == ' ')
        {
            i++;
        }

        if (i == len)
        {
            return 0; // All characters are whitespace
        }

        boolean positive = str.charAt(i) == '+';
        boolean negative = str.charAt(i) == '-';

        if (positive)
        {
            i++;
        }
        if (negative)
        {
            i++;
        }

        for (;i < len ; i++)
        {
            if(  str.charAt(i) >= '0' && str.charAt(i) <= '9')
                num = num * 10 + (str.charAt(i) - '0');
            else
                return -1;
        }

        num = negative ? -num : num;
        num = (num > Integer.MAX_VALUE) ? Integer.MAX_VALUE : num;
        num = (num < Integer.MIN_VALUE) ? Integer.MIN_VALUE : num;
        return (int) num;
    }


    public static void main(String[] args) {

        String str = "  1 ";

        int ans = atoi(str);

        System.out.print(ans);
    }
}
