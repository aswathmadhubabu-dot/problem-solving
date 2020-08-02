import java.io.*;
import java.util.*;

public class BitCoins {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();

        while (T > 0) {
            int n = in.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            int x = in.nextInt();
            int total[] = new int[x + 1];

            total[0] = 1;
            int m = arr.length;
            for (int i = 0; i < m; i++) {
                for (int j = arr[i]; j <= x; j++) {
                    total[j] += total[j - arr[i]];
                }
            }

            System.out.println(total[x]);
            T--;

        }
    }
}
