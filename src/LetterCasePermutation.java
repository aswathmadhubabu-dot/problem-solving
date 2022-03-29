import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterCasePermutation {
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        permute(s.toCharArray(), result, 0);
        return result;
    }

    public void permute(char[] characters, List<String> result, int j) {
        if (j != characters.length) {
            if (Character.isLetter(characters[j])) {
                characters[j] = Character.toUpperCase(characters[j]);
                permute(characters, result, j + 1);
                characters[j] = Character.toLowerCase(characters[j]);
            }
            permute(characters, result, j + 1);
        }
        else result.add(new String(characters));
    }

    public static void main(String[] args) {
        String s = "a1b2";
        LetterCasePermutation letterCasePermutation = new LetterCasePermutation();
        System.out.println(letterCasePermutation.letterCasePermutation(s));
    }
}
