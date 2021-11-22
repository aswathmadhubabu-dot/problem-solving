import static java.lang.Math.pow;

public class AllPossibleSubSet {
    public static void main(String[] args) {
        int[] a = {5, 1, 2, 7, 6};
        int i = 0;
        while (i < pow(2, a.length)) {
            for (int j = 0; j < a.length; j++)
                if ((i & (1 << j)) > 0)
                    System.out.print(a[j] + " ");
            System.out.println();
            i = i + 1;
        }
        //permutations("","abc");
    }

    private static void permutations(String res, String set) {
        if (res.length() == set.length()) System.out.println(res);
        for (int i = 1; i < (1 << set.length()); i++) {
            for (int j = 0; j < set.length(); j++) {
                if ((i & 1 << j) == 0) {
                    i |= 1 << j; //set available free 0 bit
                    permutations(res + set.charAt(j), set);
                    i &= ~(1 << j); //unset that bit to 0
                }
            }
        }
    }
}
