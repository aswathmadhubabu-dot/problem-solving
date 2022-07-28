public class AddBinary {
    public String addBinary(String a, String b) {

        int n1 = a.length();
        int n2 = b.length();

        StringBuilder padding = new StringBuilder();
        padding.reverse();
        String paddedA;
        String paddedB;

        if (n1 < n2) {
            while (n1 < n2) {
                padding.append("0");
                n1++;
            }
            paddedA = padding + a;
            padding = new StringBuilder();
        }
        if (n1 > n2) {
            while (n2 < n1) {
                padding.append("0");
                n2++;
            }
            paddedB = padding + b;
            padding = new StringBuilder();
        }

        return "";

    }

    // 01 and 11
    public String addTwoBinaryOfSameLength(String a, String b) {
        int n = a.length() - 1;
        char[] binaryValueA = a.toCharArray();
        char[] binaryValueB = b.toCharArray();
        int carry;
        String sum;

        while (n >= 0) {
            int num1 = Character.getNumericValue(binaryValueA[n]);
            int num2 = Character.getNumericValue(binaryValueB[n]);

            int result = num1 ^ num2;
            carry = result == 0 ? 1 : 0;


        }
        return "";
    }

    public static void main(String[] args) {

    }

}
