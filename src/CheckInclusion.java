public class CheckInclusion {
    public static boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false;

        int[] alphabets = new int[26];

        for (char c : s1.toCharArray()) {
            alphabets[c - 'a']++;
        }

        int n = s1.length();

        int i = 0;
        char[] s2AsArr = s2.toCharArray();

        for (char ch : s2AsArr) {
            if (alphabets[ch - 'a'] == 0) {
                while (s2AsArr[i] != ch) {
                    char c = s2AsArr[i];
                    alphabets[c - 'a']++;
                    i++;
                    n++;
                }
                alphabets[s2AsArr[i] - 'a']++;
                i++;
                n++;
            }
            alphabets[ch - 'a']--;

            if (--n == 0) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "cbca";
        System.out.println(checkInclusion(s1, s2));
    }
}
