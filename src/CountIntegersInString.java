import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountIntegersInString {

    public static String addNumber(String string, int n, boolean inverse) throws NullPointerException, IllegalArgumentException {

        if (string == null) {
            throw new NullPointerException();
        }
        if (n < 0 && string != null) {
            throw new IllegalArgumentException();
        }

        Matcher matcher = Pattern.compile("(\\d+)").matcher(string);
        StringBuilder result = new StringBuilder();

        while (matcher.find()) {
            StringBuilder replacement = new StringBuilder();
            replacement.append(Integer.parseInt(matcher.group(1)) + n);
            matcher.appendReplacement(result, inverse
                    ? String.valueOf(replacement.reverse())
                    : String.valueOf(replacement));
        }

        matcher.appendTail(result);
        return result.toString();
    }

    public static void main(String[] args) {
        String str = "I don't handle real number such as 10.4";

        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                String s = String.valueOf(str.charAt(i));
                str = str.replace(s, " ");
            }
        }

        String[] splitString = str.split(" ");

        int count = 0;
        for (String s : splitString) {
            if (s.length() > 0 && Integer.parseInt(s) > 0) {
                count++;
            }
        }

        System.out.println(addNumber("-12345", 10, false));
    }
}
