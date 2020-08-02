import java.io.*;
import java.util.*;

public class RotateAnArray {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        while (T > 0) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            int d = in.nextInt();

            for (int j = d; j < n; j++) {
                System.out.print(arr[j]);
            }
            for (int j = 0; j < d; j++) {
                System.out.print(arr[j]);
            }
            System.out.print("\n");
            T--;
        }
    }
}
