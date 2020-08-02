/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class SmallestElement {
    public static void main (String[] args) {
        //code
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        while(T > 0)
        {
            int n = in.nextInt();
            int[] array = new int[n];
            for(int i=0; i<n; i++)
            {
                array[i] = in.nextInt();
            }
            int next =1;
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<n; j++)
            {
                if(j == n-1)
                {
                    sb.append(" "+-1);
                }
                else if(array[j] > array[next])
                {
                    sb.append(array[next]+ " ");
                }
                else
                {
                    sb.append(-1+ " " );
                }
                next++;
            }
                System.out.print(sb.toString());
                System.out.print("\n");
            T--;
        }

    }
}