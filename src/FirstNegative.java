import java.util.LinkedList;

public class FirstNegative {
    private static void printFirstNegativeInteger(int[] arr,
                                                  int n, int k) {
        LinkedList<Integer> Di = new LinkedList<>();

        int i;
        for (i = 0; i < k; i++) {
            if (arr[i] < 0) {
                Di.add(i);
            }
        }
        for (; i < n; i++) {
            BaseCase(arr, Di);
            while ((!Di.isEmpty()) &&  Di.peek() < (i - k + 1)) {
                Di.remove();
            }
            if (arr[i] < 0) {
                Di.add(i);
            }
        }
        BaseCase(arr, Di);
    }

    private static void BaseCase(int[] arr, LinkedList<Integer> di) {
        if (!di.isEmpty())
            System.out.print(arr[di.peek()] + " ");
        else
            System.out.print("0" + " ");
    }

    public static void main(String[] args) {
        int[] arr = {12, -1, -7, 8, -15, 30, 16, 28};
        int n = arr.length;
        int k = 3;
        printFirstNegativeInteger(arr, n, k);
    }
}
