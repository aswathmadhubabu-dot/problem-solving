import java.io.*;
import java.util.*;

public class Sort012 {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] str = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            int low = 0;
            int high = n - 1;
            int mid = 0;
            while (mid <= high) {
                switch (arr[mid]) {
                    case 0: {
                        Swap(arr, low, mid);
                        low++;
                        mid++;
                        break;
                    }
                    case 1: {
                        mid++;
                        break;
                    }
                    case 2: {
                        Swap(arr, mid, high);
                        high--;
                        break;
                    }

                }
            }
            for (int i : arr) System.out.print(i);
            T--;
        }


    }

    private static void Swap(int[] arr, int low, int mid) {
        int temp = arr[low];
        arr[low] = arr[mid];
        arr[mid] = temp;
    }
}
