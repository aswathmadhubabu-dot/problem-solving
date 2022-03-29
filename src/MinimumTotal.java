public class MinimumTotal {
    public int minimumTotal(int n) {
        int count = 0;
        int reverse = 0;

        while (n != 0) {
            reverse <<= 1;
            reverse += n % 2;
            n >>>= 1;
            count++;
        }

        int result = reverse << 32 - count;
        return result;
    }

    public static void main(String[] args) {

    }

}
