import java.util.Scanner;

public class MergeSorttwoArrays {

    public static void mergesort(int[] X, int[] Y, int m, int n) {
        for (int i = 0; i < m; i++) {
            if (X[i] > Y[0]) {
                int temp = X[i];
                X[i] = Y[0];
                Y[0] = temp;
                int first = Y[0];
                int k;
                for (k = 1; k < n && Y[k] < first; k++) {
                    Y[k - 1] = Y[k];
                }
                Y[k - 1] = first;
            }
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        while (T > 0) {
            int m = in.nextInt();
            int n = in.nextInt();
            int[] A = new int[m];
            int[] B = new int[n];
            for (int i = 0; i < n; i++) {
                A[i] = in.nextInt();
            }
            for (int i = 0; i < n; i++) {
                B[i] = in.nextInt();
            }
            mergesort(A, B, A.length, B.length);

        }
    }
}
