import org.junit.Assert;

import java.util.Arrays;

public class ArraysSolve {
    // i/p = {1, 3, 5, 6}, {10, 40}
    // o/p = {1, 10, 3, 40, 5, 6}
    // 1, 10, 3, 40, 5, 6

    public static int[] merge(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;

        if(m == 0)
            return arr2;

        if(n == 0)
            return arr1;

        int diff = Math.abs(m - n);
        int i = 0,j = 0;

        int[] result = new int[m + n];
        int k = 0;

        while(diff > 0 && (i< m && j < n)) {
            result[k++] = arr1[i];
            result[k++] = arr2[j];
            i++;
            j++;
            diff--;
        }

        while(i < m) {
            result[k++] = arr1[i];
            i++;
        }

        while(j < n) {
            result[k++] = arr2[j];
            j++;
        }

        return result;
    }


    public static void givenEmptyArrayForOneArrayShouldReturnTheOther() {
        int[] arr1 = new int[]{};
        int[] arr2 = new int[]{10, 40};

        int[] result = merge(arr1, arr2);

        Assert.assertArrayEquals(arr2, result);
    }

    public static void givenArraysOfSingleElementShouldPutFirstArrayElementAtFirst() {
        int[] arr1 = new int[]{5};
        int[] arr2 = new int[]{10};
        int[] expected = new int[] {5, 10};

//        int[]
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1};
        int[] arr2 = new int[]{10, 40};

        System.out.println(Arrays.toString(merge(arr1, arr2)));
        givenEmptyArrayForOneArrayShouldReturnTheOther();
    }


}
