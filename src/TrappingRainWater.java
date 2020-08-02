
import java.io.*;
import java.util.*;

public class TrappingRainWater {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] str = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            int[] leftArray = new int[n];
            int[] rightArray = new int[n];

            leftArray[0] = arr[0];
            rightArray[n - 1] = arr[n - 1];

            for (int i = 1; i < n; i++) {
                leftArray[i] = Math.max(leftArray[i - 1], arr[i]);
            }

            for (int i = n - 2; i >= 0; i--) {
                rightArray[i] = Math.max(rightArray[i + 1], arr[i]);
            }


            int total = 0;

            for (int i = 0; i < n; i++) {
                total += Math.min(leftArray[i], rightArray[i]) - arr[i];
            }

            System.out.println(total);
            T--;
            System.out.println();

        }

    }
}
