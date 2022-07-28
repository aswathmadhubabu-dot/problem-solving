import java.util.Arrays;

public class MMT {

    // Input: list1 = [1,2,4], list2 = [1,3,4]
    // Output: [1,1,2,3,4,4]

    public static int[] mergeLists(int[] list1, int[] list2) {
        int m = list1.length;
        int n = list2.length;

        if (m == 0)
            return list2;

        if (n == 0)
            return list1;

        int[] result = new int[m + n];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < m && j < n) {
            if (list1[i] < list2[j]) {
                result[k] = list1[i];
                i++;
            } else if (list1[i] > list2[j]) {
                result[k] = list2[j];
                j++;
            } else if (list1[i] == list2[j]) {
                result[k] = list1[i];
                i++;
            }
            k++;
        }

        while (i < m) {
            result[k] = list1[i];
            i++;
            k++;
        }

        while (j < n) {
            result[k] = list2[j];
            j++;
            k++;
        }

        return result;

    }


    public static void main(String[] args) {
        int[] arr1 = {1, 2, 4};
        int[] arr2 = {1, 3, 4};

        System.out.println(Arrays.toString(mergeLists(arr1, arr2)));

    }
}
