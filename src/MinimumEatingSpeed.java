import java.util.Arrays;

public class MinimumEatingSpeed {
    public static int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        if (piles.length == h)
            return piles[h - 1];

        return getMinEatingSpeed(piles, 0, piles.length - 1, h);
    }

    public static int getMinEatingSpeed(int[] piles, int low, int high, int hours) {
        int mid = (low + high) / 2;

        int hoursTookToEat = hoursToEat(mid, piles);
        if (hoursTookToEat == hours)
            return piles[mid];

        if (hoursTookToEat < hours)
            high = mid;

        if (hoursTookToEat > hours)
            low = mid + 1;

        if (low + 1 == high)
            getMinEatingSpeedBetweenRange(piles[low], piles[high], hours, piles);

        return getMinEatingSpeed(piles, low, high, hours);
    }

    public static int getMinEatingSpeedBetweenRange(int low, int high, int hours, int[] piles) {
        int mid = (low + high) / 2;
        int hoursTookToEat = hoursToEat(mid, piles);

        if (hoursTookToEat == hours)
            return mid;

        if (hoursTookToEat < hours)
            high = mid - 1;

        if (hoursTookToEat > hours)
            low = mid + 1;

        return getMinEatingSpeedBetweenRange(low, high, hours, piles);
    }

    public static int hoursToEat(int eatingSpeedIndex, int[] piles) {
        int hoursToEatBasedOnEatingSpeed = eatingSpeedIndex;
        int eatingSpeed = piles[eatingSpeedIndex];

        for (; eatingSpeedIndex < piles.length; eatingSpeedIndex++) {
            hoursToEatBasedOnEatingSpeed += Math.ceil((double) piles[eatingSpeedIndex] / eatingSpeed);
        }

        return hoursToEatBasedOnEatingSpeed;
    }

    public static void main(String[] args) {
        int[] arr = {3, 6, 7, 11};
        int h = 8;
        // System.out.println(minEatingSpeed(arr, h));
        System.out.println("abcde".indexOf("bl"));
    }
}
