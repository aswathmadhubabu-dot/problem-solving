public class AddDigits {

    public static int addDigits(int num) {
        while (num > 9) {
            int n = num;
            int sum = 0;
            while (n != 0) {
                sum += n % 10;
                n /= 10;
            }
            num = sum;
        }
        return num;
    }


    public static void main(String[] args) {
        int num = 38;
        System.out.println(addDigits(num));
    }
}
