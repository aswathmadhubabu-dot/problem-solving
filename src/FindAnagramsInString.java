import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAnagramsInString {

    public static List<Integer> findAnagrams(String s, String p) {

        HashMap<Character, Integer> patternMap = new HashMap<>();
        HashMap<Character, Integer> inputStringMap = new HashMap<>();

        for (char ch : p.toCharArray()) {
            patternMap.put(ch, patternMap.containsKey(ch) ? patternMap.get(ch) + 1 : 1);
        }

        int i = 0;
        int j = p.length() - 1;

        List<Integer> output = new ArrayList<>();
        char[] inputStringArr = s.toCharArray();

        while (j < s.length()) {
            if (!patternMap.containsKey(inputStringArr[j])) {
                i = j + 1;
                j = i + p.length() - 1;
                continue;
            }

            for (int k = i; k <= j; k++) {
                inputStringMap.put(inputStringArr[k], inputStringMap.containsKey(inputStringArr[k]) ? inputStringMap.get(inputStringArr[k]) + 1 : 1);
            }

            if (inputStringMap.equals(patternMap)) {
                output.add(i);
            }

            inputStringMap.clear();
            i++;
            j++;
        }
        return output;
    }

    public static void main(String[] args) {
        String s = "abab";
        String p = "ab";

        System.out.println(findAnagrams(s, p));
    }

}
