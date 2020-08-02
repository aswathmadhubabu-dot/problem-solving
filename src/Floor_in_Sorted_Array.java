import java.util.List;
import java.util.Scanner;

public class Floor_in_Sorted_Array {

    private static void getmin(int[] arr, int x, int low, int high) {
        if (arr.length == 0) {
            return;
        }
        int mid = (low + high) / 2;
        if (low == high) {
            if (low == arr.length - 1) {
                System.out.println(low);
            } else {
                System.out.println(low - 1);
            }
            return;
        }
        if (arr[mid] == x) {
            System.out.println(mid);
            return;
        }
        if (arr[mid] <= x) {
            getmin(arr, x, mid + 1, high);
        }
        if (x <= arr[mid]) {
            getmin(arr, x, low, mid);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        while (T > 0) {
            int number = in.nextInt();
            int x = in.nextInt();
            int[] array = new int[number];
            for (int i = 0; i < number; i++) {
                array[i] = in.nextInt();
            }

            int low = 0;
            int high = array.length - 1;
            getmin(array, x, low, high);

            T--;
        }
    }

}
