import java.util.Arrays;
import java.util.Collections;

public class MaxDistanceToClosestPerson {

    public static int maxDistToClosest(int[] seats) {

        int n = seats.length;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = -1;
            if (seats[i] != 1) {
                int left = i;
                int right = i;
                int l = 0, r = 0;

                while (seats[left] != 1 && left != 0) {
                    left--;
                    l++;
                }

                while (seats[right] != 1 && right != n - 1) {
                    right++;
                    r++;
                }

                if (right == n - 1) {
                    arr[i] = Math.max(l, r);
                } else {
                    arr[i] = Math.min(l, r);
                }
            }
        }

        int max = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }

    public static void main(String[] args) {
        int[] seats = {1, 0, 0, 1};
        System.out.println(maxDistToClosest(seats));

        "".contentEquals("aaa");
    }

}
