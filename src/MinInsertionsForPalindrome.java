/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class MinInsertionsForPalindrome {

    private static int minPermutations(String[] str, int l, int h) {
        if (l > h)
            return Integer.MAX_VALUE;
        if (l == h)
            return 0;

        if (l == h - 1)
            return (str[l].equals(str[h])) ? 0 : 1;

        return (str[l].equals(str[h]))
                ? minPermutations(str, l + 1, h - 1)
                : Math.min(minPermutations(str, l, h - 1), minPermutations(str, l + 1, h)) + 1;
    }

    public static void main(String[] args) throws IOException {
        //code
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T > 0) {
            String[] str = br.readLine().split("");
            System.out.println(minPermutations(str, 0, str.length - 1));
            T--;
        }
    }
}