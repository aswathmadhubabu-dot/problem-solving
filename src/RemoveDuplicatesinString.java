public class RemoveDuplicatesinString {
    int prev = 0;

    private static String removeDuplicates(String str, int prev) {
        int n = str.length();
        if (prev == n)
            return str;

        if(prev > n)
            return str;

        for (int i = prev + 1; i < str.length(); i++) {
            if (str.charAt(prev) == (str.charAt(i))) {
                str = removeDuplicates(str.substring(0, prev) + str.substring(i + 1), prev - 1);
            } else {
                prev++;
            }
        }
        return str;
    }

    public static void main(String[] args) {
        String str = "caaabbbaacdddd";
        System.out.println(removeDuplicates(str, 0));
    }
}
