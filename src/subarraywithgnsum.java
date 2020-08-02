/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class subarraywithgnsum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T > 0) {
            int n = in.nextInt();
            int sum = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            int cur_sum = 0;
            int j = 0;
            for (int i = 0; i < n; i++) {
                cur_sum += arr[i];
                if (cur_sum > sum) {
                    cur_sum = cur_sum - arr[j++];
                }
                if (cur_sum == sum) {
                    System.out.println(j + 1 + " " + (i + 1));
                }
            }
            T--;
        }
    }
}

