import java.util.Scanner;

import java.util.*;
import java.lang.*;
import java.io.*;

public class TwoPrime {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        while (T > 0) {
            int n = in.nextInt();

            if (n == 0 || n == 1 || n == 2) {
                return;
            }

            int[] primeArray = new int[n];
            int k = 0;
            for (int i = 2; i < n; i++) {
                if (isPrime(i)) {
                    primeArray[k++] = i;
                }
            }

            int low = 0;
            int high = k - 1;

            while ((primeArray[low] + primeArray[high]) != n) {
                if ((primeArray[low] + primeArray[high]) < n) {
                    low++;
                }
                if ((primeArray[low] + primeArray[high]) > n) {
                    high--;
                }
            }
            System.out.println(primeArray[low] + " " + primeArray[high]);
            T--;
        }
    }

    private static boolean isPrime(int n) {
        boolean isPrime = true;
        for (int i = 2; i <= n / 2; i++) {
            int temp = n % i;
            if (temp == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }
}
