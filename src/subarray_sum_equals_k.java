public class subarray_sum_equals_k {

    public static void main(String[] args) {
        int[] arr = {10, 2, -2, -20, 10};
        int k = -10;
        int start = 0;
        int window = 0;
        int sum = 0;
        for (int i1 : arr) {
            window += i1;
            if (window == k) {
                sum++;
            }
            if (window > k) {
                window -= arr[start];
                start++;
            }
        }

        System.out.print(sum);
    }
}
