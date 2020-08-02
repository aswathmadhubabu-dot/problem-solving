public class IntegertoRoman {

    private static String Roman(int num) {
        String r = "";
        int[] decimal = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        for (int i = 0; i < decimal.length; i++) {
            while (num >= decimal[i]) {
                num = num - decimal[i];
                r += roman[i];
            }
        }

        return r;
    }

    public static void main(String[] args) {

        System.out.println(Roman(1985));
    }
}
